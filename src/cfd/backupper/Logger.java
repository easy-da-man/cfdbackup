/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper;

import javax.swing.JTextArea;

/**
 *
 * @author edm
 */
public class Logger {
    
    private static JTextArea loggableField;
    
    public Logger(JTextArea logField) {
        loggableField = logField;
    }
    
    public static void log(String content) {
        loggableField.append(content+"\n");
    }
}
