/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author hocgioinhatlop
 */
public class Model_SearchResult {
    private List<Model_Profile> artists;
    private List<Model_Music> songs;
    private int counterSong;
    private int counterArtist;

    public Model_SearchResult() {
    }

    public Model_SearchResult(List<Model_Profile> artists, List<Model_Music> songs, int counterSong, int counterArtist) {
        this.artists = artists;
        this.songs = songs;
        this.counterSong = counterSong;
        this.counterArtist = counterArtist;
    }

    public List<Model_Profile> getArtists() {
        return artists;
    }

    public void setArtists(List<Model_Profile> artists) {
        this.artists = artists;
    }

    public List<Model_Music> getSongs() {
        return songs;
    }

    public void setSongs(List<Model_Music> songs) {
        this.songs = songs;
    }

    public int getCounterSong() {
        return counterSong;
    }

    public void setCounterSong(int counterSong) {
        this.counterSong = counterSong;
    }

    public int getCounterArtist() {
        return counterArtist;
    }

    public void setCounterArtist(int counterArtist) {
        this.counterArtist = counterArtist;
    }
    
}
