/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.copying;

import cfd.backupper.observer.FileCopiedObserver;
import cfd.backupper.observer.Subject;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        File targetDir = new File("G:\\testSync");
        if (targetDir.isDirectory()) {
            System.out.println("Existing");
        } else {
            System.out.println(targetDir.mkdir());
        }
        System.out.println("Starting to copy");
        files.forEach(file -> {
            try {
                Path relative = Paths.get(file.toURI()).subpath(0, Paths.get(file.toURI()).getNameCount());
                Path target = Paths.get(targetDir+"\\"+relative);
                //System.out.println(target.toAbsolutePath());
                
                Files.createDirectories(target.getParent());
                try {
                    Files.copy(file.toPath(), target);
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
    }
    
}
