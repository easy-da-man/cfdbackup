/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edm
 */
public class DirContainer {
    private static ArrayList<File> dirsToBackup = new ArrayList<File>();
    
    public static void addDir(File dir) {
        dirsToBackup.add(dir);
    }
    
    public static ArrayList<File> getDirs() {
        return dirsToBackup;
    }
    
    public static void listFiles() throws IOException{
        dirsToBackup.forEach(dir -> {
            try {
                Files.walk(Paths.get(dir.toString())).forEach(filePath -> {
                    if (Files.isRegularFile(filePath)) {
                        System.out.println(filePath);
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(DirContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
}
