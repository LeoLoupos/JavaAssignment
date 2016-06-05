package threads;

import basics.Location;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by user on 6/3/2016.
 */
public class ArrayListContainer {


        public ArrayList<Location> alllocs;

        public ArrayListContainer() {
            alllocs = new ArrayList<Location>();
        }

        /**
         * Adds the human object to the list
         * @param h The object to add
         */
        public synchronized void add(Location h) {
            alllocs.add(h);
        }

        public synchronized  int retSize(){
            return  alllocs.size();
        }



    }


