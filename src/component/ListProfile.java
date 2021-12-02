package component;

import event.EventArtistSelected;
import form.Form_ArtistDetail;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import model.Model_Music;
import model.Model_Profile;
import singleton.SingletonMusicService;

public class ListProfile<E extends Object> extends JList<E> {

    private final DefaultListModel model;
     private int selectedIndex = -1;
     private EventArtistSelected event;
    public void addEventArtistSelected(EventArtistSelected event)
    {

        this.event = event;
    }
    public ListProfile() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
         addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
               if(SwingUtilities.isLeftMouseButton(me)){
                   int index = locationToIndex(me.getPoint());
                   Model_Profile item = (Model_Profile) model.get(index);
                   System.out.println(item.getAlias());
                   selectedIndex = index;
                   if(event != null)
                    {
                        event.selected(index,item.getAlias());
                        
                    }
                   repaint();
               }
            }
            
        });
    }

    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Model_Profile data;
                if (o instanceof Model_Profile) {
                    data = (Model_Profile) o;
                } else {
                    data = new Model_Profile("0","none","Name", "Description", new ImageIcon(getClass().getResource("/icon/artists_selected.png")));
                }
                ItemProfile item = new ItemProfile(data);
                return item;
            }
        };
    }

    public void addItem(Model_Profile data) {
        model.addElement(data);
    }
}
