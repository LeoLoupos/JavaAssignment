package gui;

import javax.swing.*;
import java.io.File;

/**
 * Created by user on 6/5/2016.
 */
public class Filegui extends JPanel {

    public Filegui(){
        JFileChooser fc = new JFileChooser();
        JButton b = new JButton("Save");
        this.add(b);
        int returnVal = fc.showOpenDialog(b);

        //if (returnVal == JFileChooser.APPROVE_OPTION) {
        //    File file = fc.getSelectedFile(); //το αρχείο που επέλεξε
        //    System.out.println(file.getName());
       // }
       // else {
       // }
    }
}
