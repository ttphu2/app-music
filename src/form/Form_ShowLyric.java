package form;

import event.EventBackForm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Model_Music;
import model.Model_Profile;
import swing.ScrollBar;

public class Form_ShowLyric extends javax.swing.JPanel {

    private final Model_Music data;

     private EventBackForm event;
        public void addEventBackFormSelected(EventBackForm event)
        {
            this.event = event;
        }
    public Model_Music getData() {
        return data;
    }
    public Form_ShowLyric() {
        initComponents();
        setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBar());
        data = null;
        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
               event.backForm();
            }
            
        });

    }
    public void initData(String songId)
    {
        Model_Music data = singleton.SingletonMusicService.getClientServiceInstance().getInfoSongById(songId);
        
        txtName.setText(data.getName()+" - "+data.getArtistsNames());
        txtDesc.setText(singleton.SingletonMusicService.getClientServiceInstance().getLyricBySongId(songId).replaceAll("<br>",""));
        txtDesc.setCaretPosition(0);
    }
    public Form_ShowLyric(Model_Music data) {
        initComponents();
        setOpaque(false);
        this.data = data;
        txtName.setText(data.getName());
        txtDesc.setText(data.getLyric());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        btnClose = new swing.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(80, 80, 80));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName.setText("B??ch Ph????ng");

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);

        txtDesc.setEditable(false);
        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("SansSerif", 2, 16)); // NOI18N
        txtDesc.setLineWrap(true);
        txtDesc.setRows(5);
        txtDesc.setText("Anh ????a tay ra ????? c??? vu???t ve\\n<br>Khu??n m???t em th???t xinh ?????p\\n<br>M?? n??o ng??? ch???m v??o l?? kh??i s????ng tan\\n<br>Tan bi???t bay m???t n??i ????u.\\n<br>Ch???t gi???t m??nh cho t???nh c??n m??\\n<br>Anh th???c trong n???i u bu???n th??? ??\\n<br>C??? n??u m??i l?? do ????? anh c?? th??? -\\n<br>Ti???p t???c gi??? nh???ng y??u th????ng n??y.\\n<br>Anh ???? l???a ch???n vi???c ph???i ra ??i\\n<br>Hay t??m m???t m???nh gh??p c???a ????i ta\\n<br>Gi???a ng??n r???n n???t ???? nh???t nh??a\\n<br>????? t??m m???t l???i ra.\\n<br>V?? nh??n l???i t???ng d??ng tin nh???n vi???t m??i h??m qua\\n<br>Nh??ng gi??? ????i ch??n c??? ??i xa\\n<br>Anh l??m sao ????? n??i ra\\n<br>Anh ???? bi???t h???t r???ng l??\\n<br>Em ???? trao t??nh y??u cho m???t ng?????i n???a\\n<br>Bao l??u nay\\n<br>Gi???u ??i nh???ng y??u th????ng kia\\n<br>S??u trong nh???ng ng??y ????i ta xa c??ch.\\n<br>Anh ngu ng?? th???t th?? nh??ng anh c??ng bi???t ???????c\\n<br>Nh???ng g?? ?????i thay trong ????i m???t ????m\\n<br>Khi nh??n anh ch???ng c??n y??u th????ng\\n<br>M?? ch??? c?? nh???ng d???i l???a.\\n<br>\\n<br>RAP:\\n<br>Ch??a bao gi??? anh tr??ch b???n th??n hay tr??ch nh??n c??ch con ng?????i em\\n<br>Ch??a bao gi??? anh mu???n ???????c bi???t l?? ng?????i th??? ba em nh??n xem\\n<br>Ng?????i con trai kia l?? ai\\n<br>D?? m???c k??? l?? ai sai\\n<br>Ng?????i anh tr??ch ?????u ti??n l?? ????i tay anh kh??ng bi???t gi??? em l???i\\n<br>D?? h???t c??u n??i d???i th?? c??ng l?? do em ???? ch???n\\n<br>Nh???ng th??ng ng??y qua tr??i tim c??? hai ???? h??o m??n\\n<br>Anh th???t l??ng xin l???i.\\n<br>I'm so sorry. I am so sorry.\\n<br>Anh tr??i theo nh???ng n??i m??\\n<br>Em v???n mu???n anh ph???i tin\\n<br>Ph???i cho em th??m c?? h???i\\n<br>????? t??m ra ai s??? b??n c???nh em sau n??y.\\n<br>Anh ph???i im l???ng ??em ?????n\\n<br>Ni???m tin v??? tan n??? sao\\n<br>S??? kh??ng anh kh??ng th??? n??o ??em t??nh y??u c???a m??nh ra\\n<br>????? ????nh ?????i nh???ng d???i l???a.\\n<br>Em ???? trao t??nh y??u cho m???t ng?????i n???a\\n<br>Bao l??u nay\\n<br>Gi???u ??i nh???ng y??u th????ng kia\\n<br>S??u trong nh???ng ng??y ????i ta xa c??ch.\\n<br>Anh ngu ng?? th???t th?? nh??ng anh c??ng bi???t ???????c\\n<br>Nh???ng g?? ?????i thay trong ????i m???t ????m\\n<br>Khi nh??n anh ch???ng c??n y??u th????ng\\n<br>M?? ch??? c?? nh???ng d???i l???a.\n");
        txtDesc.setWrapStyleWord(true);
        txtDesc.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        txtDesc.setCaretColor(new java.awt.Color(255, 255, 255));
        sp.setViewportView(txtDesc);

        btnClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("????ng");
        btnClose.setBorderColor(new java.awt.Color(114, 0, 161));
        btnClose.setColor(new java.awt.Color(114, 0, 161));
        btnClose.setColorClick(new java.awt.Color(103, 0, 145));
        btnClose.setColorOver(new java.awt.Color(103, 0, 145));
        btnClose.setDoubleBuffered(true);
        btnClose.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnClose.setRadius(30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnClose;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
}
