package component;

import event.EventLoadMusic;
import event.EventShowLyricWithId;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.List;
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
public class ListPlaylist<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;
    private EventLoadMusic event;
    private int position = -1;

    public void addEventLoadMusic(EventLoadMusic event) {
        this.event = event;
    }
    private EventShowLyricWithId eventShowLyric;

    public void addEventShowLyricWithId(EventShowLyricWithId event) {
        this.eventShowLyric = event;
    }

    public void setPlayingIndex̣x(int index) {
        playIndex = index;
        repaint();
    }

    public ListPlaylist() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    position = locationToIndex(me.getPoint());
                    Model_Music item = (Model_Music) model.get(position);
                    if (checkMouseOver(me.getPoint())) {
                        int check = SingletonMusicService.getMusicServiceInstance().checkExistInPlaylist(item.getSongId());
                        if (check != -1) {
                            
                            SingletonMusicService.getMusicServiceInstance().removeToPlaylist(check);
                             List<Model_Music> result = singleton.SingletonMusicService.getMusicServiceInstance().getPlaylist();
                            if(result.size()>0 && playIndex == locationToIndex(me.getPoint())){
                                SingletonMusicService.getMusicServiceInstance().loadPlaylist();
                                if(result.size()>locationToIndex(me.getPoint()))
                                {
                                    SingletonMusicService.getMusicServiceInstance().playIndexPlaylist(locationToIndex(me.getPoint()));
                                }else{
                                    SingletonMusicService.getMusicServiceInstance().playIndexPlaylist(0);
                                }
                                
                            }else{
                                //SingletonMusicService.getMusicServiceInstance().stopMusic();
                            }
                           
                            if (result != null && result.size() > 0) {
                                clearData();
                                int no = 0;
                                for (Model_Music song : result) {
                                    song.setNo(String.valueOf(no + 1));
                                    addItem(song);
                                    no++;
                                }
                            } else {
                                clearData();
                                playIndex = -1;
                            }
                        }

                        repaint();
                        return;
                    } else if(checkMouseOverAddSong(me.getPoint())){
                       eventShowLyric.showLyric(item.getSongId());
                       return;
                    }
                    else {
                        playIndex = locationToIndex(me.getPoint());
                        if (playIndex != -1) {
                            SingletonMusicService.getMusicServiceInstance().playIndexPlaylist(playIndex);
                        }
                        if (event != null) {
                            event.loadMusic(); // load time music lên main frame
                        }
                        repaint();
                    }
                }
            }

        });
    }

    private boolean checkMouseOver(Point mouse) {
        int width = this.getWidth();
        int height = 35;
        int height2 = 35 * position;
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        Point point = new Point(width - height + 10, height2 + marginButton);
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
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Model_Music data;
                if (o instanceof Model_Music) {
                    data = (Model_Music) o;
                } else {
                    data = new Model_Music("1", "No Music", "00:00");
                }
                ItemMusicInPlaylist item = new ItemMusicInPlaylist(data);
                item.setPlay(index == playIndex);
                return item;
            }

        };
    }

    public void addItem(Model_Music data) {
        model.addElement(data);
    }

    public void clearData() {
        model.removeAllElements();
    }

}
