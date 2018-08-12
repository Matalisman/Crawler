import java.io.File;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser extends javax.swing.JFrame {
    static private final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;
    BufferedReader br;
    File file;
    WebReader webReader;
    
    public  Parser() {
        fc = new JFileChooser();
        webReader = new WebReader();
        initComponents();
    }

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
            java.util.logging.Logger.getLogger(Parser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parser().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openFileButton = new javax.swing.JButton();
        saveFileButton = new javax.swing.JButton();
        runAnalisys = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parser");
        setBackground(new java.awt.Color(204, 0, 0));

        openFileButton.setText("Open File");
        openFileButton.setActionCommand("openFile");
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFile(evt);
            }
        });

        saveFileButton.setText("Save file");
        saveFileButton.setActionCommand("saveFile");
        saveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFile(evt);
            }
        });

        runAnalisys.setActionCommand("runAnalisys");
        runAnalisys.setLabel("Run Analisys");
        runAnalisys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runAnalisys(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(openFileButton)
                .addGap(90, 90, 90)
                .addComponent(runAnalisys)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(saveFileButton)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openFileButton)
                    .addComponent(saveFileButton)
                    .addComponent(runAnalisys))
                .addContainerGap(359, Short.MAX_VALUE))
        );

        openFileButton.getAccessibleContext().setAccessibleName("openFile");
        openFileButton.getAccessibleContext().setAccessibleDescription("");
        runAnalisys.getAccessibleContext().setAccessibleName("runAnalisys");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFile
        int returnVal = fc.showOpenDialog(Parser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                //This is where a real application would open the file.
                System.out.print("Opening: " + file.getName() + "." + newline);
            } else {
                 System.out.print("Open command cancelled by user." + newline);
            }
    }//GEN-LAST:event_openFile

    private void saveFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFile
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFile

    private void runAnalisys(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runAnalisys
         try{
             System.out.println("runAnalisys in controller");
             
            br = new BufferedReader(new FileReader(file));
            
            boolean result = webReader.checkIfGivenPageHasGivenValue(br.readLine(), "Gazeta");
            
            System.out.println(result);
        } catch(FileNotFoundException e){
        } catch(IOException e) {
        }
    }//GEN-LAST:event_runAnalisys

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton openFileButton;
    private javax.swing.JButton runAnalisys;
    private javax.swing.JButton saveFileButton;
    // End of variables declaration//GEN-END:variables
}
