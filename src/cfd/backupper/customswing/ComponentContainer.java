/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.customswing;

import java.awt.Component;
import java.util.HashMap;

/**
 *
 * @author edm
 * 
 * Contains all the used Components that are needed by underlying / consuming
 * processes.
 */
public class ComponentContainer {
    
    private static HashMap<String, Component> components = new HashMap<>();
    public static void add(String name, Component c) {
        System.out.println("Component added");
        components.put(name, c);
    }
    public static Component get(String name){
        return components.get(name);
    }
    
}
