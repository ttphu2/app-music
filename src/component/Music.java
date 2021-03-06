
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
public class Music extends javax.swing.JPanel {

    public Music() {
        initComponents();
        init();
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
    private void init()
    {
        List<Model_Music> listMusic  = SingletonMusicService.getClientServiceInstance().getHotSongInHubDetail();
        if(listMusic != null && listMusic.size() > 0)
        {
            for(Model_Music item : listMusic)
            {
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
        jLabel1.setText("Most Trending Music");

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
