package Main;

import basics.Connection;
import basics.Data;
import basics.Json;
import basics.Location;
import storage.Database;
import storage.FileUtilities;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 5/2/2016.
 */
public class Main {
    public static ArrayList<Location> arr= new ArrayList<>();
    public static ArrayList<Connection> arrCon = new ArrayList<>();
    public static ArrayList<Connection> newCon = new ArrayList<>();
    public static   ArrayList<Data> arrData = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        arr =  Json.Wiki();
        Json.UpdateLoc(arr);
        Json.DoubleCheck(arr);
        //All conns
        arrCon = Json.UpdateCon(arr,arrCon);

        //Clean cons
        newCon = Json.CleanCon(arrCon);
        arrData = Json.getData(newCon);

        FileUtilities.writeLoc("Text/cities.txt",false,arr);
        FileUtilities.writeCitiesCon("Text/directlinks.txt",false,arrCon);
        Database.connect();

    }
}
