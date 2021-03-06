package form;

import event.EventBackForm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Model_Profile;
import swing.ScrollBar;

public class Form_ArtistDetail1 extends javax.swing.JPanel {

    private final Model_Profile data;

     private EventBackForm event;
        public void addEventBackFormSelected(EventBackForm event)
        {
            this.event = event;
        }
    public Model_Profile getData() {
        return data;
    }
    public Form_ArtistDetail1() {
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
    public void initData(Model_Profile data)
    {
        txtName.setText(data.getName());
        txtDesc.setText(data.getDescription().replaceAll("<br>",""));
        if(data.getImage() != null)
        {
            imageAvatar.setImage(data.getImage());
        }
    }
    public Form_ArtistDetail1(Model_Profile data) {
        initComponents();
        setOpaque(false);
        this.data = data;
        txtName.setText(data.getName());
        txtDesc.setText(data.getDescription());
        if(data.getImage() != null)
        {
            imageAvatar.setImage(data.getImage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        imageAvatar = new swing.ImageAvatar();
        btnClose = new swing.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(80, 80, 80));
        txtName.setText("B??ch Ph????ng");

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);

        txtDesc.setEditable(false);
        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("SansSerif", 2, 16)); // NOI18N
        txtDesc.setLineWrap(true);
        txtDesc.setRows(5);
        txtDesc.setText("B??ch Ph????ng l?? ca s?? tr?????ng th??nh t??? cu???c thi Vi???t Nam Idol 2010. N??m 2011, c?? n???i l??n nh?? 1 hi???n t?????ng v???i h??ng lo???t nh???ng ca kh??c Pop Ballad mang giai ??i???u tr??? t??nh, l???i ca ??i s??u v??o l??ng ng?????i nh??: V???n, C?? khi n??o r???i xa, K?? ???c ng??? qu??n, v..v.. B??ch Ph????ng nhanh ch??ng chi???m ???????c t??nh c???m c???a ????ng ?????o kh??n gi??? tr??? nh??? gi???ng h??t m?????t m??, s??u l???ng c??ng ngo???i h??nh xinh ?????p, n??? t??nh. N???i ti???p nh???ng th??nh c??ng b?????c ?????u ????, C?? ti???p t???c chinh ph???c kh??n gi??? b???ng r???t nhi???u s???n ph???m ??m nh???c ???????c ?????u t?? ch???t l?????ng, Album Vol.1 Ch??? l?? em gi???u ??i c??ng r???t nhi???u nh???ng ca kh??c g??y s??ng gi?? tr??n h??ng lo???t c??c b???ng x???p h???ng nh?? M??nh Y??u Nhau ??i v?? ??em v??? cho B??ch Ph????ng nh???ng gi???i th?????ng ??m nh???c uy t??n. B??ch Ph????ng d???n kh???ng ?????nh ???????c v??? tr?? v???ng ch???c c???a m??nh trong d??ng nh???c s??? tr?????ng Pop Ballad. ?????u n??m 2015 ?????n nay, B??ch Ph????ng g??y ch?? ?? b???ng vi???c thay ?????i h??nh ???nh l???n phong c??ch ??m nh???c tr??? trung, hi???n ?????i h??n v???i RnB, Electro Pop nh?? Bao Gi??? L???y Ch???ng, G???i Anh Xa Nh???, ????a Em ??i Kh???p Th??? Gian, N??i Th????ng Nhau Th?? ?????ng L??m Tr??i Tim Em ??au...");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnClose;
    private swing.ImageAvatar imageAvatar;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
}
