/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.observer;

/**
 *
 * @author edm
 * @param <Integer>
 */
public class ProgressBarObserver<Integer, R> extends Observer {

    protected Subject subject = null;
    

    @Override
    public R update(Object t) {
        
        System.out.println("The count is: "+t.toString());
        return (R)t;
    }
    
}
