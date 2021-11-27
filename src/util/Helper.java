/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;



/**
 *
 * @author hocgioinhatlop
 */
public class Helper {
    // second -> 00:00
    public static String formatSecondToMusicTime(long secs) {
        return String.format("%02d:%02d", (secs % 3600) / 60, secs % 60);
    }
    
}
