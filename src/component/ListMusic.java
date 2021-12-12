
package component;

import event.EventLoadMusic;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import model.Model_Menu;
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
    private EventLoadMusic event;

    public void addEventLoadMusic(EventLoadMusic event) {
        this.event = event;
    }
    public ListMusic() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
               if(SwingUtilities.isLeftMouseButton(me)){
                   playIndex = locationToIndex(me.getPoint());
                   Model_Music item = (Model_Music) model.get(playIndex);
                   if(playIndex != -1)
                   SingletonMusicService.getMusicServiceInstance().playNew(item.getSongId());
                   if(event != null)
                   event.loadMusic();
                   repaint();
               }
            }
            
        });
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
