package threads;


import basics.Connection;

import java.util.ArrayList;

/**
 * Created by user on 6/5/2016.
 */
public class ArrayListContainerCon {



    public ArrayList<Connection> allcons;

    public ArrayListContainerCon() {
        allcons = new ArrayList<Connection>();
    }

    /**
     * Adds the human object to the list
     * @param h The object to add
     */
    public synchronized void add(Connection h) {
        allcons.add(h);
    }
}
