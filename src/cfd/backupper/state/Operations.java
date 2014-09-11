/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.state;

/**
 *
 * @author edm
 */
public class Operations {
    
    static volatile int fileCopyOperations = 0;
    public static synchronized void incFileCopyOperations(){fileCopyOperations++;}
    public static synchronized int getFileCopyOperations(){
        return fileCopyOperations;
    }
    
}
