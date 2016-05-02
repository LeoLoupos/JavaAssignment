package storage;

import basics.Connection;
import basics.Location;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 5/2/2016.
 */
public class FileUtilities {


    public static void writeLoc(String filename,boolean overwrite,ArrayList<Location> arr){

        try {
            //"Text/cities.txt"
            File f = new File(filename);
            if(f.exists()&& !f.isDirectory()){
                overwrite=false;
            }else{
                f.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(f,overwrite));

            for (Location w : arr) {
                writer.write(w.toString());
                writer.newLine();
            }
            writer.close();
            System.out.println("Write Loc done!");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCitiesCon(String filename, boolean overwrite,ArrayList<Connection> arrCon) {
        try {
            //"Text/cities.txt"
            File f = new File(filename);
            if(f.exists()&& !f.isDirectory()){
                overwrite=false;
            }else{
                f.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            for (Connection w : arrCon) {
                writer.write(w.toString());
                writer.newLine();
            }
            writer.close();
            System.out.println("Write Con done!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
