package speech.gui;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Robot;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import speech.database.Database;
import speech.updater.Updater;

/**
 *
 * @author namishah
 */
public class SpeechFrame extends javax.swing.JFrame {
    private int counter = 0;
    private final Database db = new Database();
    private java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("speech/gui/Bundle_nl_NL");
        
    /**
     * Creates new form speechFrame
     */
    public SpeechFrame() {
        try {
            //System.out.println(db.toString());
            initComponents();
            txtLog.setEnabled(false);
            cbxEditMode.setSelected(false);
            btnSave.setEnabled(false);
            btnDelete.setEnabled(false);
            setStatus(bundle.getString("TO START, CLICK ON 'NEW LOG'"));
            //System.out.println(Constants.PATH_TO_PROFILES);
            DetectorFactory.loadProfile(Constants.PATH_TO_PROFILES);
        } catch (LangDetectException ex) {
            Logger.getLogger(SpeechFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setStatus(String text){
        lblStatus.setText(text);
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                lblStatus.setText(bundle.getString("TO START, CLICK ON 'NEW LOG'"));
            }
        }, 5000 
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnReq = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cbxEditMode = new javax.swing.JCheckBox();
        btnUpdate = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstLogs = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("speech/gui/Bundle_nl_NL"); // NOI18N
        setTitle(bundle.getString("SPEECH")); // NOI18N
        setName("frmSpeech"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtLog.setColumns(20);
        txtLog.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtLog.setLineWrap(true);
        txtLog.setRows(5);
        txtLog.setWrapStyleWord(true);
        txtLog.setMargin(new java.awt.Insets(10, 10, 10, 10));
        txtLog.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLogFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLogFocusLost(evt);
            }
        });
        txtLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtLogMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnReq.setText(bundle.getString("REQUEST LOGS")); // NOI18N
        btnReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReqActionPerformed(evt);
            }
        });

        btnNew.setText(bundle.getString("NEW LOG")); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText(bundle.getString("SAVE LOG")); // NOI18N
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText(bundle.getString("DELETE LOG")); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cbxEditMode.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        cbxEditMode.setText(bundle.getString("EDIT MODE")); // NOI18N
        cbxEditMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEditModeActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdate.setText(bundle.getString("UPDATE")); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cbxEditMode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReq, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEditMode)
                    .addComponent(btnUpdate))
                .addContainerGap())
        );

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N

        lstLogs.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        lstLogs.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstLogs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstLogs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstLogsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstLogs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        btnReq.setText(bundle.getString("REQUEST LOGS"));
        lstLogs.clearSelection();
        if(btnNew.getText().equalsIgnoreCase(bundle.getString("NEW LOG"))){
            txtLog.setText("");
            txtLog.setForeground(Color.BLACK);
            editMode(true);
            btnNew.setText(bundle.getString("CLEAR"));
            btnSave.setEnabled(true);
            setStatus(bundle.getString("CLICK IN THE TEXT AREA TO START RECORDING."));
        } else {
            editMode(false);
            btnSave.setEnabled(false);
            txtLog.setForeground(Color.RED);
            executeShortcut();
            btnNew.setText(bundle.getString("NEW LOG"));
            setStatus(bundle.getString("THE LOG WAS NOT SAVED!"));
        }
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void executeShortcut(){
        try {
            Robot r = new Robot();
            r.keyPress(Constants.KEY_1);
            r.keyPress(Constants.KEY_2);
            Thread.sleep(100);
            r.keyRelease(Constants.KEY_1);
            r.keyRelease(Constants.KEY_2);
        } catch (AWTException | InterruptedException ex) {
            Logger.getLogger(SpeechFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void txtLogMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLogMouseReleased
 
    }//GEN-LAST:event_txtLogMouseReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            btnReq.setText(bundle.getString("REQUEST LOGS"));
            btnReq.setEnabled(true);
            String content = txtLog.getText();
            if(!content.isEmpty()){
                if(txtLog.getForeground().equals(Color.BLUE) && txtLog.isEnabled()){
                    //Save
                    String id = lstLogs.getSelectedValue().toString().substring(lstLogs.getSelectedValue().toString().indexOf("[") + 1, lstLogs.getSelectedValue().toString().indexOf("]"));
                    db.saveLog(Integer.parseInt(id), content);
                    setStatus(bundle.getString("LOG SAVED TO DATABASE."));
                } else {
                    //Insert
                    if(txtLog.isEnabled()){
                        db.insertLog(content, Constants.AUTHOR);
                        setStatus(bundle.getString("LOG INSERTED IN DATABASE."));
                    }
                }
            } else {
                setStatus(bundle.getString("NOTHING HAS BEEN SAVED, THE LOG IS EMPTY."));
            }
            btnSave.setEnabled(false);
            btnNew.setText(bundle.getString("NEW LOG"));
            btnReq.doClick();
        } catch (Exception ex) {
            setStatus(ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReqActionPerformed
        if(btnReq.getText().equalsIgnoreCase(bundle.getString("REQUEST LOGS"))){
            List<String> allLogs = db.getAllLogsFormat();
            DefaultListModel model = new DefaultListModel();
            for(String log:allLogs){
                model.addElement(log);
            }
            if(allLogs.size() > 0){
                lstLogs.setModel(model);
                btnReq.setText(bundle.getString("TRANSLATE LOG"));
            } else {
                setStatus(bundle.getString("THERE ARE NO LOGS IN THE DATABASE"));
            }
        } else {
            if(!txtLog.getText().equalsIgnoreCase("")) {
                try {
                    //Translate
                    Translator translate = Translator.getInstance();
                    Detector detector = DetectorFactory.create();
                    detector.append(txtLog.getText());
                    String lang = detector.detect();
                    //System.out.println(lang);
                    if(txtLog.getText().split(" ").length >= 50){
                        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                            try {
                                if(!lang.equalsIgnoreCase("nl")){
                                    desktop.browse(new URL("https://translate.google.com/#en/nl/"+URLEncoder.encode(txtLog.getText())).toURI());
                                } else {
                                    desktop.browse(new URL("https://translate.google.com/#nl/en/"+URLEncoder.encode(txtLog.getText())).toURI());
                                }
                            } catch (IOException e) {
                                //
                            } catch (URISyntaxException ex) {
                                Logger.getLogger(SpeechFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        String text;
                        if(!lang.equalsIgnoreCase("nl")){
                            text = translate.translate(txtLog.getText().replace(",", "|").replace(".", "/"), Language.ENGLISH, Language.DUTCH);
                        } else {
                            text = translate.translate(txtLog.getText().replace(",", "|").replace(".", "/"), Language.DUTCH, Language.ENGLISH);
                        }
                        txtLog.setText(text.replace(" |", ",").replace(" /", "."));
                        //btnReq.setEnabled(false);              
                    }
                    if(txtLog.getText().split(" ").length > 1)
                        setStatus(java.text.MessageFormat.format(bundle.getString("THE LOG CONTAINS ~{0} WORDS"), new Object[] {txtLog.getText().split(" ").length}));
                    else
                        setStatus(java.text.MessageFormat.format(bundle.getString("THE LOG CONTAINS ~{0} WORD"), new Object[] {txtLog.getText().split(" ").length}));

                } catch (LangDetectException ex) {
                    Logger.getLogger(SpeechFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnReqActionPerformed

    private void lstLogsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstLogsValueChanged
        if(lstLogs.getSelectedValue() == null || ((lstLogs.getSelectedValue().toString().indexOf("]")) - (lstLogs.getSelectedValue().toString().indexOf("[")+1)) < 0){
            btnDelete.setEnabled(false);
        } else {
            editMode(false);
            btnReq.setEnabled(true);
            btnSave.setEnabled(true);
            btnDelete.setEnabled(true);
            String id = lstLogs.getSelectedValue().toString().substring(lstLogs.getSelectedValue().toString().indexOf("[") + 1, lstLogs.getSelectedValue().toString().indexOf("]"));
            String content = db.getLogById(Integer.parseInt(id));
            txtLog.setForeground(Color.BLUE);
            txtLog.setText(content);
        }
    }//GEN-LAST:event_lstLogsValueChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        btnReq.setText(bundle.getString("REQUEST LOGS"));
        if(lstLogs.getSelectedValue() == null || ((lstLogs.getSelectedValue().toString().indexOf("]")) - (lstLogs.getSelectedValue().toString().indexOf("[")+1)) < 0){
            //
        } else {
            String id = lstLogs.getSelectedValue().toString().substring(lstLogs.getSelectedValue().toString().indexOf("[") + 1, lstLogs.getSelectedValue().toString().indexOf("]"));
            int dialogResult = JOptionPane.showConfirmDialog (null, bundle.getString("ARE YOU SURE YOU WISH TO DELETE THIS LOG?"),bundle.getString("WARNING"),JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                db.deleteLog(Integer.parseInt(id));
                setStatus(bundle.getString("LOG ")+id+bundle.getString(" HAS BEEN DELETED."));
            } else {
                setStatus(bundle.getString("LOG ")+id+bundle.getString(" HAS NOT BEEN DELETED."));
            }
            txtLog.setForeground(Color.BLACK);
            txtLog.setText("");
            btnReq.doClick();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void editMode(boolean on){
        txtLog.setEnabled(on);
        cbxEditMode.setSelected(on);
    }
    private void cbxEditModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEditModeActionPerformed
        if(cbxEditMode.isSelected()){
            txtLog.setEnabled(true);
        } else {
            txtLog.setEnabled(false);
        }
    }//GEN-LAST:event_cbxEditModeActionPerformed

    private void txtLogFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLogFocusGained
        if(txtLog.isEnabled()){
            txtLog.requestFocusInWindow();
            executeShortcut();
            setStatus(bundle.getString("SPEECH IS RECORDING"));
        }
    }//GEN-LAST:event_txtLogFocusGained

    private void txtLogFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLogFocusLost
        executeShortcut();
        setStatus(bundle.getString("SPEECH STOPPED RECORDING"));
    }//GEN-LAST:event_txtLogFocusLost

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if(Updater.getInstance().downloadUpdate()){
                setStatus(bundle.getString("NEW UPDATE DOWNLOADED"));
            } else {
                setStatus(bundle.getString("YOU ARE CURRENTLY UP TO DATE"));
            }
        } catch (IOException ex) {
            Logger.getLogger(SpeechFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(SpeechFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpeechFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpeechFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpeechFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpeechFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnReq;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbxEditMode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList lstLogs;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
