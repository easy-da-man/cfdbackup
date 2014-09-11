/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.uilogger;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author edm
 */
public class Logger {
    
    
    private static ArrayList<SuperLogger> superloggers = new ArrayList<>();
    
    
    
    public static void log(String content, LoggaLogic ll){
      superloggers.forEach(sl -> {
          sl.log(content, ll);
      });
      
    }
    
    public static void addSuperLogger(Component c, LoggaLogic ll) {
        superloggers.add(new SuperLogger(c, ll));
    }
    
}
