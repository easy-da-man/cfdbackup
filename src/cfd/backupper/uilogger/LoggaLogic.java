/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.uilogger;

import java.awt.Component;

/**
 *
 * @author edm
 */
public interface LoggaLogic<T,R> {
    public R operate(T t, Component c);
}
