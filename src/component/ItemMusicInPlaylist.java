package component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import model.Model_Music;
import singleton.SingletonMusicService;

public class ItemMusicInPlaylist extends javax.swing.JPanel {

    private final Model_Music data;
    private boolean play = false;
    private ImageIcon icon_addsong = new ImageIcon(getClass().getResource("/icon/addsong.png"));
    private ImageIcon icon_addsong_selected = new ImageIcon(getClass().getResource("/icon/addsong_selected.png"));
    public void setPlay(boolean play) {
        this.play = play;
        if (play) {
            lbShowLyric.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lbIcon.setText("");
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/icon/playing.png")));
            lbText.setFont(new java.awt.Font("sansserif", 1, 14));
            lbText.setForeground(new Color(203, 30, 148));
            lbTime.setFont(new java.awt.Font("sansserif", 1, 14));
            lbTime.setForeground(new Color(203, 30, 148));
        } else {
            lbShowLyric.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lbIcon.setIcon(null);
            lbIcon.setText(data.getNo());
            lbText.setFont(new java.awt.Font("sansserif", 0, 14));
            lbText.setForeground(new Color(51, 51, 51));
            lbTime.setFont(new java.awt.Font("sansserif", 0, 14));
            lbTime.setForeground(new Color(51, 51, 51));
        }
    }
    public void setIconAddSongSelected(){
      
           jLabel1.setIcon(icon_addsong_selected);
    }
    public ItemMusicInPlaylist(Model_Music data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        lbText.setText(data.getName()+" - "+data.getArtistsNames());
        lbTime.setText(data.getTime());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        lbShowLyric = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbText.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbText.setForeground(new java.awt.Color(51, 51, 51));
        lbText.setText("Music Name");

        lbTime.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbTime.setForeground(new java.awt.Color(51, 51, 51));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTime.setText("03:00");

        lbShowLyric.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lyric.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbShowLyric))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbShowLyric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {

        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(246, 246, 246));
        g2.fillRect(0, getHeight() - 2, getWidth(), getHeight());

        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbShowLyric;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbTime;
    // End of variables declaration//GEN-END:variables
}
