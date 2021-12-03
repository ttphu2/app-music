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
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.Model_Music;
import model.Model_Profile;

import response.HomeDataRes;
import singleton.SingletonMusicService;
import util.HashUtil;
import util.Helper;
/**
 *
 * @author hocgioinhatlop
 */
public class ClientService {
    
    public List<HomeDataRes> getHomeData(){
        List<HomeDataRes> result = null;
        try {
            String json = Service.getInstance().sendMessage("get_homedata");
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
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return result;
    }
    public List<Model_Music> getHotSongInHubDetail(){
        List<Model_Music> listReturn = new ArrayList<>();
        try {
            String json = Service.getInstance().sendMessage("get_hubdetail");
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
                listReturn.add(new Model_Music(Integer.toString(no),item.get("title").asText(),Helper.formatSecondToMusicTime(item.get("duration").asInt()),item.get("duration").asInt(),item.get("encodeId").asText(),item.get("artistsNames").asText()));  
                no++;
            } 
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listReturn;
    }
    public List<Model_Profile> getHotArtistInHubDetail(){
        List<Model_Profile> listReturn = new ArrayList<>();
        try {
            String json = Service.getInstance().sendMessage("get_hubdetail");
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            JsonNode jsonData = jsonNode.get("data").get("sections").get(4).get("items");

            for(int i=0;i<6;i++){
                JsonNode item = jsonData.get(i);
                listReturn.add(new Model_Profile(item.get("id").asText(),item.get("alias").asText(),item.get("name").asText(),"Có " + item.get("totalFollow").asText() +" followers" ,new ImageIcon(HashUtil.convertToBufferImage(item.get("thumbnailM").asText()))));
            }
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listReturn;
    }
    public Model_Profile getDetailArtistByAlias(String alias){
        Model_Profile objReturn = new Model_Profile();
        try {
            String json = Service.getInstance().sendMessage("ARTIRST_ALIAS_"+alias);
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            JsonNode jsonData = jsonNode.get("data");
            objReturn.setAlias(jsonData.get("alias").asText());
            objReturn.setName(jsonData.get("name").asText()+" - "+jsonData.get("realname").asText());
            objReturn.setDescription(jsonData.get("biography").asText());
            objReturn.setId(jsonData.get("id").asText());
            objReturn.setImage(new ImageIcon(HashUtil.convertToBufferImage(jsonData.get("thumbnail").asText())));         
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return objReturn;
    }
    public String getLyricBySongId(String songId){
        String objReturn = "";
        try {
            String json = Service.getInstance().sendMessage("LYRIC_ID_"+songId);
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            JsonNode jsonData = jsonNode.get("data").get(0);
            objReturn = jsonData.get("content").asText();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return objReturn;
    }
    public Model_Music getInfoSongById(String songId){
        Model_Music objReturn = null;
        try {
            String json = Service.getInstance().sendMessage("INFO_SONG_"+songId);
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            JsonNode item = jsonNode.get("data");
            objReturn = new Model_Music("1",item.get("title").asText(),Helper.formatSecondToMusicTime(item.get("duration").asInt()),item.get("duration").asInt(),item.get("encodeId").asText(),item.get("artistsNames").asText());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return objReturn;
    }
    
   
}
