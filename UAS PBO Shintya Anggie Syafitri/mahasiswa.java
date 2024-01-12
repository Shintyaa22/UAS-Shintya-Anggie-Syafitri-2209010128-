
import java.sql.*; //fungsi untuk memasukkan komponen sql
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class mahasiswa extends javax.swing.JFrame {

 
    public Statement st;    //fungsi untuk mengaktifkan perintah sql
    public ResultSet rs;    //fungsi untuk mengeksekusi perintah sql
    Connection shintya_anggie = koneksi.KoneksiDatabase.BukaKoneksi(); //fungsi untuk melakukan koneksi ke database mysql
    public mahasiswa() {
        initComponents();
        TampilData();
    }
    
       
    //fungsi untuk membersihkan teks
    private void Bersih(){
        Mahasiswa.setText("");
        txtnama.setText("");
        txtalamat.setText("");
        txtprodi.setText("");
        btnsimpan.setText("Simpan");
        Mahasiswa.setEditable(true);
    }
    
    //fungsi untuk mencari data dari tabel di database mysql
    private void CariData(){
        try {
            st = shintya_anggie.createStatement();
            rs = st.executeQuery("SELECT * FROM tbl_mahasiswa WHERE "
                    + cmbcari.getSelectedItem().toString()+
                    " LIKE '%" + txtcari.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("kode");
            model.addColumn("nama");
            model.addColumn("alamat");
            model.addColumn("prodi");
            model.addColumn("usia");
            
            int no =1;
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            while (rs.next()) {
                Object [] data ={
                  no ++,
                  rs.getString("kode"),
                  rs.getString("nama"),
                  rs.getString("alamat"),
                  rs.getString("prodi"),
                  rs.getString("usia"),
                };
                model.addRow(data);
                tbldata.setModel(model);
            }
            
        } catch (Exception e) {
        }
    }
    

    //fungsi untuk menampilkan data dari tabel di database mysql
    private void TampilData(){
        try {
            st = shintya_anggie.createStatement();
            rs = st.executeQuery("SELECT * FROM tbl_mahasiswa");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("kode");
            model.addColumn("nama");
            model.addColumn("alamat");
            model.addColumn("prodi");
             model.addColumn("usia");

            int no =1;
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            while (rs.next()) {
                Object [] data ={
                  no ++,
                  rs.getString("kode"),
                  rs.getString("nama"),
                  rs.getString("alamat"),
                  rs.getString("prodi"),
                  rs.getString("usia")
                };
                model.addRow(data);
                tbldata.setModel(model);
            }
            
        } catch (Exception e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mahasiswa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtkode = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Mahasiswa = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtprodi = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cmbcari = new javax.swing.JComboBox<>();
        txtcari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtusia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mahasiswa.setText("Data Mahasiswa");

        jLabel2.setText("Nama Mahasiswa");

        txtkode.setText("Kode mahasiswa");

        jLabel4.setText("Alamat ");

        jLabel5.setText("prodi ");

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "kode mahasiswa", "nama mahasiswa", "alamat", "prodi", "usia"
            }
        ));
        tbldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldata);

        jLabel6.setText("Cari data");

        cmbcari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kode", "nama" }));

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        jLabel7.setText("usia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(txtkode))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Mahasiswa)
                                    .addComponent(txtnama)
                                    .addComponent(txtalamat)
                                    .addComponent(txtprodi)
                                    .addComponent(txtusia))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 167, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbcari, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(287, 287, 287)
                                .addComponent(mahasiswa)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(mahasiswa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkode)
                    .addComponent(Mahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsimpan))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhapus))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbatal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtusia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = shintya_anggie.createStatement();
            //fungsi cek data yang di simpan tidak boleh kosong
            if (Mahasiswa.getText().equals("")|| 
                    txtnama.getText().equals("")||
                    txtalamat.getText().equals("")||
                    txtprodi.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Data tidak boleh kosong","Informasi", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            //fungsi simpan data ke database
            if ("Simpan".equals(btnsimpan.getText())) {
                //fungsi untuk mengecek data kode mahasiswa
                String cek ="SELECT * FROM tbl_mahasiswa WHERE kode = '" + Mahasiswa.getText()+"'";
                rs = st.executeQuery(cek);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,"Kode mahasiswa Sudah dipakai");
                }else{
                    //fungsi untuk menyimpan data ke tabel
                    String sql = "INSERT INTO tbl_mahasiswa VALUES('" + Mahasiswa.getText()+
                            "','"+txtnama.getText() +
                            "','"+txtalamat.getText() +
                            "','"+txtprodi.getText() + 
                            "','"+txtusia.getText() + "' )";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Data mahasiswa Berhasil disimpan");
                    Bersih();
                    TampilData();
                }
            }else{
                //fungsi untuk mengubah Data
                String Update = "UPDATE tbl_mahasiswa SET nama ='" + txtnama.getText() +
                        "', alamat ='" +txtalamat.getText()+
                        "', prodi ='" +txtprodi.getText()+
                        "', usia ='" +txtprodi.getText()+
                        "' WHERE kode ='" + Mahasiswa.getText()+"'";
                st.executeUpdate(Update);
                    JOptionPane.showMessageDialog(null,"Data mahasiswa Berhasil diubah");
                Bersih();
                TampilData();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tbldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldataMouseClicked
        // TODO add your handling code here:
        Mahasiswa.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 1).toString());
        txtnama.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 2).toString());
        txtalamat.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 3).toString());
        txtprodi.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 4).toString());
        Mahasiswa.setEditable(false);
        btnsimpan.setText("Ubah");
    }//GEN-LAST:event_tbldataMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        //fungsi untuk menghapus data di tabel dari database
        if (Mahasiswa.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Pilih data yang ingin dihapus");
        }else{
             int jawab = JOptionPane.showConfirmDialog(null,"Data ini akan dihapus, lanjutkan","Konfirmasi", JOptionPane.YES_NO_OPTION);
             if (jawab ==0) {
                 try {
                     st = shintya_anggie.createStatement();
                     String sql = "DELETE FROM tbl_mahasiswa WHERE kode = '"+ Mahasiswa.getText()+"'";
                     st.executeUpdate(sql);
                     JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                     TampilData();
                     Bersih();
                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(null,e);
                     
                 }
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // fungsi untuk membersihkan data di halaman aplikasi
        Bersih();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        // fungsi untuk melakukan pencarian data pada tabel di halaman aplikasi
        CariData();
    }//GEN-LAST:event_txtcariKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Mahasiswa;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cmbcari;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mahasiswa;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JLabel txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtprodi;
    private javax.swing.JTextField txtusia;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel DefaultTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
