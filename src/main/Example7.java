package main;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import response.ApiResponses;
import response.HomeDataRes;
import service.DataHubService;
import service.MusicService;
import util.HashUtil;

public class Example7 {

  public static void main(String[] args) throws Exception {

      ///
//      System.out.println(HashUtil.genarateSignature("1637832770", "/api/v2/song/get/streaming", "ZUC7DBEC", null));
//      DataHubService dataHubService = new DataHubService();
//      //String content = dataHubService.getHotSongInHubDetail();
//      ObjectMapper om = new ObjectMapper();
//      //JsonNode jsonNode = om.readTree(content);
//      singleton.SingletonMusicService.getClientServiceInstance().getHotSongInHubDetail();
      //JsonNode jsonData = jsonNode.get("data").get("items").get(0).get("items");
      //List<HomeDataRes> car2 = om.convertValue(jsonData, new TypeReference<List<HomeDataRes>>(){});
//      String json = om.writeValueAsString(jsonData);
//       
//      List<HomeDataRes> car = om.readValue(json, new TypeReference<List<HomeDataRes>>(){});
//      System.out.println(json);
//    service.Service.getInstance().startConnection();
//   String response = service.Service.getInstance().sendMessage("get_homedata");
//      System.out.println(response);
//    String response2 = service.Service.getInstance().sendMessage("con cac du ma 2");
//    System.out.println(response2);
//      service.Service.getInstance().stopConnection();
    service.Service.getInstance().startConnection();
      singleton.SingletonMusicService.getClientServiceInstance().getSecretKey();
     
      
  }
public static final String formatTime(long secs) {
    return String.format("%02d:%02d", (secs % 3600) / 60, secs % 60);
}
}
