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
        txtName.setText("Bích Phương");

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);

        txtDesc.setEditable(false);
        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("SansSerif", 2, 16)); // NOI18N
        txtDesc.setLineWrap(true);
        txtDesc.setRows(5);
        txtDesc.setText("Anh đưa tay ra để cố vuốt ve\\n<br>Khuôn mặt em thật xinh đẹp\\n<br>Mà nào ngờ chạm vào là khói sương tan\\n<br>Tan biết bay mất nơi đâu.\\n<br>Chợt giật mình cho tỉnh cơn mơ\\n<br>Anh thức trong nỗi u buồn thờ ơ\\n<br>Cố níu mãi lý do để anh có thể -\\n<br>Tiếp tục giữ những yêu thương này.\\n<br>Anh đã lựa chọn việc phải ra đi\\n<br>Hay tìm một mảnh ghép của đôi ta\\n<br>Giữa ngàn rạn nứt đã nhạt nhòa\\n<br>Để tìm một lối ra.\\n<br>Và nhìn lại từng dòng tin nhắn viết mãi hôm qua\\n<br>Nhưng giờ đôi chân cứ đi xa\\n<br>Anh làm sao để nói ra\\n<br>Anh đã biết hết rằng là\\n<br>Em đã trao tình yêu cho một người nữa\\n<br>Bao lâu nay\\n<br>Giấu đi những yêu thương kia\\n<br>Sâu trong những ngày đôi ta xa cách.\\n<br>Anh ngu ngơ thật thà nhưng anh cũng biết được\\n<br>Những gì đổi thay trong đôi mắt đêm\\n<br>Khi nhìn anh chẳng còn yêu thương\\n<br>Mà chỉ có những dối lừa.\\n<br>\\n<br>RAP:\\n<br>Chưa bao giờ anh trách bản thân hay trách nhân cách con người em\\n<br>Chưa bao giờ anh muốn được biết là người thứ ba em nhìn xem\\n<br>Người con trai kia là ai\\n<br>Dù mặc kệ là ai sai\\n<br>Người anh trách đầu tiên là đôi tay anh không biết giữ em lại\\n<br>Dù hết câu nói dối thì cũng là do em đã chọn\\n<br>Những tháng ngày qua trái tim cả hai đã héo mòn\\n<br>Anh thật lòng xin lỗi.\\n<br>I'm so sorry. I am so sorry.\\n<br>Anh trôi theo những nơi mà\\n<br>Em vẫn muốn anh phải tin\\n<br>Phải cho em thêm cơ hội\\n<br>Để tìm ra ai sẽ bên cạnh em sau này.\\n<br>Anh phải im lặng đem đến\\n<br>Niềm tin vỡ tan nỡ sao\\n<br>Sẽ không anh không thể nào đem tình yêu của mình ra\\n<br>Để đánh đổi những dối lừa.\\n<br>Em đã trao tình yêu cho một người nữa\\n<br>Bao lâu nay\\n<br>Giấu đi những yêu thương kia\\n<br>Sâu trong những ngày đôi ta xa cách.\\n<br>Anh ngu ngơ thật thà nhưng anh cũng biết được\\n<br>Những gì đổi thay trong đôi mắt đêm\\n<br>Khi nhìn anh chẳng còn yêu thương\\n<br>Mà chỉ có những dối lừa.\n");
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
