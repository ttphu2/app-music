/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import lib.player.MP3Player;
import response.HomeDataRes;
import singleton.SingletonMusicService;
/**
 *
 * @author hocgioinhatlop
 */
public class ClientService {
    
    public List<HomeDataRes> getHomeData(){
        List<HomeDataRes> result = null;
        try {
            String json = SingletonMusicService.getDataHubServiceInstance().getHomeData();
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return result;
            }
            JsonNode jsonData = jsonNode.get("data").get("items").get(0).get("items");
            result = om.convertValue(jsonData, new TypeReference<List<HomeDataRes>>(){});
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return result;
    }
   
}
