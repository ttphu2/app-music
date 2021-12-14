package form;

import event.EventClickBtn;
import event.EventLoadMusic;
import event.EventShowLyricWithId;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import model.Model_Music;
import model.Model_Profile;
import swing.ScrollBar;

public class Form_Playlist extends javax.swing.JPanel {

    private EventClickBtn event;
    private String query;
    public void addEventClickBtn(EventClickBtn event) {
        this.event = event;
    }
    private EventLoadMusic event1;
    public void addEventLoadMusic(EventLoadMusic event) {
        this.event1 = event;   
    }
    private EventShowLyricWithId eventShowLyric;

    public void addEventShowLyricWithId(EventShowLyricWithId event) {
        this.eventShowLyric = event;
        playlist2.addEventShowLyricWithId(event);
    }
    

    public Form_Playlist() {
        initComponents();
        setOpaque(false);
        //  sp.setVerticalScrollBar(new ScrollBar());
        sp1.setVerticalScrollBar(new ScrollBar());
        img.setPreferredSize(new Dimension(300, 300));
        img.setMaximumSize(new Dimension(300, 300));
        img.setMinimumSize(new Dimension(300, 300));
        ImageIcon abc = new ImageIcon(getClass().getResource("/icon/test/my_playlist.jpg"));
        img.setIcon(scaleImage(abc, 300, 300));
        img.setOpaque(false);
        

    }

    public void initData() {
        sp1.getVerticalScrollBar().setValue(0);
        List<Model_Music> result = singleton.SingletonMusicService.getMusicServiceInstance().getPlaylist();
        
        if(result != null && result.size() > 0)
        {
            playlist2.setVisible(false);
            playlist2.init(result);
            playlist2.setVisible(true);           
            txtNumberResult.setText("Có "+result.size()+" kết quả được tìm thấy");
        }else{
            playlist2.setVisible(false);
            txtNumberResult.setText("Bạn chưa thêm bài hát nào");
        }
        
        repaint();
    }

    public Form_Playlist(Model_Profile data) {
        initComponents();
    }
    public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if (icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if (nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    public void setPlayingIndex(int index)
    {
        playlist2.setPlayingIndex(index);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        txtNumberResult = new javax.swing.JLabel();
        playlist2 = new component.Playlist();
        img = new javax.swing.JLabel();
        btnRunPlaylist = new swing.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1060, 1178));

        sp1.setBackground(new java.awt.Color(214, 217, 223));
        sp1.setBorder(null);
        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(80, 80, 80));
        txtName.setText("Danh sách bài hát của bạn");

        txtNumberResult.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txtNumberResult.setForeground(new java.awt.Color(169, 29, 177));
        txtNumberResult.setText("Có 200 kết quả được tìm thấy");

        btnRunPlaylist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRunPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        btnRunPlaylist.setText("PHÁT NHẠC");
        btnRunPlaylist.setBorderColor(new java.awt.Color(114, 0, 161));
        btnRunPlaylist.setColor(new java.awt.Color(114, 0, 161));
        btnRunPlaylist.setColorClick(new java.awt.Color(103, 0, 145));
        btnRunPlaylist.setColorOver(new java.awt.Color(103, 0, 145));
        btnRunPlaylist.setDoubleBuffered(true);
        btnRunPlaylist.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnRunPlaylist.setRadius(30);
        btnRunPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRunPlaylistMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumberResult, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnRunPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(playlist2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumberResult, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRunPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(playlist2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        sp1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRunPlaylistMouseClicked
        singleton.SingletonMusicService.getMusicServiceInstance().runPlaylist();
    }//GEN-LAST:event_btnRunPlaylistMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnRunPlaylist;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private component.Playlist playlist2;
    private javax.swing.JScrollPane sp1;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtNumberResult;
    // End of variables declaration//GEN-END:variables
}
