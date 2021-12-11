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
        txtName.setText("Bích Phương");

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
        btnClose.setText("Đóng");
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
