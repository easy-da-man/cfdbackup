/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.fileoperation;

import static cfd.backupper.fileoperation.DirContainer.filesCounted;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author edm
 */
public class FilesAndDirInfo {
    
    
    SwingWorker<Object, Object> sw;
    File dir;
    ArrayList<File> files = new ArrayList<>();
    int size = 0;

    public FilesAndDirInfo() {
        this.sw = new SwingWorker<Object, Object>() {
            
            @Override
            protected Object doInBackground() throws Exception {
                return null;
                //
            };
            @Override
            protected void done(){
                
            };
        };
    }
    
    
    int countFiles() {
        filesCounted = false;
        //filesToBackup.clear();
        
        
        
        try {
            
//            Path dirPath;
//            dirPath = Paths.get(dir.toString());
            Files.walk(dir.toPath()).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    synchronized(files){
                        files.add(filePath.toFile());
                        size+=filePath.toFile().length();
                    }
                    try {
                        System.out.println(filePath.toString());
                        System.out.println(Files.readAttributes(filePath, "*"));
                    } catch (IOException ex) {
                        Logger.getLogger(DirContainer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //progressBar.setState(filesToBackup.size());
                    //cfd.backupper.Logger.log(Integer.toString(filesToBackup.size()));
                }
            });
        } catch (IOException | java.io.UncheckedIOException ex) {
            //Logger.getLogger(DirContainer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return size;
       
       
    }
    
   
    
    
}
