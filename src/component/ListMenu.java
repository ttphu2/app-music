
package component;

import event.EventMenuClear;
import event.EventMenuSelected;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import model.Model_Menu;

/**
 *
 * @author hocgioinhatlo
 * @param <E>
 */
public class ListMenu<E extends Object> extends JList<E>{
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected event)
    {

        this.event = event;
    }
    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if(SwingUtilities.isLeftMouseButton(me)){
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    selectedIndex = index;
                    if(event != null)
                    {
                        event.selected(index);
                        
                    }
                    repaint();
                }
            }
            
        });
        setOpaque(false);
    }
    
    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
               Model_Menu data;
               if(o instanceof Model_Menu)
               {
                   data = (Model_Menu) o;
               } else {
                   data = new Model_Menu("No Data","song");
               }
               ItemMenu item  = new ItemMenu(data);
               item.setSelected(selected);
               
               return item;
            }
            
        };
    }
    public void addItem(Model_Menu data){
        model.addElement(data);
    }
    
}
