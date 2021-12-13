package form;

import component.Music_Artist;
import event.EventBackForm;
import event.EventShowLyricWithId;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Model_Profile;
import swing.ScrollBar;

public class Form_ArtistDetail extends javax.swing.JPanel {

    private final Model_Profile data;

    private EventBackForm event;

    public void addEventBackFormSelected(EventBackForm event) {
        this.event = event;
    }
    private EventShowLyricWithId eventShowLyric;

    public void addEventShowLyricWithId(EventShowLyricWithId event) {
        this.eventShowLyric = event;
        music_Artist1.addEventShowLyricWithId(event);
    }

    public Model_Profile getData() {
        return data;
    }

    public Form_ArtistDetail() {
        initComponents();
        setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBar());
        sp1.setVerticalScrollBar(new ScrollBar());
        data = null;
        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                event.backForm();
            }

        });
        img.setPreferredSize(new Dimension(350, 350));
        img.setMaximumSize(new Dimension(350, 350));
        img.setMinimumSize(new Dimension(350, 350));
        ImageIcon abc = new ImageIcon(getClass().getResource("/icon/test/avicii.png"));
        img.setIcon(scaleImage(abc, 350, 350));
        img.setOpaque(false);

    }

    public void initData(Model_Profile data) {
        
        txtBirthday.setText("Ngày sinh: "+data.getBirthday());
        txtName.setText(data.getName()+(!data.getNational().equals("") ? " - "+data.getNational():""));
        txtRName.setText("Tên thật: "+data.getRealName());
        txtDesc.setText(!data.getDescription().equals("") ? data.getDescription().replaceAll("<br>", ""):"Không có thông tin");
        music_Artist1.init(data.getAlbum());
        txtDesc.setCaretPosition(0);
        sp.getVerticalScrollBar().setValue(0);
        if (data.getImage() != null) {
            imageAvatar.setImage(data.getImage());
        }
        repaint();
    }

    public Form_ArtistDetail(Model_Profile data) {
        initComponents();
        setOpaque(false);
        this.data = data;
        txtBirthday.setText(data.getName());
        txtDesc.setText(data.getDescription());
        if (data.getImage() != null) {
            imageAvatar.setImage(data.getImage());
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtBirthday = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        imageAvatar = new swing.ImageAvatar();
        btnClose = new swing.MyButton();
        txtName = new javax.swing.JLabel();
        txtRName = new javax.swing.JLabel();
        music_Artist1 = new component.Music_Artist();
        img = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1060, 1178));

        sp1.setBackground(new java.awt.Color(214, 217, 223));
        sp1.setBorder(null);
        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp1.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtBirthday.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBirthday.setForeground(new java.awt.Color(80, 80, 80));
        txtBirthday.setText("Tên thật: Bùi Thị ABC DZLAD");

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);

        txtDesc.setEditable(false);
        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("SansSerif", 2, 16)); // NOI18N
        txtDesc.setLineWrap(true);
        txtDesc.setRows(5);
        txtDesc.setText("Bích Phương là ca sĩ trưởng thành từ cuộc thi Việt Nam Idol 2010. Năm 2011, cô nổi lên như 1 hiện tượng với hàng loạt những ca khúc Pop Ballad mang giai điệu trữ tình, lời ca đi sâu vào lòng người như: Vẫn, Có khi nào rời xa, Kí ức ngủ quên, v..v.. Bích Phương nhanh chóng chiếm được tình cảm của đông đảo khán giả trẻ nhờ giọng hát mượt mà, sâu lắng cùng ngoại hình xinh đẹp, nữ tính. Nối tiếp những thành công bước đầu đó, Cô tiếp tục chinh phục khán giả bằng rất nhiều sản phẩm âm nhạc được đầu tư chất lượng, Album Vol.1 Chỉ là em giấu đi cùng rất nhiều những ca khúc gây sóng gió trên hàng loạt các bảng xếp hạng như Mình Yêu Nhau Đi và đem về cho Bích Phương những giải thưởng âm nhạc uy tín. Bích Phương dần khẳng định được vị trí vững chắc của mình trong dòng nhạc sở trường Pop Ballad. Đầu năm 2015 đến nay, Bích Phương gây chú ý bằng việc thay đổi hình ảnh lẫn phong cách âm nhạc trẻ trung, hiện đại hơn với RnB, Electro Pop như Bao Giờ Lấy Chồng, Gửi Anh Xa Nhớ, Đưa Em Đi Khắp Thế Gian, Nói Thương Nhau Thì Đừng Làm Trái Tim Em Đau...");
        txtDesc.setWrapStyleWord(true);
        txtDesc.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        txtDesc.setCaretColor(new java.awt.Color(255, 255, 255));
        sp.setViewportView(txtDesc);

        btnClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("BACK");
        btnClose.setBorderColor(new java.awt.Color(114, 0, 161));
        btnClose.setColor(new java.awt.Color(114, 0, 161));
        btnClose.setColorClick(new java.awt.Color(103, 0, 145));
        btnClose.setColorOver(new java.awt.Color(103, 0, 145));
        btnClose.setDoubleBuffered(true);
        btnClose.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnClose.setRadius(30);

        txtName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtName.setForeground(new java.awt.Color(80, 80, 80));
        txtName.setText("Bích Phương");

        txtRName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtRName.setForeground(new java.awt.Color(80, 80, 80));
        txtRName.setText("Ngày sinh: 20/03/2000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(832, 832, 832)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRName, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(music_Artist1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(music_Artist1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        sp1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnClose;
    private swing.ImageAvatar imageAvatar;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private component.Music_Artist music_Artist1;
    private javax.swing.JScrollPane sp;
    private javax.swing.JScrollPane sp1;
    private javax.swing.JLabel txtBirthday;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtRName;
    // End of variables declaration//GEN-END:variables
}
