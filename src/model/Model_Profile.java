/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author hocgioinhatlop
 */
public class Model_Profile {
    String name;
    String description;
    Icon image;

    public Model_Profile() {
    }

    public Model_Profile(String name, String description, Icon image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
    
}
