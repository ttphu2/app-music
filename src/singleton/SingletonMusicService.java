package singleton;

import service.ClientService;
import service.DataHubService;
import service.MusicService;





public class SingletonMusicService {
    private static MusicService musicService=null;
    private static ClientService clientService=null;
    private static DataHubService dataHubService=null;
    
    public static MusicService getMusicServiceInstance(){
        if(musicService==null){
            musicService=new MusicService();
        }
        return musicService;
    }
    public static ClientService getClientServiceInstance(){
        if(clientService==null){
            clientService=new ClientService();
        }
        return clientService;
    }
    public static DataHubService getDataHubServiceInstance(){
        if(dataHubService==null){
            dataHubService=new DataHubService();
        }
        return dataHubService;
    }
 
}
