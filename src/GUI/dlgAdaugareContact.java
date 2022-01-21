package GUI;

import Data.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class dlgAdaugareContact extends javax.swing.JDialog {

    private boolean bContactCreat;
    private Contact contactMemorat = null;

    public Contact getContactEditat() {
        return contactMemorat;
    }

    public void setbContactCreat(boolean bContactCreat) {
        this.bContactCreat = bContactCreat;
    }

    public boolean getbContactCreat() {
        return contactMemorat == null ? false : true;
    }

    public dlgAdaugareContact(java.awt.Frame parent, boolean modal, boolean bEditabil, Contact contactSel) {
        super(parent, modal);
        initComponents();
        if (bEditabil) {
            tfNume.setText(contactSel.getNume());
            tfPrenume.setText(contactSel.getPrenume());
            tfTelefon.setText(contactSel.getNrTelefon());
            tfDob.setText(contactSel.getDataNasterii());
        }
        tfNume.setEditable(true);
        tfPrenume.setEditable(true);
        tfTelefon.setEditable(true);
        tfDob.setEditable(true);
        tfNume.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char letter = e.getKeyChar();
                if (!Character.isLetter(letter)) {
                    e.consume();
                }
            }
        });
        tfPrenume.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char letter = e.getKeyChar();
                if (!Character.isLetter(letter)) {
                    e.consume();
                }
            }
        });
        tfTelefon.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char letter = e.getKeyChar();
                if (!Character.isDigit(letter)) {
                    e.consume();
                } else if (tfTelefon.getText().length() == 10) {
                    e.consume();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        tfNume = new javax.swing.JTextField();
        tfPrenume = new javax.swing.JTextField();
        bAccept = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTelefon = new javax.swing.JTextField();
        tfDob = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adaugare/Editare Contact");
        setResizable(false);

        tfNume.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfPrenume.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        bAccept.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bAccept.setText("Accept");
        bAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcceptActionPerformed(evt);
            }
        });

        bCancel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Nume");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Prenume");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Telefon");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Data nasterii");

        tfTelefon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfTelefon.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        tfDob.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(bAccept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(bCancel)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNume)
                    .addComponent(tfPrenume, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(tfDob)
                    .addComponent(tfTelefon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAccept)
                    .addComponent(bCancel))
                .addContainerGap())
        );

        tfTelefon.getAccessibleContext().setAccessibleName("");
        tfTelefon.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcceptActionPerformed
        contactMemorat = Contact.getInstance(tfNume.getText(), tfPrenume.getText(), tfDob.getText(), tfTelefon.getText());
        String ePattern = "^(0[1-9]|[12][0-9]|3[01])[- \\.](0[1-9]|1[012])[- \\.](19|20)\\d\\d$";
        Pattern pat = Pattern.compile(ePattern);
        Matcher match = pat.matcher(tfDob.getText());
        boolean telefonMobil = tfTelefon.getText().startsWith("07");
        
        if (tfNume.getText().length() <= 2) {
            JOptionPane.showMessageDialog(this, "Numele nu poate contine mai putin de 2 caractere!!!");
            setbContactCreat(false);
        } else if (tfPrenume.getText().length() <= 2) {
            JOptionPane.showMessageDialog(this, "Prenumele nu poate contine mai putin de 2 caractere!!!");
            setbContactCreat(false);
        } else if (tfTelefon.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "Numarul de telefon este invalid");
            setbContactCreat(false);
        } else if (telefonMobil != true) {
            JOptionPane.showMessageDialog(this, "Numarul de telefon este invalid");
            setbContactCreat(false);
        } else if (!match.matches()) {
            JOptionPane.showMessageDialog(this, "Data nasterii invalida");
            setbContactCreat(false);
        } else {
            setbContactCreat(true);
            dispose();
        }
    }//GEN-LAST:event_bAcceptActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        contactMemorat = null;
        setbContactCreat(false);
        dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAccept;
    private javax.swing.JButton bCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField tfDob;
    private javax.swing.JTextField tfNume;
    private javax.swing.JTextField tfPrenume;
    private javax.swing.JTextField tfTelefon;
    // End of variables declaration//GEN-END:variables
}
