/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edm
 */
public class Subject<T> {
    private ArrayList<ObservingBehaviour> observers = new ArrayList<ObservingBehaviour>();
    
    private T state = null;
   
    public void message(){
        observers.forEach(o -> o.update(state));
    }
    public void remove(ObservingBehaviour o){
        observers.remove(o);
    }
    public Object getState(){
        return state;
    }
    public void setState(T newState) {
        state = newState;
        message();
    }
    public void register(ObservingBehaviour o) {
        observers.add(o);
    }
}
