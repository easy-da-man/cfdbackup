/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.observer;

/**
 *
 * @author edm
 */
public interface ObservingBehaviour<R, T> {
    public R update(T t);
}
