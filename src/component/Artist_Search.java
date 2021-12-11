
package component;

import event.EventArtistSelected;
import event.EventMenuSelected;
import java.util.List;
import javax.swing.ImageIcon;
import model.Model_Music;
import model.Model_Profile;
import singleton.SingletonMusicService;

/**
 *
 * @author hocgioinhatlop
 */
public class Artist_Search extends javax.swing.JPanel {
    private EventArtistSelected event;
    public void addEventArtistSelected(EventArtistSelected event)
    {
        this.event = event;
        list.addEventArtistSelected(event);
      //  list2.addEventMenuSelected(event);
    }
    public Artist_Search() {
        initComponents();
        //init();
    }
    public void init(List<Model_Profile> listProfile)
    {
        if(listProfile != null && listProfile.size() > 0)
        {
            list.clearData();
            for(Model_Profile item : listProfile)
            {
                list.addItem(item);
            }           
        }
//        list.addItem(new Model_Profile("Avicii", "Tim","","", new ImageIcon(getClass().getResource("/icon/test/avicii_pro.jpg")),"","",""));
//        list.addItem(new Model_Profile("Avicii", "Tim","","", new ImageIcon(getClass().getResource("/icon/test/avicii_pro.jpg")),"","",""));
//        list.addItem(new Model_Profile("Avicii", "Tim","","", new ImageIcon(getClass().getResource("/icon/test/avicii_pro.jpg")),"","",""));
//        list.addItem(new Model_Profile("Avicii", "Tim","","", new ImageIcon(getClass().getResource("/icon/test/avicii_pro.jpg")),"","",""));
//        list.addItem(new Model_Profile("Avicii", "Tim","","", new ImageIcon(getClass().getResource("/icon/test/avicii_pro.jpg")),"","",""));
//        list.addItem(new Model_Profile("Avicii", "Tim","","", new ImageIcon(getClass().getResource("/icon/test/avicii_pro.jpg")),"","",""));
       
    }
    public void loadMore(List<Model_Profile> listProfile)
    {
//        List<Model_Music> listMusic  = SingletonMusicService.getClientServiceInstance().getHotSongInHubDetail();
        if(listProfile != null && listProfile.size() > 0)
        {
            for(Model_Profile item : listProfile)
            {
                list.addItem(item);
            }           
        }
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        list = new component.ListProfile<>();

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
                    .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private component.ListProfile<String> list;
    // End of variables declaration//GEN-END:variables
}
