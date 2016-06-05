package Main;

import basics.Connection;
import basics.Data;
import basics.Json;
import basics.Location;
import gui.Frame;
import storage.Database;
import storage.FileUtilities;
import threads.ArrayListContainer;
import threads.ThreadPoolLoc;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 5/2/2016.
 */
public class Main {

    public static ArrayList<Location> arr= new ArrayList<>();
    //public static ArrayList<Connection> arrCon = new ArrayList<>();
    //public static ArrayList<Connection> newCon = new ArrayList<>();
    //public static   ArrayList<Data> arrData = new ArrayList<>();

    public static void main(String[] args) throws IOException , SQLException{
        //boolean value = false;
        //Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();

        DefaultListModel<String> model;
        Database.connect("it21332","dit21332");
        arr = Database.readCitiesFromDB();

            model = new DefaultListModel<String>();
            for(Location p : arr){
                model.addElement(p.getName());
            }
            Frame f = new Frame(model);
            f.setVisible(true);
        //ThreadPoolLoc thr = new ThreadPoolLoc();
        //try {
        //    thr.exec();
       // } catch (InterruptedException e) {
      //      e.printStackTrace();
       // }

        //value = FileUtilities.checker(s,value);
        //FileUtilities.writeCitiesToFile(s,value,arr);
        //arrData = Json.getData(newCon);
        //FileUtilities.writeLoc("Text/cities.txt",false,arr);
        //FileUtilities.writeCitiesCon("Text/directlinks.txt",false,newCon);

        Database.disconnect();


    }
}
