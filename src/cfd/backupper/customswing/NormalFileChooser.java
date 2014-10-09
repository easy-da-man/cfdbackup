/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.customswing;

import cfd.backupper.fileoperation.DirContainer;
import cfd.backupper.state.StartupConfig;
import java.awt.Component;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edm
 */
public class NormalFileChooser {
 
    
    public NormalFileChooser(){}
    public void chooseDir(Component c) {
        
        final DefaultTableModel tableModel;
        final JTable tmpTable; 
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            DirContainer.addDir(file);
            StartupConfig.putSetting("TARGETDIRS", Arrays.asList(new File(fc.getSelectedFile().toString())));
            
            tmpTable = (JTable)c;
            tableModel = (DefaultTableModel) tmpTable.getModel();
            
            //tableModel.addColumn(model.addRow(new Object[]{file1.getAbsolutePath(), 0}););
            //StartupConfig.putSetting("Mussktwup", Arrays.asList(new String[]{"1"}));
            //File file = fc.getCurrentDirectory();
            //File f2 = fc.getSelectedFile().getAbsolutePath()
            //jTextArea3.append(fc.getSelectedFile().getAbsolutePath()+"\n");
            //jTextArea1.setEnabled(false);
            
            //this.invalidate();
            //this.repai
            System.out.println(file.toPath());
            
        }
            
    }
    
}
