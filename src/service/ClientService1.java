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
import io.socket.client.Ack;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import model.Model_Music;

import response.HomeDataRes;
import singleton.SingletonMusicService;
import util.Helper;
/**
 *
 * @author hocgioinhatlop
 */
public class ClientService1 {
    private static ClientService1 instance;
    public static ClientService1 getInstance() {
        if (instance == null) {
            instance = new ClientService1();
        }
        return instance;
    }
    
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
            Logger.getLogger(ClientService1.class.getName()).log(Level.SEVERE, null, ex);
        }
            return result;
    }
    public String getSongUrl128KBPS(String songId){
        String result = null;
        try {
            String json = SingletonMusicService.getDataHubServiceInstance().getStreamingUrlBySongId(songId);
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return result;
            }
            JsonNode jsonData = jsonNode.get("data").get("128");
            result = jsonData.asText();
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService1.class.getName()).log(Level.SEVERE, null, ex);
        }
            return result;
    }
    public List<Model_Music> getHotSongInHubDetail(){
        List<Model_Music> listReturn = new ArrayList<>();
        try {
            String json = SingletonMusicService.getDataHubServiceInstance().getHubDetail();
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            JsonNode jsonData = jsonNode.get("data").get("sections").get(1).get("items");
            
            int no=1;
            for(JsonNode item : jsonData)
            {
//                listReturn.add(new Model_Music(Integer.toString(no),item.get("title").asText(),Helper.formatSecondToMusicTime(item.get("duration").asInt()),item.get("duration").asInt(),item.get("encodeId").asText()));  
                no++;
            } 
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService1.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listReturn;
    }
   
}
