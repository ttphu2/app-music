
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
public class Playlist extends javax.swing.JPanel {

    public Playlist() {
        initComponents();
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
       if(listMusic != null && listMusic.size() > 0)
        {
            list.clearData();
            int no = 0;
            for(Model_Music item : listMusic)
            {
                item.setNo(String.valueOf(no+1));
                list.addItem(item);
                no++;
            }           
        }
              
        
    }
    public void setPlayingIndex(int index)
    {
        list.setPlayingIndex̣x(index);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        list = new component.ListPlaylist<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("My Playlist");

        list.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        list.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private component.ListPlaylist<String> list;
    // End of variables declaration//GEN-END:variables
}
