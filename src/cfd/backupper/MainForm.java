/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper;

import cfd.backupper.observer.FileCopiedObserver;
import cfd.backupper.observer.ProgressBarObserver;
import cfd.backupper.observer.Subject;
import cfd.backupper.state.StartupConfig;
import cfd.backupper.uilogger.Logger;
import cfd.backupper.workers.CountAllFilesInDirectory;
import java.awt.Cursor;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author edm
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    
    ProgressBarObserver pbo = new ProgressBarObserver();
    FileCopiedObserver fco = new FileCopiedObserver();
    StartupConfig startupConfig = StartupConfig.get();
    
    public MainForm() {
        
        initComponents();
        ImageIcon ii = new ImageIcon("assets"+File.separator+"img"+File.separator+"icon"+File.separator+"awesome-1.png");
        this.setIconImage(ii.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Backup-Verzeichnisse");

        DefaultCaret caret = (DefaultCaret)jTextArea2.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        Logger.addSuperLogger(jTextArea2, new cfd.backupper.uilogger.JTextAreaLogger());
        jTextArea2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTextArea2ComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        jLabel2.setText("Konsole");

        jButton1.setText("Backup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Verzeichnis", "Anzahl Dateien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable2);

        Logger.addSuperLogger(jTextField1, new cfd.backupper.uilogger.JTextFieldLogger());
        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel3.setText("Ziel-Verzeichnis");

        jMenu3.setText("File");

        jMenuItem1.setText("Add path");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Target dir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        //Handle open button action.
        final JFileChooser fc = new JFileChooser();
        final DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        class MySpecialCounter extends CountAllFilesInDirectory{
            
            @Override
            protected void done(){
                model.setValueAt(MySpecialCounter.getCount(),model.getRowCount()-1, model.getColumnCount()-1);
                jProgressBar1.setIndeterminate(false);
            }
        }
        
        
        
        //int returnVal = fc.showOpenDialog(MainForm.this);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            DirContainer.addDir(file);
            StartupConfig.putSetting("BACKUPDIRS", DirContainer.getDirs());
            //StartupConfig.putSetting("Mussktwup", Arrays.asList(new String[]{"1"}));
            //File file = fc.getCurrentDirectory();
            //File f2 = fc.getSelectedFile().getAbsolutePath()
            jTextArea1.append(fc.getSelectedFile().getAbsolutePath()+"\n");
            jTextArea1.setEnabled(false);
            model.addRow(new Object[]{fc.getSelectedFile().getAbsolutePath(), 0});
            this.invalidate();
            this.repaint();
            jProgressBar1.setIndeterminate(true);
            new MySpecialCounter().execute();
 
            
        } else {
            //Logger.log( "Open command cancelled by user.");
        }
   

        
//        ArrayList<Path> paths = new ArrayList<Path>();
//        Path path = Paths.get("/home/edm");
//        try
//        {
//          DirectoryStream<Path> stream;
//          stream = Files.newDirectoryStream(path);
//          for (Path entry : stream)
//          {
//            paths.add(entry);
//          }
//          stream.close();
//        }
//        catch (IOException e)
//        {
//          e.printStackTrace();
//        }
//        ArrayList<File> upperfiles = new ArrayList<>();
//        List<String> uppercasedPaths = paths.stream().map(f -> f.toString().toUpperCase()).collect(Collectors.toList());
//        uppercasedPaths.stream().forEach(a -> upperfiles.add(new File(a)));
//        for (Path entry: paths)
//        {
//          Component c = new JTextField(entry.getFileName().toString());
//          
//        }
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        List targetDirs = StartupConfig.getSetting("TARGETDIRS");
        if (targetDirs.isEmpty()) {
            JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
        } else {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            //jProgressBar1.setIndeterminate(true);
            jButton1.setEnabled(false);
            Subject<Path> subject = new Subject<>();

            subject.register(fco);



            class MySyncer extends SwingWorker<Object, Void> {
                @Override
                protected Object doInBackground(){
                    DirContainer.sync();
                    return null;
                }
                @Override
                protected void done(){
                    jButton1.setEnabled(true);
                    //jProgressBar1.setIndeterminate(false);
                }
            }

            class MyWorker extends SwingWorker<Object, Void> {

                @Override
                protected Object doInBackground(){
                     //new Thread (() -> {
                    //DirContainer.countFiles();
                     //}).start();
                    return null;
                }
                @Override
                protected void done() {
                    jProgressBar1.setVisible(true);
                    jProgressBar1.setValue(0);
                    jProgressBar1.setMaximum(DirContainer.getCountedFiles());
                    new MySyncer().execute();
                }
            }
            new MyWorker().execute();
        }
        
        
      
       
      
       
       
       
        
        
        
        
        
        
        //DirContainer.getDirs().stream().forEach(f->c.accept(f));
//        try {
//            DirContainer.listFiles();
//        } catch (IOException ex) {
//            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        System.out.println();
        
       
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextArea2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTextArea2ComponentAdded
        // TODO add your handling code here:
        jTextArea2.scrollRectToVisible(jTextArea2.getVisibleRect());
    }//GEN-LAST:event_jTextArea2ComponentAdded

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        final JFileChooser fc = new JFileChooser();fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            DirContainer.addDir(file);
            StartupConfig.putSetting("TARGETDIRS", Arrays.asList(new File(fc.getSelectedFile().toString())));
            //StartupConfig.putSetting("Mussktwup", Arrays.asList(new String[]{"1"}));
            //File file = fc.getCurrentDirectory();
            //File f2 = fc.getSelectedFile().getAbsolutePath()
            jTextArea3.append(fc.getSelectedFile().getAbsolutePath()+"\n");
            //jTextArea1.setEnabled(false);
            
            //this.invalidate();
            //this.repaint();
            
            
 
            
        } 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
