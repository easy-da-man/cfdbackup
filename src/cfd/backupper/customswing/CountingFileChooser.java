/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.customswing;

import static cfd.backupper.MainForm.jProgressBar1;
import cfd.backupper.fileoperation.DirContainer;
import cfd.backupper.state.StartupConfig;
import cfd.backupper.workers.CountAllFilesInDirectory;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edm
 */
public class CountingFileChooser {
    
    public CountingFileChooser(){
         //Handle open button action.
        final JFileChooser fc = new JFileChooser();
        final DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        class MySpecialCounter extends CountAllFilesInDirectory{
            @Override
            protected void done(){
                model.setValueAt(MySpecialCounter.getCount(),model.getRowCount()-1, model.getColumnCount()-2);
                jProgressBar1.setIndeterminate(false);
            }
        }
        
        
        
        //int returnVal = fc.showOpenDialog(MainForm.this);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setMultiSelectionEnabled(true);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            jProgressBar1.setIndeterminate(true);
            File[] file = fc.getSelectedFiles();
            for (int i = 0; i < file.length; i++) {
                File file1 = file[i];
                DirContainer.addDir(file1);
                StartupConfig.putSetting("BACKUPDIRS", DirContainer.getDirs());
                jTextArea1.append(file1.getAbsolutePath()+"\n");
                
                model.addRow(new Object[]{file1.getAbsolutePath(), 0});
                new MySpecialCounter().execute();
            }
            
            jTextArea1.setEnabled(false);
            
            this.invalidate();
            this.repaint();
            
            //new MySpecialCounter().execute();
 
    }
    
}
