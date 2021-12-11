/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author hocgioinhatlop
 */
public class Model_Profile {
    String id;
    String alias;
    String name;
    String description;
    Icon image;
    String birthday;
    String realName;
    String national;
    List<Model_Music> album;

    public List<Model_Music> getAlbum() {
        return album;
    }

    public void setAlbum(List<Model_Music> album) {
        this.album = album;
    }
    
    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    

    public Model_Profile() {
    }

    public Model_Profile(String id,String alias,String name, String description, Icon image,String birthday,String realName,String national) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.id = id;
        this.alias = alias;
        this.realName = realName;
        this.birthday = birthday;
        this.national = national;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
