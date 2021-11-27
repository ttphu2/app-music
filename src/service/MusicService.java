/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;

/**
 *
 * @author hocgioinhatlop
 */
public class MusicService {

    public static MP3Player mP3Player;
   // private static List<String> playList = 
    //http://api.mp3.zing.vn/api/streaming/audio/ZUC7DBEC/128
    public MusicService() {    
        mP3Player = new MP3Player();
        mP3Player.setRepeat(true);
    }
    public void init() {
//        try {
//          URL url1 = new URL("http://api.mp3.zing.vn/api/streaming/audio/ZW67OIA0/128");
//          URL url2 = new URL("http://api.mp3.zing.vn/api/streaming/audio/ZU9AOO00/128");
//          mP3Player = new MP3Player(url1,url2);
//          mP3Player.setRepeat(true);
//          mP3Player.stop();
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(MusicService.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public void playNew(String songId) {
        try {
            mP3Player.stop();
            mP3Player = mP3Player.clearPlaylist();
            mP3Player = mP3Player.add(new URL("http://api.mp3.zing.vn/api/streaming/audio/"+songId+"/128"));
            mP3Player.play();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MusicService.class.getName()).log(Level.SEVERE, null, ex);
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
    public void addToPlaylist(String url)
    {
        try {
            mP3Player.add(new URL(url));
        } catch (MalformedURLException ex) {
            Logger.getLogger(MusicService.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public long getPosition() {
       if(isPlaying()) return mP3Player.getPosition();
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
    public void startAt() throws FileNotFoundException, IOException{
        
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

    public void volumeDownControl(Double value) {
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers) {
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for (Line.Info lineInfo : lineInfos) {
                Line line = null;
                boolean opened = true;
                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if (!opened) {
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = value;
                    float changedCalc = (float) ((float) currentVolume - (double) volumeToCut);
                    volControl.setValue(changedCalc);

                } catch (LineUnavailableException | IllegalArgumentException lineException) {
                } finally {
                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }
    }

    public void volumeControl(Double value) {
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers) {
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for (Line.Info lineInfo : lineInfos) {
                Line line = null;
                boolean opened = true;
                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if (!opened) {
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = value;
                    float changedCalc = (float) ((double) volumeToCut);
                    volControl.setValue(changedCalc);

                } catch (LineUnavailableException | IllegalArgumentException lineException) {
                } finally {
                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }
    }

    //test code:
}
