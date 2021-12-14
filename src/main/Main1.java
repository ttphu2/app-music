/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import event.EventArtistSelected;
import event.EventBackForm;
import event.EventClickBtn;
import event.EventInitSong;
import event.EventLoadMusic;
import event.EventMenuSelected;
import event.EventShowLyric;
import event.EventShowLyricWithId;
import form.Form1;
import form.Form_Art;
import form.Form_ArtistDetail;
import form.Form_ArtistResult;
import form.Form_Playlist;
import form.Form_ShowLyric;
import form.Form_SongResult;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import model.Model_Music;
import org.apache.commons.lang3.StringUtils;
import service.Service;
import swing.DataSearch;
import swing.EventCallBack;
import swing.EventClick;
import swing.EventTextField;
import swing.PanelSearch;
import util.AESUtil;

/**
 *
 * @author hocgioinhatlop
 */
public class Main1 extends javax.swing.JFrame {

    private boolean mouseFlag = true; // dùng để chặn event mouse clicked show popup khi ấn submit search
    List<String> dataStory = new ArrayList<>();
    private JPopupMenu menu1;
    private PanelSearch search;
    private Form_Art form_Artists;
    private Form_ArtistDetail form_ArtistsDetail;
    private Form_SongResult form_SongResult;
    private Form_ArtistResult form_artistResult;
    private Form_ShowLyric form_showLyric;
    private Form1 form1;
    private JComponent oldForm;
    private Timer timer; // timer dung de tao event doi. user nhap input xong
    private TimerTask task;// task dung de tao event doi. user nhap input xong
    private Executor executor;
    private Form_Playlist form_Playlist;

    public Main1() {
        initComponents();
        init();
    }

    private void init() {
        singleton.SingletonMusicService.getMusicServiceInstance().init();
        
        Service.getInstance().startConnection();
        AESUtil.init();
        executor = Executors.newSingleThreadExecutor();
        form_Artists = new Form_Art();
        form1 = new Form1();
        form_ArtistsDetail = new Form_ArtistDetail();
        form_showLyric = new Form_ShowLyric();
        form_SongResult = new Form_SongResult();
        form_Playlist = new Form_Playlist();
        // sp.setVerticalScrollBar(new ScrollBar());
        setBackground(new Color(0, 0, 0, 0));
        //init search panel
        menu1 = new JPopupMenu();
        search = new PanelSearch();

        menu1.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu1.add(search);
        menu1.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {

                menu1.setVisible(false);
                txtSearch.setText(data.getText());
                dataStory.add(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                removeHistory(data.getText());
                menu1.setPopupSize(menu1.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu1.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
        //init move frame
        menu.initMoving(Main1.this);
        form_Artists.addEventArtistSelected(new EventArtistSelected() {
            @Override
            public void selected(int index, String alias) {
                form_ArtistsDetail.initData(singleton.SingletonMusicService.getClientServiceInstance().getDetailArtistByAlias(alias));
                setForm(form_ArtistsDetail);
            }
        });
        form_ArtistsDetail.addEventBackFormSelected(new EventBackForm() {
            @Override
            public void backForm() {
                setForm(oldForm);
            }
        });
        form_showLyric.addEventBackFormSelected(new EventBackForm() {
            @Override
            public void backForm() {
                setForm(oldForm);
            }
        });
        
        //add event show Lyric
        bottom2.addEventShowLyric(new EventShowLyric() {
            @Override
            public void showLyric() {
                if (singleton.SingletonMusicService.getMusicServiceInstance().getCurrentSong() != null) {
                    form_showLyric.initData(singleton.SingletonMusicService.getMusicServiceInstance().getCurrentSong().getSongId());
                    setForm(form_showLyric);
                }
            }
        });
        form_Artists.addEventShowLyricWithId(new EventShowLyricWithId() {
            @Override
            public void showLyric(String songId) {
               form_showLyric.initData(songId);
               setForm(form_showLyric);
            }
        });
        form_SongResult.addEventShowLyricWithId(new EventShowLyricWithId() {
            @Override
            public void showLyric(String songId) {
                
               form_showLyric.initData(songId);
               oldForm=form_SongResult;
               setForm(form_showLyric);
            }
        });
        form_ArtistsDetail.addEventShowLyricWithId(new EventShowLyricWithId() {
            @Override
            public void showLyric(String songId) {
               
               form_showLyric.initData(songId);
               oldForm=form_ArtistsDetail;
               setForm(form_showLyric);
            }
        });
       //event click menu change form
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    oldForm = form_Artists;
                    setForm(form_Artists);
                } else if (index == 2){
                    setForm(form_SongResult);
                } else if(index == 1)
                {
                    form_Playlist.initData();
                    setForm(form_Playlist);                  
                }
            }
        });

        oldForm = form_Artists;
        setForm(form_Artists);
        txtSearch.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                //  Test
                menu1.setVisible(false);
                System.out.println(txtSearch.getText());

