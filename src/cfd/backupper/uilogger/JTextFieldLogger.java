/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.uilogger;

import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author edm
 */
public class JTextFieldLogger implements LoggaLogic<String, Object>{
    
    @Override
    public Object operate(String content, Component c) {
        ((JTextField)(c)).setText(content);
        return null;
    }
}
