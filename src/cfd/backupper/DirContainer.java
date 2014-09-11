/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper;

import cfd.backupper.copying.SyncerSourceToTarget;
import cfd.backupper.observer.FileCopiedObserver;
import cfd.backupper.observer.ProgressBarObserver;
import cfd.backupper.observer.Subject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edm
 */
public class DirContainer {
    private static ArrayList<File> dirsToBackup = new ArrayList<File>();
    private static ArrayList<File> filesToBackup = new ArrayList<File>();
    
    
    static ProgressBarObserver pbo = new ProgressBarObserver();
    static FileCopiedObserver fco = new FileCopiedObserver();
    static Subject<Integer> progressBar = new Subject();
    static Subject<Path> fileCopied = new Subject();
    static {
        pbo.setSubject(progressBar);
        fco.setSubject(fileCopied);
    }
    
    static boolean filesCounted = false;
    
    public static void addDir(File dir) {
        dirsToBackup.add(dir);
    }
    
    public static int getCountedFiles () {
        return filesToBackup.size();
    }
    
    public static ArrayList<File> getDirs() {
        return dirsToBackup;
    }
    
    public static void listFiles() throws IOException{
        
        
        dirsToBackup.forEach(dir -> {
            try {
                Files.walk(Paths.get(dir.toString())).forEach(filePath -> {
                    if (Files.isRegularFile(filePath)) {
                        //System.out.println(filePath);
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(DirContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public static int countFiles() {
        filesCounted = false;
        filesToBackup.clear();
        dirsToBackup.forEach(dir -> {
            try {
                Files.walk(Paths.get(dir.toString())).forEach(filePath -> {
                    
                    if (Files.isRegularFile(filePath)) {
                       
                        filesToBackup.add(filePath.toFile());
                        
                        //progressBar.setState(filesToBackup.size());
                        //cfd.backupper.Logger.log(Integer.toString(filesToBackup.size()));
                    }
                });
            } catch (IOException | java.io.UncheckedIOException ex) {
                //Logger.getLogger(DirContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        progressBar.setState(filesToBackup.size());
        filesCounted = true;
        return filesToBackup.size();
    }
    
    public static void sync() {
        System.out.println("sync()");
        while (filesCounted != true) {
            
        }
        SyncerSourceToTarget syncer = new SyncerSourceToTarget();
        syncer.sync(filesToBackup);
    }
}
