/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.observer;

import cfd.backupper.MainForm;
import cfd.backupper.state.Operations;
import cfd.backupper.uilogger.JTextAreaLogger;
import cfd.backupper.uilogger.JTextFieldLogger;
import cfd.backupper.uilogger.LoggaLogic;
import cfd.backupper.uilogger.Logger;
import java.nio.file.Path;

/**
 *
 * @author edm

 */
public class FileCopiedObserver<Path> extends Observer {
    
    protected Subject subject = null;
    JTextAreaLogger textAreaLogger = new JTextAreaLogger();
    JTextFieldLogger textFieldLogger = new JTextFieldLogger();

    @Override
    public Object update(Object t) {
        //System.out.println("The path is:"+ ((Path) t).toString());
        Logger.log("Copied: " + ((Path) t).toString(), textAreaLogger);
        Logger.log(Integer.toString(Operations.getFileCopyOperations()), textFieldLogger);
        MainForm.jProgressBar1.setValue(Operations.getFileCopyOperations());
        return (Path) t;
    }

    

  

 

    
    
    
    
}
