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
import response.ApiResponses;
import response.HomeDataRes;
import service.DataHubService;
import util.HashUtil;

public class Example7 {

  public static void main(String[] args) throws Exception {

      System.out.println(HashUtil.genarateSignature("1637753605", "/api/v2/page/get/home", null, "1"));
      DataHubService dataHubService = new DataHubService();
      String content = dataHubService.getHomeData();
      ObjectMapper om = new ObjectMapper();
      JsonNode jsonNode = om.readTree(content);
      JsonNode jsonData = jsonNode.get("data").get("items").get(0).get("items");
      List<HomeDataRes> car2 = om.convertValue(jsonData, new TypeReference<List<HomeDataRes>>(){});
//      String json = om.writeValueAsString(jsonData);
//       
//      List<HomeDataRes> car = om.readValue(json, new TypeReference<List<HomeDataRes>>(){});
//      System.out.println(json);
      
  }

}
