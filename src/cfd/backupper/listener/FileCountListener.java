/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author edm
 */
public class FileCountListener implements ChangeListener{

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println(e.toString());
    }
    
}
