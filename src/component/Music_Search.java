
package component;

import event.EventLoadMusic;
import event.EventShowLyricWithId;
import java.util.List;
import model.Model_Music;
import singleton.SingletonMusicService;

/**
 *
 * @author hocgioinhatlop
 */
public class Music_Search extends javax.swing.JPanel {

    public Music_Search() {
        initComponents();
      //  init();
    }
    private EventLoadMusic event;

    public void addEventLoadMusic(EventLoadMusic event) {
        this.event = event;
        list.addEventLoadMusic(event);
    }
    private EventShowLyricWithId eventShowLyric;

    public void addEventShowLyricWithId(EventShowLyricWithId event) {
        this.eventShowLyric = event;
        list.addEventShowLyricWithId(event);
    }
    public void init(List<Model_Music> listMusic)
    {
//        List<Model_Music> listMusic  = SingletonMusicService.getClientServiceInstance().getHotSongInHubDetail();
        if(listMusic != null && listMusic.size() > 0)
        {
            list.clearData();
            list.setPlayingIndex(-1);
            for(Model_Music item : listMusic)
            {
                item.setName(item.getName()+" - "+item.getArtistsNames());
                list.addItem(item);
            }           
        }
        
//        list.addItem(new Model_Music("2", "Heaven", "04:37"));
//        list.addItem(new Model_Music("3", "SOS (feat. Aloe Blacc)", "02:37"));
//        list.addItem(new Model_Music("4", "Bad Reputation (feat. Joe Janiak)", "03:25"));
//        list.addItem(new Model_Music("5", "Ain't A Thing", "03:03"));
//        list.addItem(new Model_Music("6", "Hold The line (feat. A R I Z O N A)", "02:51"));
//        list.addItem(new Model_Music("7", "Freak (feat. Bonn)", "02:59"));
//        list.addItem(new Model_Music("8", "Excuse me Mr Sir (feat. Vargas & Lagola)", "03:07"));
//        list.addItem(new Model_Music("9", "Heart Upon My Sleeve (feat. Imagine Dragons)", "04:14"));
//        list.addItem(new Model_Music("10", "Never Leave Me (feat. Joe Janiak)", "02:51"));
//        list.addItem(new Model_Music("11", "Fades Away (feat. Noonie Bao)", "02:58"));
//        list.addItem(new Model_Music("12", "Wake Me Up", "04:07"));
//        list.addItem(new Model_Music("13", "You Make Me", "03:53"));
//        list.addItem(new Model_Music("14", "Hey Brother", "04:15"));
//        list.addItem(new Model_Music("15", "Addicted To You", "02:28"));;
        
    }
    public void loadMore(List<Model_Music> listMusic)
    {
//        List<Model_Music> listMusic  = SingletonMusicService.getClientServiceInstance().getHotSongInHubDetail();
        if(listMusic != null && listMusic.size() > 0)
        {
            for(Model_Music item : listMusic)
            {
                item.setName(item.getName()+" - "+item.getArtistsNames());
                list.addItem(item);
            }           
        }
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        list = new component.ListMusic<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Top results");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private component.ListMusic<String> list;
    // End of variables declaration//GEN-END:variables
}
