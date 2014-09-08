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

public class Observer<R, T> implements ObservingBehaviour<R,T> {

    protected Subject subject = null;
    
    public void setSubject(Subject s) {
        if (this.subject != null) {
            this.subject.remove(this);
        }
        this.subject = s;
        
        if (this.subject != null) {
            this.subject.register(this);
        }
    }

    @Override
    public  R update(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


 
    
}

