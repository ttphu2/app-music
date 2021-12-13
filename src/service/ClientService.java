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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.ImageIcon;
import model.Model_Music;
import model.Model_Profile;
import model.Model_SearchResult;

import response.HomeDataRes;
import singleton.SingletonMusicService;
import util.AESUtil;
import util.HashUtil;
import util.Helper;
import util.RSAUtil;
/**
 *
 * @author hocgioinhatlop
 */
public class ClientService {
    
    public List<HomeDataRes> getHomeData(){
        List<HomeDataRes> result = null;
        try {
            String json = AESUtil.decrypt(Service.getInstance().sendMessage("get_homedata"));
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
            
            String json = AESUtil.decrypt(SingletonMusicService.getDataHubServiceInstance().getStreamingUrlBySongId(songId));
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
            String json = AESUtil.decrypt(Service.getInstance().sendMessage("get_hubdetail"));
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return listReturn;
            }
            JsonNode jsonData = jsonNode.get("data").get("sections").get(1).get("items");
            
            int no=1;
            for(JsonNode item : jsonData)
            {
                listReturn.add(new Model_Music(Integer.toString(no),textOverflow(item.get("title").asText()),Helper.formatSecondToMusicTime(item.get("duration").asInt()),item.get("duration").asInt(),item.get("encodeId").asText(),item.get("artistsNames").asText()));  
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
            String json = AESUtil.decrypt(Service.getInstance().sendMessage("get_hubdetail"));
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return listReturn;
            }
            JsonNode jsonData = jsonNode.get("data").get("sections").get(4).get("items");

            for(int i=0;i<6;i++){
                JsonNode item = jsonData.get(i);
                listReturn.add(new Model_Profile(item.get("id").asText(),item.get("alias").asText()
                        ,item.get("name").asText(),"Có " + item.get("totalFollow").asText() +" followers" 
                        ,new ImageIcon(HashUtil.convertToBufferImage(item.get("thumbnailM").asText()))
                        ,"","",""));
            }
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listReturn;
    }
    public Model_Profile getDetailArtistByAlias(String alias){
        Model_Profile objReturn = new Model_Profile();
        try {
            String json = AESUtil.decrypt(Service.getInstance().sendMessage("ARTIRST_ALIAS_"+alias));
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            JsonNode jsonData = jsonNode.get("data");
            objReturn.setAlias(jsonData.get("alias").asText());
            objReturn.setName(jsonData.get("name").asText());
            objReturn.setDescription(jsonData.get("biography").asText());
            objReturn.setId(jsonData.get("id").asText());
            objReturn.setBirthday(jsonData.get("birthday").asText());
            objReturn.setRealName(jsonData.get("realname").asText());
            objReturn.setNational(jsonData.get("national").asText());
            objReturn.setImage(new ImageIcon(HashUtil.convertToBufferImage(jsonData.get("thumbnail").asText())));
            if(jsonNode.get("data").get("sections") == null) return objReturn;
            JsonNode root = jsonNode.get("data").get("sections").get(0);
            if(root.get("sectionType").asText().equals("song"))
            {
                List<Model_Music> album = new ArrayList<>();
                int no=1;
                for(int i=0;i<root.get("items").size();i++)
                {
                   JsonNode item = root.get("items").get(i);
                   album.add(new Model_Music(Integer.toString(i+1),textOverflow(item.get("title").asText()),Helper.formatSecondToMusicTime(item.get("duration").asInt()),item.get("duration").asInt(),item.get("encodeId").asText(),item.get("artistsNames").asText()));   
                }
                objReturn.setAlbum(album);
            }
            
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return objReturn;
    }
    public String getLyricBySongId(String songId){
        String objReturn = "";
        try {
            String json = AESUtil.decrypt(Service.getInstance().sendMessage("LYRIC_ID_"+songId));
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            if(jsonNode.get("data") == null) return "Lyrics của bài hát này chưa được cập nhật";
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
            String json = AESUtil.decrypt(Service.getInstance().sendMessage("INFO_SONG_"+songId));
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            JsonNode item = jsonNode.get("data");
            objReturn = new Model_Music("1",textOverflow(item.get("title").asText()),Helper.formatSecondToMusicTime(item.get("duration").asInt()),item.get("duration").asInt(),item.get("encodeId").asText(),item.get("artistsNames").asText());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return objReturn;
    }
    public String[] getKeywordByQuery(String query){
        String[] result = null;
        try {
            String json = AESUtil.decrypt(Service.getInstance().sendMessage("GET_KEYWORD_"+query));
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            JsonNode root = jsonNode.get("data").get("items");
            if(root.size() > 0){
                result = new String[root.get(0).get("keywords").size()];
                int index = 0;
                for(JsonNode item : root.get(0).get("keywords"))
                {
                    result[index] = item.get("keyword").asText();
                    index++;
                }
            }        
            
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return result;
    }
    public Model_SearchResult getSearchResultByQuery(String query,String type, int page,int count){
        Model_SearchResult objReturn = new Model_SearchResult();
        try {
            String json = AESUtil.decrypt(Service.getInstance().sendMessage("SEARCH_QUERY_"+type+"_"+page+"_"+count+"_"+query));
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if(!jsonNode.get("err").asText().equals("0"))
            {
                return null;
            }
            
            JsonNode root = jsonNode.get("data");
            if(root.isEmpty()) return null;
            if(type.toLowerCase().equals("song"))
            {
                int total = root.get("total").asInt();
                if(total == 0) return null;
                List<Model_Music> musics = new ArrayList<>();
                JsonNode items= root.get("items");
                int no=count*(page-1)+1;
                for(int i=0;i < items.size();i++)
                {
                    JsonNode item = items.get(i);
                    musics.add(new Model_Music(Integer.toString(no),textOverflow(item.get("title").asText()),Helper.formatSecondToMusicTime(item.get("duration").asInt()),item.get("duration").asInt(),item.get("encodeId").asText(),item.get("artistsNames").asText())); 
                    no++;
                }
                objReturn.setSongs(musics);
                objReturn.setCounterSong(total);
                
            }else{
                
                int total = root.get("total")!=null ? root.get("total").asInt() : 0;
                if(total == 0 || root.get("items") == null) return null;
                List<Model_Profile> artists = new ArrayList<>();
                JsonNode items= root.get("items");
                for(int i=0;i<items.size();i++)
                {
                    JsonNode item = items.get(i);
                    artists.add(new Model_Profile(item.get("id").asText(),item.get("alias").asText()
                        ,item.get("name").asText(),"Có " + (item.get("totalFollow")==null ?  "0": item.get("totalFollow").asText()) +" followers" 
                        ,new ImageIcon(HashUtil.convertToBufferImage(item.get("thumbnailM").asText()))
                        ,"","",""));
                }
                objReturn.setArtists(artists);
                objReturn.setCounterArtist(total);
            }
            

        
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return objReturn;
    }
    public String getSecretKey()
    {
        try {
            String key_encrypted = Service.getInstance().sendMessage("SECRETKEY");
        
            String secretKey = !key_encrypted.equals("") ? RSAUtil.decrypt(key_encrypted, RSAUtil.privateKey) : "";
            System.out.println("Sk="+secretKey);
            return secretKey;
            
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
   public String textOverflow(String name)
   {
       return name.length() > 35 ? name.substring(0,29)+"...":name;
   }
}
