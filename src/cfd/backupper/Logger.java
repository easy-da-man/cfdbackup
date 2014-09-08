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
    
    public static void log(JTextArea area, String content) {
        area.append(content+"\n");
    }
}
