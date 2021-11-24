/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class HomeDataRes {
    public int type;
    public String link;
    public String banner;
    public String cover;
    public String target;
    public String title;
    public String description;
    public int ispr;
    public String encodeId;

    public HomeDataRes(int type, String link, String banner, String cover, String target, String title, int ispr, String encodeId) {
        this.type = type;
        this.link = link;
        this.banner = banner;
        this.cover = cover;
        this.target = target;
        this.title = title;
        this.ispr = ispr;
        this.encodeId = encodeId;
    }

    public HomeDataRes() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIspr() {
        return ispr;
    }

    public void setIspr(int ispr) {
        this.ispr = ispr;
    }

    public String getEncodeId() {
        return encodeId;
    }

    public void setEncodeId(String encodeId) {
        this.encodeId = encodeId;
    }
    
    
}