                if (StringUtils.isBlank(txtSearch.getText())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng không để trống thanh tim kiếm hoặc nhập khoảng trống",
                            "Có lỗi xảy ra", JOptionPane.WARNING_MESSAGE);
                    return;
                }         
                oldForm = form_SongResult;
                try {
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(10);
                    }  
                    call.done();
                    form_SongResult.initData(txtSearch.getText());
                    setForm(form_SongResult);
                    executor.execute(() -> form_artistResult.initData(txtSearch.getText()));   
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {

            }
        });
        form_artistResult = new Form_ArtistResult();
        form_artistResult.addEventArtistSelected(new EventArtistSelected() {
            @Override
            public void selected(int index, String alias) {
                form_ArtistsDetail.initData(singleton.SingletonMusicService.getClientServiceInstance().getDetailArtistByAlias(alias));
                oldForm = form_artistResult;
                setForm(form_ArtistsDetail);
            }
        });
        //event run function after stop typing
        timer = new Timer();
        //event click music change time
        form_Artists.addEventLoadMuisc(new EventLoadMusic() {
            @Override
            public void loadMusic() {
                bottom2.initMusic();
            }
        });
        form_SongResult.addEventLoadMusic(new EventLoadMusic() {
            @Override
            public void loadMusic() {
                bottom2.initMusic();
            }
        });
        form_SongResult.addEventClickBtn(new EventClickBtn() {
            @Override
            public void clicked() {
                setForm(form_artistResult);
            }
        });
        form_artistResult.addEventClickBtn(new EventClickBtn() {
            @Override
            public void clicked() {
                setForm(form_SongResult);
            }
        });
        singleton.SingletonMusicService.getMusicServiceInstance().addEventInitSong(new EventInitSong() {
            @Override
            public void initSong(Model_Music music) {
                bottom2.initMusic(music);
                if(singleton.SingletonMusicService.getMusicServiceInstance().playPlaylist)
                form_Playlist.setPlayingIndex(singleton.SingletonMusicService.getMusicServiceInstance().getPlayingIndex());
            }
        });
        // showForm(new Form_Artists());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.Panel();
        mainPanel = new javax.swing.JPanel();
        menu = new component.Menu();
        header = new javax.swing.JPanel();
        txtSearch = new swing.TextFieldAnimation();
        bottom2 = new component.Bottom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setMinimumSize(new java.awt.Dimension(230, 548));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(985, 578));
        mainPanel.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setOpaque(false);

        txtSearch.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bottom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked

        if (search.getItemSize() > 0) {
            menu1.setVisible(false);
            menu1.show(txtSearch, 0, txtSearch.getHeight());

        }
        if (checkMouseOver(evt.getPoint())) {
            menu1.setVisible(false);

        }

    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        timer.cancel();
        beginTimer();
    }//GEN-LAST:event_txtSearchKeyReleased

    private int x;
    private int y;

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main1().setVisible(true);
            }
        });
    }

    private List<DataSearch> search(String search) {
        int limitData = 4;
        List<DataSearch> list = new ArrayList<>();

        String dataTesting[] = singleton.SingletonMusicService.getClientServiceInstance().getKeywordByQuery(search);
        if (dataTesting == null) {
            return list;
        }
        for (String d : dataTesting) {
            boolean story = isStory(d);
            if (story) {
                list.add(0, new DataSearch(d, story));
                //  add or insert to first record
            } else {
                list.add(new DataSearch(d, false));
                //  add to last record
            }
            if (list.size() == limitData) {
                break;
            }
        }
        return list;
    }

    private void removeHistory(String text) {
        for (int i = 0; i < dataStory.size(); i++) {
            String d = dataStory.get(i);
            if (d.toLowerCase().equals(text.toLowerCase())) {
                dataStory.remove(i);
            }
        }
    }

    private boolean isStory(String text) {
        for (String d : dataStory) {
            if (d.toLowerCase().equals(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void beginTimer() {

        timer = new Timer();

        task = new TimerTask() {

            public void run() {
                loadSearch();
                timer.cancel();
            }
        };

        timer.scheduleAtFixedRate(task, 800, 1000);
    }

    public void loadSearch() {
        String text = txtSearch.getText().trim().toLowerCase();
        search.setData(search(text));
        if (search.getItemSize() > 0) {
            //  * 2 top and bot border
            menu1.show(txtSearch, 0, txtSearch.getHeight());
            menu1.setPopupSize(menu1.getWidth(), (search.getItemSize() * 35) + 2);
        } else {
            menu1.setVisible(false);
        }
    }

    private boolean checkMouseOver(Point mouse) {
        int width = txtSearch.getWidth();
        int height = txtSearch.getHeight();
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        Point point = new Point(width - height + 3, marginButton);
        Ellipse2D.Double circle = new Ellipse2D.Double(point.x, point.y, buttonSize, buttonSize);
        return circle.contains(mouse);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Bottom bottom2;
    private javax.swing.JPanel header;
    private javax.swing.JPanel mainPanel;
    private component.Menu menu;
    private swing.Panel panel1;
    private swing.TextFieldAnimation txtSearch;
    // End of variables declaration//GEN-END:variables
}
