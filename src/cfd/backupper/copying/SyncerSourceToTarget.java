/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.copying;

import cfd.backupper.observer.FileCopiedObserver;
import cfd.backupper.observer.Subject;
import cfd.backupper.state.Operations;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author edm
 * 
 * Syncs source dirs to target dir
 */
public class SyncerSourceToTarget {
    
    static FileCopiedObserver fco = new FileCopiedObserver();
    static Subject<Path> subject = new Subject();
    static {
        subject.register(fco);
    }
    
    public void sync(ArrayList<File> files){
        File targetDir = new File(System.getProperty("user.home")+File.separator+"testSync"+File.separator+"stuff");
        //File targetDir = new File("G:\\testSync");
        System.out.println(targetDir.toString());
        System.out.println(targetDir.toPath());
        
        if (targetDir.isDirectory()) {
            System.out.println("Existing");
        } else {
            System.out.println(targetDir.mkdirs());
        }
        
        Date start = new Date();
        System.out.println("Starting to copy at" +new Date().toString());
        files.stream().parallel().forEach(file -> {
            try {
                Path relative = Paths.get(file.toURI()).subpath(0, Paths.get(file.toURI()).getNameCount());
                Path target = Paths.get(targetDir+"\\"+relative);
                //System.out.println(target.toAbsolutePath());
                
                Files.createDirectories(target.getParent());
                try {
                    Files.copy(file.toPath(), target);
                    
                    synchronized(Operations.class) {
                        Operations.incFileCopyOperations();
                    }
                    subject.setState(relative);
                }
                catch(FileAlreadyExistsException e) {
                    //System.out.println("File exists");
                }
                //File copy = new File(targetDir+"\"+rel)
                //System.out.println(relative);
                //System.out.println(file.getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(SyncerSourceToTarget.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Date end = new Date();
        long difference = end.getTime() - start.getTime();
        //difference = difference % 60;
        System.out.println(difference);
        System.out.println(start.toString());
        System.out.println(end.toString());
    }
    
}
