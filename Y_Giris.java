
package odev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Y_Giris extends javax.swing.JFrame {

              /**
     *  * Bu Sayfada Veri Tabanı Kullanılmıştır .
     * 
     * Y_Kayit Tablosu oluşturuldu .
     * ,
     * Bu Yönetici Kısmında Ekleme Yapılmıyor
     * veritabanında belirledigim bilgilerle giriş yapıyorum .
     * 
     * YöneticiTEXT VE ŞİFRETEXT Y_Kayit VERİLERİ Select From İle verileri Eşit ise 
     * Yönteici Menü Kısmına Yönlendiriyorum
     */
    public Y_Giris() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Sifre = new java.awt.TextField();
        Adi = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Yönetici Adi");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 120, 30));
        jPanel1.add(Sifre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 240, 30));
        jPanel1.add(Adi, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 240, 30));

        jLabel2.setText("ŞİFRE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        button1.setBackground(new java.awt.Color(0, 255, 204));
        button1.setLabel("Giriş Yap");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 240, -1));

        button2.setLabel("Geri Dön");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 89, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
    Connection mycoib;  
   String url = "jdbc:mysql://localhost:3306/odev";
   String user = "root";
   String pass = "";
   
  try{
      Class.forName("com.mysql.jdbc.Driver");
     mycoib = DriverManager.getConnection(url,user,pass);
     Statement stmt = mycoib.createStatement();
   
    String sql = "Select * from Y_Kayit where adi='"+Adi.getText()+"' and sifre='"+Sifre.getText()+"'";
     ResultSet rs=stmt.executeQuery(sql);
     if(rs.next()){
        JOptionPane.showMessageDialog(this,"Başarılı");
         new Y_AnaSayfa().setVisible(true);
         this.dispose();
         
    }else{
         JOptionPane.showMessageDialog(this,"Başarısız Lütfen Tekrar Giriniz! ");
         mycoib.close();
        
     }
  }catch(SQLException e){
      e.printStackTrace();
      System.out.println("HATA");
  }     catch (ClassNotFoundException ex) {
          
        }
     

    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

        new AnaSayfa().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_button2ActionPerformed

   
    public static void main(String args[]) {
        
     
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Y_Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Y_Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Y_Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Y_Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Y_Giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField Adi;
    private java.awt.TextField Sifre;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
