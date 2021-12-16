/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author hocgioinhatlop
 */
public class Model_Music implements Serializable{
    private String no;
    String name;
    String time;
    int duration;
    String songId;//encodeId
    String artistsNames;
    String lyric;

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
    
    

    public String getArtistsNames() {
        return artistsNames;
    }

    public void setArtistsNames(String artistsNames) {
        this.artistsNames = artistsNames;
    }
    

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }
    
    

    public Model_Music() {
    }

    public Model_Music(String no, String name, String time) {
        this.no = no;
        this.name = name;
        this.time = time;
    }

    public Model_Music(String no, String name, String time, int duration, String songId, String artistsNames) {
        this.no = no;
        this.name = name;
        this.time = time;
        this.duration = duration;
        this.songId = songId;
        this.artistsNames = artistsNames;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
