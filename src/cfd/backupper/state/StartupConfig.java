/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.state;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




/**
 *
 * @author edm
 */
public class StartupConfig {
    static final File targetDir = new File(System.getProperty("user.home")+File.separator+"UltraBackup");
    static final File confFile = new File(targetDir + File.separator + "ultrabackup.json");
    static JSONObject jo = new JSONObject();
    static StartupConfig instance = null;
    
    static {
        System.out.println(targetDir.toPath());
        targetDir.mkdirs();
        if (!confFile.exists()) {
            try {
                confFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(StartupConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jo = deserializeConfFile();
        
    }
    
    public static StartupConfig get(){
        if (instance == null)
            instance = new StartupConfig();
        return instance;
    }
    
    private StartupConfig(){
        
    }
    
    public static void putSetting(String key, List l){
        
        //l needs to be toString(), otherwise there are no doublequotes in JSON.
        List stringedList = (List) l.stream().map(elem -> elem.toString()).collect(Collectors.toList());
        if (jo.containsKey(key)) {
            jo.replace(key, stringedList);
        } else {
            jo.put(key, stringedList);
        }
        try {
            FileWriter fw = new FileWriter(confFile, false);
            fw.append(jo.toJSONString());
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(StartupConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static JSONObject deserializeConfFile(){
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fr = new FileReader(confFile);
            if (fr.ready()) {
                jsonObject = (JSONObject) jsonParser.parse(fr);
                return jsonObject;
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StartupConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(StartupConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonObject;
    }
    
    
    
}
