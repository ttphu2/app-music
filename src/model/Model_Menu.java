
package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Model_Menu {
    String menuName;
    String icon;

    public Model_Menu() {
    }
    

    public Model_Menu(String menuName, String icon) {
        this.menuName = menuName;
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/icon/" + icon + ".png"));
    }
    public Icon toIconSelected(){
        return new ImageIcon(getClass().getResource("/icon/"+icon +"_selected.png"));
    }
}
