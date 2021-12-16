
package component;

import event.EventLoadMusic;
import event.EventShowLyricWithId;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import model.Model_Music;
import singleton.SingletonMusicService;

/**
 *
 * @author hocgioinhatlo
 * @param <E>
 */
public class ListMusic<E extends Object> extends JList<E>{
    private final DefaultListModel model;
    private int playIndex = -1;
    private int position = -1;
    private EventLoadMusic event;

    public void addEventLoadMusic(EventLoadMusic event) {
        this.event = event;
    }
    private EventShowLyricWithId eventShowLyric;

    public void addEventShowLyricWithId(EventShowLyricWithId event) {
        this.eventShowLyric = event;
    }
    public void setPlayingIndex(int index)
    {
        playIndex = index;
    }

    public ListMusic() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
               if(SwingUtilities.isLeftMouseButton(me)){
                  // playIndex = locationToIndex(me.getPoint());
                   Model_Music item = (Model_Music) model.get(locationToIndex(me.getPoint()));
                   position = locationToIndex(me.getPoint());
                   if(checkMouseOver(me.getPoint()))
                   {

                       eventShowLyric.showLyric(item.getSongId());
                       return;
                   }
                   else if(checkMouseOverAddSong(me.getPoint()))
                   {
                       int check = SingletonMusicService.getMusicServiceInstance().checkExistInPlaylist(item.getSongId());
                       if ( check == -1) {
                           System.out.println("");
                           SingletonMusicService.getMusicServiceInstance().addToPlaylist(item); 
                       }else{
                           SingletonMusicService.getMusicServiceInstance().removeToPlaylist(check);
                       }
                       repaint();
                       return;
                   }else{
                       playIndex = position;
                       if(playIndex != -1)
                        SingletonMusicService.getMusicServiceInstance().playNew(item.getSongId());
                        SingletonMusicService.getMusicServiceInstance().runEventInitSong();
//                       if(event != null)
//                        event.loadMusic(); // load time music lên main frame
                        repaint();
                   }         
               }
            }
            
        });
    }
    private boolean checkMouseOver(Point mouse) {
        int width = this.getWidth();
        int height = 35;
        int height2 = 35*position;
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        Point point = new Point(width - height + 10, height2+marginButton);
        Ellipse2D.Double circle = new Ellipse2D.Double(point.x, point.y, buttonSize, buttonSize);
        return circle.contains(mouse);
    }
    private boolean checkMouseOverAddSong(Point mouse) {
        int width = this.getWidth();
        int height = 35;
        int height2 = 35*position;
        int marginButton = 3;
        int buttonSize = height - marginButton * 2;
        Point point = new Point(width - height -5, height2+marginButton);
        Ellipse2D.Double circle = new Ellipse2D.Double(point.x, point.y, buttonSize, buttonSize);
        return circle.contains(mouse);
    }
    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
               Model_Music data;
               if(o instanceof Model_Music)
               {
                   data = (Model_Music) o;
               } else {
                   data = new Model_Music("1","No Music","00:00");
               }
               ItemMusic item  = new ItemMusic(data);
               item.setPlay(index == playIndex);
               if(SingletonMusicService.getMusicServiceInstance().checkExistInPlaylist(data.getSongId()) != -1){
                   item.setIconAddSongSelected();
               }
             //  item.autoIconAddSong();
               return item;
            }
            
        };
    }
    public void addItem(Model_Music data){
        model.addElement(data);
    }
     public void clearData(){
        model.removeAllElements();
    }
    
}
