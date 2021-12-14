
package component;

import event.EventLoadMusic;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Model_Popular;
import singleton.SingletonMusicService;

/**
 *
 * @author hocgioinhatlop
 */
public class MostPopular extends javax.swing.JLayeredPane {

    public MostPopular() {
        initComponents();
    }
    private EventLoadMusic event;

    public void addEventLoadMusic(EventLoadMusic event) {
        this.event = event;
        //mostPopular.addEventArtistSelected(event);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        scrollBar1 = new swing.ScrollBar();

        sp.setBorder(null);
        sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sp.setHorizontalScrollBar(scrollBar1);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        sp.setViewportView(panel);

        scrollBar1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(scrollBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addImage(Model_Popular data){
        
        ItemImage item = new ItemImage();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               SingletonMusicService.getMusicServiceInstance().playNew(data.getSongId());
               SingletonMusicService.getMusicServiceInstance().runEventInitSong();
            }
        });
        panel.add(item);
        panel.repaint();
        panel.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private swing.ScrollBar scrollBar1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
