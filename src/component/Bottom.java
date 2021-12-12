/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import event.EventShowLyric;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.TimerTask;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Model_Music;
import singleton.SingletonMusicService;

/**
 *
 * @author hocgioinhatlop
 */
public class Bottom extends javax.swing.JPanel {

    private static Timer timer;
    private static TimerTask task;
    private boolean running;
    private EventShowLyric event;
    boolean flag = false;
    
    public void addEventShowLyric(EventShowLyric event)
    {
        this.event = event;
    }
    public Bottom() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(68, 68, 68));
        btnShowLyric.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                event.showLyric();
            }
            
        });
        slider2.setVisible(false);
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
            JSlider source = (JSlider)ce.getSource();
            if (!source.getValueIsAdjusting()) {
                SingletonMusicService.getMusicServiceInstance().setVolume(slider2.getValue());
            } 
               
            }
        });
        btnUpVolume.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                flag = !flag;
                String icon = flag ?"/icon/speaker_selected.png":"/icon/speaker.png";
                btnUpVolume.setIcon(new ImageIcon(getClass().getResource(icon)));
                slider2.setVisible(flag);
                
            }
            
        });
        btnRepeat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(SingletonMusicService.getMusicServiceInstance().isRepeat())
                {
                     btnRepeat.setIcon(new ImageIcon(getClass().getResource("/icon/repeat.png")));
                     SingletonMusicService.getMusicServiceInstance().setRepeat(false);
                }else{
                     btnRepeat.setIcon(new ImageIcon(getClass().getResource("/icon/repeat_selected.png")));
                     SingletonMusicService.getMusicServiceInstance().setRepeat(true);
                }
               
                
            }
            
        });
    
     //   beginTimer();
    }
    public void initMusic()
    {
      Model_Music curent = SingletonMusicService.getMusicServiceInstance().getCurrentSong();
      if(curent!= null)
      {
          slider1.setValue(0);
          jLabel2.setText(curent.getTime());
      }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        play1 = new component.Play();
        slider1 = new swing.Slider();
        lbTimePlaying = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRepeat = new javax.swing.JButton();
        btnUpVolume = new javax.swing.JButton();
        btnShowLyric = new javax.swing.JButton();
        slider2 = new swing.Slider();

        slider1.setMaximum(262);
        slider1.setValue(0);
        slider1.setEnabled(false);

        lbTimePlaying.setForeground(new java.awt.Color(255, 255, 255));
        lbTimePlaying.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTimePlaying.setText("00:00");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("04:22");

        btnRepeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/repeat_selected.png"))); // NOI18N
        btnRepeat.setContentAreaFilled(false);
        btnRepeat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnUpVolume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/speaker.png"))); // NOI18N
        btnUpVolume.setContentAreaFilled(false);
        btnUpVolume.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnShowLyric.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lyric1.png"))); // NOI18N
        btnShowLyric.setContentAreaFilled(false);
        btnShowLyric.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        slider2.setToolTipText("Volume");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(play1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTimePlaying, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slider1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slider2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShowLyric, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(play1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTimePlaying, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRepeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpVolume, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowLyric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(0, 0, getWidth(), 25);
        super.paintComponent(grphcs);
    }

    

//    public void startTimer() {
//       int count=0;
//        final Timer t = new Timer(1000, new ActionListener() {
//               @Override
//               public void actionPerformed(java.awt.event.ActionEvent e) {
//                   
//               }
//            });
//            t.start();
//    }
    public void beginTimer() {
		
		timer = new Timer();
		
		task = new TimerTask() {
			
			public void run() {
                                if(SingletonMusicService.getMusicServiceInstance().isPlaying())
                                {
                                  slider1.setValue(Math.round(SingletonMusicService.getMusicServiceInstance().getPosition()));
                                }                               
//				double current = mediaPlayer.getCurrentTime().toSeconds();
//				double end = media.getDuration().toSeconds();
//				songProgressBar.setProgress(current/end);
//				
				if(slider1.getValue() == slider1.getMaximum()) {
					
                                    cancelTimer();
				}
			}
		};
		
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
    public void cancelTimer() {
		
		running = false;
		timer.cancel();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRepeat;
    private javax.swing.JButton btnShowLyric;
    private javax.swing.JButton btnUpVolume;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbTimePlaying;
    private component.Play play1;
    private swing.Slider slider1;
    private swing.Slider slider2;
    // End of variables declaration//GEN-END:variables
}
