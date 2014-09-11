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
public class SuperLogger {
    protected  Component loggableField;
    protected  LoggaLogic<Object, Object> loggaLogic;


    public synchronized void log(String content, LoggaLogic ll){
        if (ll.getClass().toString().equalsIgnoreCase(loggaLogic.getClass().toString())){
            ll.operate(content, loggableField);
        }
    }
    
    public SuperLogger(Component loggableField, LoggaLogic ll) {
        this.loggableField = loggableField;
        this.loggaLogic = ll;
    }

    public  Component getLoggableField() {
        return loggableField;
    }

    public void setLoggableField(Component loggableField) {
        loggableField = loggableField;
    }

    public LoggaLogic<Object, Object> getLoggaLogic() {
        return loggaLogic;
    }

    public void setLoggaLogic(LoggaLogic<Object, Object> loggaLogic) {
        loggaLogic = loggaLogic;
    }
    
}
