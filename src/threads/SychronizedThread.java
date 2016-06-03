package threads;

import basics.Location;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 6/3/2016.
 */

class SynchronizedThread implements Runnable {
    int threadid;
    boolean isDone;
    public ArrayListContainer threadhuman;

    public SynchronizedThread(int threadid,ArrayListContainer threadhuman){
//        this.o=o;
        this.isDone=false;
        this.threadid=threadid;
        this.threadhuman=threadhuman;
    }
    public void run() {
        System.out.println(threadid+": Sleep for 5 sec");
        try {
            for (int i=0;i<50;i++){
                Location h=new Location(threadid+"",i);
                threadhuman.add(h);
            }
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchronizedThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Wake up");
        this.isDone=true;
    }

    public boolean isDone(){
        return isDone;
    }
}
