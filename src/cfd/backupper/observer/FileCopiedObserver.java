/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.observer;

import java.nio.file.Path;

/**
 *
 * @author edm

 */
public class FileCopiedObserver<Path> extends Observer {
    
    protected Subject subject = null;

    @Override
    public Object update(Object t) {
        System.out.println("The path is:"+ ((Path) t).toString());
        return (Path) t;
    }

    

  

 

    
    
    
    
}
