package GUI;

import Data.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {

    private Agenda allContacts = new Agenda();
    private List<Contact> contacteDeAfisat = allContacts.getAllContacts();
    private DefaultListModel<Contact> model = new DefaultListModel<>();
    private DefaultComboBoxModel modelFiltrare = new DefaultComboBoxModel(xFiltrare.values());
    private DefaultComboBoxModel modelOrdonare = new DefaultComboBoxModel(xOrdonare.values());
    private String[] imagini = {"1.jpg", "2.jpg", "3.jpg", "4.jpg"};
    private Timer t;
    public boolean aplicatieActivata = false;

    public void setAplicatieActivata(boolean aplicatieActivata) {
        this.aplicatieActivata = aplicatieActivata;
    }

    public boolean isAplicatieActivata() {
        return aplicatieActivata;
    }

    private void enableFileOperations(boolean bEnable) {
        miDeschidere.setEnabled(bEnable);
        miSalvare.setEnabled(bEnable);
    }

    public MainFrame() {
        initComponents();
        checkIfActivated();
        cbFiltrare.setModel(modelFiltrare);
        cbOrdonare.setModel(modelOrdonare);
        listContacte.setModel(model);
        showDate();
        showTime();
        refreshModel(contacteDeAfisat);

    }

    void checkIfActivated() {
        t = new Timer(0,
                (ActionEvent e) -> {
                    if (isAplicatieActivata() != false) {
                        enableFileOperations(true);
                        showAdvertisement(false);
                        jlInregistrare.setVisible(false);
                        tfInregistrare.setVisible(false);
                        jbActivare.setVisible(false);
                    } else {
                        enableFileOperations(false);
                        showAdvertisement(true);
                    }
                });
        t.setInitialDelay(0);
        t.setDelay(2000);
        t.start();
    }

    void showAdvertisement(boolean bEnable) {
        jlReclame.setVisible(bEnable);
        t = new Timer(0,
                (ActionEvent e) -> {
                    int nRand = (int) (Math.random() * imagini.length);
                    ImageIcon img = new ImageIcon(this.getClass().getResource("..//advertisement//" + imagini[nRand]));
                    jlReclame.setIcon(img);
                });
        t.setInitialDelay(0);
        t.setDelay(2000);
        t.start();
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        jlDate.setText(s.format(d));
    }

    void showTime() {
        new Timer(0, (ActionEvent e) -> {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
            jlTime.setText(s.format(d));
        }).start();
    }

    private void refreshModel(List<Contact> contacte) {
        model.clear();
        for (Contact c : contacte) {
            model.addElement(c);
        }
    }

    public static class Splash extends JWindow {

        public Splash() {
            JWindow window = new JWindow();
            Icon img = new ImageIcon(this.getClass().getResource("loading.jpg"));
            JLabel lblImg = new JLabel(img);
            lblImg.setSize(1200, 612);
            window.getContentPane().add(lblImg);
            window.setBounds(350, 200, 1200, 612);
            window.setVisible(true);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            window.setVisible(false);
            window.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        listContacte = new javax.swing.JList<>();
        btnAdaugaContact = new javax.swing.JButton();
        cbFiltrare = new javax.swing.JComboBox<>();
        cbOrdonare = new javax.swing.JComboBox<>();
        tfText = new javax.swing.JTextField();
        jbOrdonare = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSterge = new javax.swing.JButton();
        jlDate = new javax.swing.JLabel();
        jlTime = new javax.swing.JLabel();
        jbEditare = new javax.swing.JButton();
        jlReclame = new javax.swing.JLabel();
        jlInregistrare = new javax.swing.JLabel();
        tfInregistrare = new javax.swing.JTextField();
        jbActivare = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmFisiere = new javax.swing.JMenu();
        miDeschidere = new javax.swing.JMenuItem();
        miSalvare = new javax.swing.JMenuItem();
        miIesire = new javax.swing.JMenuItem();
        jmAjutor = new javax.swing.JMenu();
        miDespre = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda contacte");
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        listContacte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listContacte.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(listContacte);

        btnAdaugaContact.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAdaugaContact.setText("Adauga contact");
        btnAdaugaContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdaugaContactActionPerformed(evt);
            }
        });

        cbFiltrare.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        cbOrdonare.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTextKeyReleased(evt);
            }
        });

        jbOrdonare.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbOrdonare.setText("Aplica criteriile de ordonare");
        jbOrdonare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOrdonareActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Filtrare:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Ordonare:");

        jbSterge.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbSterge.setText("Sterge contact");
        jbSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStergeActionPerformed(evt);
            }
        });

        jlDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlDate.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlTime.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlTime.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbEditare.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbEditare.setText("Editare contact");
        jbEditare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditareActionPerformed(evt);
            }
        });

        jlInregistrare.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlInregistrare.setText("Inregistrare program: ");

        tfInregistrare.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jbActivare.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbActivare.setText("Submit activation");
        jbActivare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActivareActionPerformed(evt);
            }
        });

        jmFisiere.setText("Fisiere");

        miDeschidere.setText("Deschidere");
        miDeschidere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeschidereActionPerformed(evt);
            }
        });
        jmFisiere.add(miDeschidere);

        miSalvare.setText("Salvare");
        miSalvare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalvareActionPerformed(evt);
            }
        });
        jmFisiere.add(miSalvare);

        miIesire.setText("Iesire");
        miIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miIesireActionPerformed(evt);
            }
        });
        jmFisiere.add(miIesire);

        jMenuBar2.add(jmFisiere);

        jmAjutor.setText("Ajutor");

        miDespre.setText("Despre");
        miDespre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDespreActionPerformed(evt);
            }
        });
        jmAjutor.add(miDespre);

        jMenuBar2.add(jmAjutor);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbOrdonare, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFiltrare, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfText)
                            .addComponent(jbOrdonare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlReclame))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlDate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlTime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdaugaContact, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbSterge, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbEditare, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlInregistrare)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfInregistrare, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbActivare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlInregistrare, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfInregistrare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActivare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlReclame, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiltrare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOrdonare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbOrdonare)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdaugaContact)
                    .addComponent(jbSterge)
                    .addComponent(jbEditare))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OnFilterOrderData() {
        xFiltrare xFiltru = (xFiltrare) cbFiltrare.getSelectedItem();
        xOrdonare xOrdine = (xOrdonare) cbOrdonare.getSelectedItem();
        String sText = tfText.getText();
        contacteDeAfisat = allContacts.getContacteDeAfisat(xFiltru, sText, xOrdine);
        refreshModel(contacteDeAfisat);
    }

    private void btnAdaugaContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdaugaContactActionPerformed
        // TODO add your handling code here:
        dlgAdaugareContact dlgEditare = new dlgAdaugareContact(this, true, false, null);
        dlgEditare.setVisible(true);

        if (dlgEditare.getbContactCreat() == true) {
            Contact cAdd = dlgEditare.getContactEditat();
            refreshModel(contacteDeAfisat);
            if (allContacts.adaugaContact(cAdd)) {
                OnFilterOrderData();
            }
        }

    }//GEN-LAST:event_btnAdaugaContactActionPerformed

    private void tfTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTextKeyReleased
        OnFilterOrderData();
    }//GEN-LAST:event_tfTextKeyReleased

    private void jbOrdonareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOrdonareActionPerformed
        OnFilterOrderData();
    }//GEN-LAST:event_jbOrdonareActionPerformed

    private void jbStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStergeActionPerformed
        int indexSelectat = listContacte.getSelectedIndex();
        int confirmare = JOptionPane.showConfirmDialog(null, "Sunteti sigur ca doriti sa stergeti contactul?", "Confirmare stergere contact", JOptionPane.YES_NO_OPTION);
        if (indexSelectat >= 0 && confirmare == JOptionPane.YES_OPTION) {
            Contact cSelectat = model.get(indexSelectat);
            allContacts.stergeContact(cSelectat);
            OnFilterOrderData();
        } else {
            JOptionPane.showMessageDialog(this, "Nu ati selectat niciun contact!!");
        }
    }//GEN-LAST:event_jbStergeActionPerformed

    private void miDeschidereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeschidereActionPerformed

        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser1.getSelectedFile();
            if (!selectedFile.canRead() || !selectedFile.canExecute()) {
                JOptionPane.showMessageDialog(this, "Nu aveti permisiunile necesare.");
            }
            contacteDeAfisat = allContacts.incarcareContacte(selectedFile);
            refreshModel(contacteDeAfisat);

            //dupa deschiderea fisierului o data la 30 de secunde se salveaza automat
            t = new Timer(0,
                    (ActionEvent e) -> {
                        allContacts.salveazaContacte(selectedFile);
                    });
            t.setInitialDelay(0);
            t.setDelay(30000);
            t.start();
        }
    }//GEN-LAST:event_miDeschidereActionPerformed

    private void miIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miIesireActionPerformed
        int confirmare = JOptionPane.showConfirmDialog(null, "Sunteti sigur ca iesiti?", "Confirmare iesire", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmare == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_miIesireActionPerformed

    private void jbEditareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditareActionPerformed
        int indexSelectat = listContacte.getSelectedIndex();
        if (indexSelectat >= 0) {
            Contact cSelectat = model.get(indexSelectat);
            dlgAdaugareContact dlgEditare = new dlgAdaugareContact(this, true, true, cSelectat);
            dlgEditare.setVisible(true);
            if (dlgEditare.getbContactCreat() == true) {
                Contact cEditat = dlgEditare.getContactEditat();
                allContacts.modificaContact(cSelectat, cEditat);
                OnFilterOrderData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nu ati selectat niciun contact!!!");
        }
    }//GEN-LAST:event_jbEditareActionPerformed

    private void miDespreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDespreActionPerformed
        jfDespre dlgDespre = new jfDespre();
        dlgDespre.setVisible(true);

    }//GEN-LAST:event_miDespreActionPerformed

    private void miSalvareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalvareActionPerformed

        if (jFileChooser2.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser2.getSelectedFile();
            if (!selectedFile.canRead() || !selectedFile.canExecute()) {
                JOptionPane.showMessageDialog(this, "Nu aveti permisiunile necesare.");
            }
            allContacts.salveazaContacte(selectedFile);

            //dupa prima salvare se va salva automat in acelasi fisier o data la 30 de secunde
            t = new Timer(0,
                    (ActionEvent e) -> {
                        allContacts.salveazaContacte(selectedFile);
                    });
            t.setInitialDelay(0);
            t.setDelay(30000);
            t.start();
        }


    }//GEN-LAST:event_miSalvareActionPerformed

    private void jbActivareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActivareActionPerformed
        String codActivare = "1234";
        if (tfInregistrare.getText().equals(codActivare)) {
            JOptionPane.showMessageDialog(this, "Felicitari, ati activat produsul!");
            tfInregistrare.setEditable(false);
            tfInregistrare.setText(codActivare);
            setAplicatieActivata(true);

        } else {
            JOptionPane.showMessageDialog(this, "Cod incorect!");
            setAplicatieActivata(false);
        }
    }//GEN-LAST:event_jbActivareActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Splash s = new Splash();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdaugaContact;
    private javax.swing.JComboBox<String> cbFiltrare;
    private javax.swing.JComboBox<String> cbOrdonare;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActivare;
    private javax.swing.JButton jbEditare;
    private javax.swing.JButton jbOrdonare;
    private javax.swing.JButton jbSterge;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlInregistrare;
    private javax.swing.JLabel jlReclame;
    private javax.swing.JLabel jlTime;
    private javax.swing.JMenu jmAjutor;
    private javax.swing.JMenu jmFisiere;
    private javax.swing.JList<Contact> listContacte;
    private javax.swing.JMenuItem miDeschidere;
    private javax.swing.JMenuItem miDespre;
    private javax.swing.JMenuItem miIesire;
    private javax.swing.JMenuItem miSalvare;
    private javax.swing.JTextField tfInregistrare;
    private javax.swing.JTextField tfText;
    // End of variables declaration//GEN-END:variables
}
