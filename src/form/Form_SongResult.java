package form;

import component.Profile;
import event.EventClickBtn;
import java.awt.Cursor;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Model_Music;
import model.Model_Profile;
import model.Model_SearchResult;
import swing.ScrollBar;

public class Form_SongResult extends javax.swing.JPanel {

    private EventClickBtn event;
    private String query;
    private int page =1;
    public void addEventClickBtn(EventClickBtn event) {
        this.event = event;
    }

    public Form_SongResult() {
        initComponents();
        setOpaque(false);
        //  sp.setVerticalScrollBar(new ScrollBar());
        sp1.setVerticalScrollBar(new ScrollBar());
     
        btnArtist.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSong.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnArtist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(event!=null)
                event.clicked();
            }

        });
        //xử lý scroll xuống 90% thì call api load thêm bài hát
        sp1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
          
            @Override
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                  if (ae.getValueIsAdjusting()) {
                    return;
                  }
                    if((ae.getAdjustable().getMaximum()-sp1.getHeight())-ae.getValue() <= 100)
                    {                  
                         page++;
                         Model_SearchResult result2 = singleton.SingletonMusicService.getClientServiceInstance().getSearchResultByQuery(query, "song",page, 18);
                         if(result2 != null)
                         music_Search1.loadMore(result2.getSongs());
                    }
                
            }
        });
        

    }

    public void initData(String query) {
        Model_SearchResult result = singleton.SingletonMusicService.getClientServiceInstance().getSearchResultByQuery(query, "song",1, 18);
        
        if(result != null)
        {
           // music_Search1.setVisible(true);
            music_Search1.init(result.getSongs());
            this.query = query;
            txtNumberResult.setText("Có "+result.getCounterSong()+" kết quả được tìm thấy");
        }else{
            music_Search1.setVisible(false);
            txtNumberResult.setText("Không có kết quả nào được tìm thấy");
        }
        
        repaint();
    }

    public Form_SongResult(Model_Profile data) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        txtNumberResult = new javax.swing.JLabel();
        music_Search1 = new component.Music_Search();
        jPanel3 = new javax.swing.JPanel();
        btnArtist = new swing.MyButton();
        btnSong = new swing.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1060, 1178));

        sp1.setBackground(new java.awt.Color(214, 217, 223));
        sp1.setBorder(null);
        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(80, 80, 80));
        txtName.setText("Kết Quả Tìm Kiếm");

        txtNumberResult.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txtNumberResult.setForeground(new java.awt.Color(169, 29, 177));
        txtNumberResult.setText("Có 200 kết quả được tìm thấy");

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        btnArtist.setBackground(new java.awt.Color(245, 245, 245));
        btnArtist.setBorder(null);
        btnArtist.setText("Nghệ sĩ");
        btnArtist.setBorderColor(new java.awt.Color(245, 245, 245));
        btnArtist.setColor(new java.awt.Color(245, 245, 245));
        btnArtist.setColorClick(new java.awt.Color(245, 245, 245));
        btnArtist.setColorOver(new java.awt.Color(250, 250, 250));
        btnArtist.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N

        btnSong.setBackground(new java.awt.Color(245, 245, 245));
        btnSong.setBorder(null);
        btnSong.setForeground(new java.awt.Color(35, 128, 188));
        btnSong.setText("Bài Hát");
        btnSong.setBorderColor(new java.awt.Color(245, 245, 245));
        btnSong.setColor(new java.awt.Color(245, 245, 245));
        btnSong.setColorClick(new java.awt.Color(245, 245, 245));
        btnSong.setColorOver(new java.awt.Color(250, 250, 250));
        btnSong.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(791, 791, 791))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumberResult, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(music_Search1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(311, 311, 311)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumberResult, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(music_Search1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnArtist;
    private swing.MyButton btnSong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private component.Music_Search music_Search1;
    private javax.swing.JScrollPane sp1;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtNumberResult;
    // End of variables declaration//GEN-END:variables
}
