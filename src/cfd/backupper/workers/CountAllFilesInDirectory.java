/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.backupper.workers;

import cfd.backupper.fileoperation.DirContainer;
import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingWorker;

/**
 *
 * @author edm
 */
public class CountAllFilesInDirectory extends SwingWorker<Object, Object> {

    static int count = 0;
    //this list is used to remember amounts of prior counts.
    //reason: in DirContainer the files that need to be backupped
    //are always added to a global list and said list thus grows.
    //the use case here is to have the current amount of files per directory
    //and not the amount of all files...
    //so the values in the following list are subtracted in order
    //to return a compute a correct value.
    //value.
    static ArrayList<Integer> lastCounts = new ArrayList<Integer>();
    public CountAllFilesInDirectory(File dir){}
    
    @Override
    protected Object doInBackground() throws Exception {
        lastCounts.add(count);
        count = DirContainer.countFiles();
        //this is actually just for wanking. but it is a good wank!
        count = count - lastCounts.stream().reduce((t, accValue) -> t+accValue ).get();
        return null;
    }
    @Override
    protected void done() {
    }
    public static int getCount(){
        return count;
    }
}
