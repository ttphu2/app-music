/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import event.EventInitSong;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_Music;

/**
 *
 * @author hocgioinhatlop
 */
public class MusicService {

    public static MP3Player mP3Player;
    public static List<Model_Music> myPlaylist;
    public static boolean playPlaylist = false;
    public static Model_Music mySong;
    private EventInitSong eventInitSong;
    Boolean repeat=true;
    private static int volume=50;

    public void addEventInitSong(EventInitSong event) {
        this.eventInitSong = event;
    }

    // private static List<String> playList = 
    //http://api.mp3.zing.vn/api/streaming/audio/ZUC7DBEC/128
    public void runEventInitSong() {
        if (eventInitSong != null) {
            eventInitSong.initSong(getCurrentSong());
        }
    }

    public MusicService() {
        mP3Player = new MP3Player();
        myPlaylist = new ArrayList<>();
        mP3Player.setRepeat(true);
    }

    public void init() {
        mP3Player.setRepeat(repeat);
        mP3Player.setVolume(volume);
    }

    public List<Model_Music> getPlaylist() {

        return myPlaylist;
    }

    public Model_Music getCurrentSong() {
        if (playPlaylist == false) {
            return mySong;
        }
        return myPlaylist.get(mP3Player.getPlayingIndex());
    }

    public int getPlayingIndex() {
        if (playPlaylist && myPlaylist.size() > 0) {
            return mP3Player.getPlayingIndex();
        }
        return -1;
    }

    public void playNew(String songId) {
        try {
            mP3Player.stop();
            mP3Player = new MP3Player();
            init();
            mP3Player = mP3Player.add(new URL("http://api.mp3.zing.vn/api/streaming/audio/" + songId + "/128"));
            mP3Player.play();
            playPlaylist = false;
            mySong = singleton.SingletonMusicService.getClientServiceInstance().getInfoSongById(songId);        
        } catch (MalformedURLException ex) {
            Logger.getLogger(MusicService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playIndexPlaylist(int playingIndex) {
        if (myPlaylist.size() > 0) {
            loadPlaylist();
            mP3Player.setPlayingIndex(playingIndex);
            playPlaylist = true;       
            if(eventInitSong != null) eventInitSong.initSong(myPlaylist.get(playingIndex));
            mP3Player.play();
            
        }
    }

    public void loadPlaylist() {
        mP3Player.stop();
        if (myPlaylist.size() > 0) {
            mP3Player = new MP3Player();
            init();
            for (Model_Music item : myPlaylist) {
                try {
                    mP3Player.add(new URL("http://api.mp3.zing.vn/api/streaming/audio/" + item.getSongId() + "/128"));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MusicService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void playMusic() {
        System.out.println("Run music");
        mP3Player.play();
    }

    public void stopMusic() {
        System.out.println("Stop music");
        mP3Player.stop();
    }

    public void pauseMusic() {
        System.out.println("Stop music");
        mP3Player.pause();
    }

    public void addToPlaylist(Model_Music music) {
        try {
            myPlaylist.add(music);
            mP3Player.add(new URL("http://api.mp3.zing.vn/api/streaming/audio/" + music.getSongId() + "/128"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(MusicService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeToPlaylist(int index) {
        myPlaylist.remove(index);
    }

    public void runPlaylist() {
        if (myPlaylist.size() == 0) {
            return;
        }
        mP3Player.stop();
        mP3Player = new MP3Player();
        for (Model_Music item : myPlaylist) {
            try {
                mP3Player=mP3Player.add(new URL("http://api.mp3.zing.vn/api/streaming/audio/" + item.getSongId() + "/128"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(MusicService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        playPlaylist = true;
        if(eventInitSong != null) eventInitSong.initSong(myPlaylist.get(0));
        
        mP3Player.play();
    }

    public int checkExistInPlaylist(String songId) {
        if (myPlaylist.size() == 0) {
            return -1;
        }
        int index = 0;
        for (Model_Music item : myPlaylist) {
            if (item.getSongId().equals(songId)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void skipMusic() {
        if (mP3Player.getPlaylist().size() == 0) {
            return;
        }
        if (mP3Player.isPaused()) {
            mP3Player.play();
        }
        mP3Player.skipForward();

    }

    public void backMusic() {
        if (mP3Player.getPlaylist().size() == 0) {
            return;
        }
        if (mP3Player.isPaused()) {
            mP3Player.play();
        }
        mP3Player.skipBackward();
    }

    public boolean isPlaying() {

        return mP3Player.isPlaying();
    }

    public boolean isRepeat() {

        return mP3Player.isRepeat();
    }

    public void setRepeat(boolean repeat) {
        this.repeat =repeat;
        mP3Player.setRepeat(repeat);
    }

    public long getPosition() {
        if (isPlaying()) {
            return mP3Player.getPosition();
        }
        return 0;
    }

//    public void getPositionMusicNow() throws UnsupportedAudioFileException, IOException {
//        URL item = new URL("https://mp3-s1-m-zmp3.zadn.vn/25e946524f16a648ff07/8538779202920432815?authen=exp=1637845982~acl=/25e946524f16a648ff07/*~hmac=efe85a470cefea2c2b0a161635c93d9d&fs=MTYzNzY3MzE4MjE5M3x3ZWJWNnwxMDmUsIC3NDMxMTA3fDE0LjE2OS4xMzAdUngMA&filename=Su-That-Sau-Mot-Loi-Hua-Chi-Dan.mp3");
//        
//       
//
//        long framesRead = 100 / fmt.getFrameSize();
//        long totalFrames = musicInputStream.getFrameLength();
//
//        double totalSeconds = (double) totalFrames / fmt.getSampleRate();
//
//        double elapsedSeconds
//                = ((double) framesRead / (double) totalFrames) * totalSeconds;
//        System.out.println(totalSeconds);
//        System.out.println(elapsedSeconds);
//    }
    public void startAt() throws FileNotFoundException, IOException {

        InputStream inputStream = null;
        Object playlistObject = null;
        //  playlistObject = mP3Player.getPlaylist().get(0);
        if (playlistObject instanceof File) {
            inputStream = new FileInputStream((File) playlistObject);
        } else if (playlistObject instanceof URL) {
            inputStream = ((URL) playlistObject).openStream();
        } else {
            throw new IOException("this is impossible; how come the play list contains this kind of object? :: " + playlistObject.getClass());
        }

    }

    public void setVolume(int value) {
        System.out.println("Volume " + value);
        mP3Player.setVolume(value);

    }

    //test code:
}
