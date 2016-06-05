package gui;

<<<<<<< HEAD
import basics.Json;
=======
import basics.Connection;
>>>>>>> origin/master
import basics.Location;
import storage.Database;
import threads.ArrayListContainer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 6/1/2016.
 */
public class Frame extends JFrame {

<<<<<<< HEAD
=======
    private class myActionListener
    {
        void sayHello(){
            System.out.println("Hello"+nameField);
        }
    }
    JMenuBar menuBar;

>>>>>>> origin/master
    private DefaultListModel localModel;
    JTextField nameField;


    public Frame(DefaultListModel dlm) {
        this.localModel = dlm;
<<<<<<< HEAD
        JPanel jp = new JPanel();

        JPanel jloc = new JPanel();
        ConFrame jcon = new ConFrame();
        //Filegui jfile = new Filegui();
        JTabbedPane tabby = new JTabbedPane( );
        tabby.addTab("Location",jloc);
        tabby.addTab("Connection",jcon);
        //tabby.addTab("Save File",jfile);

        this.add(tabby);
        this.setLocation(500,500);
        this.setSize(1200, 200);
=======
        MenuBar mb = new MenuBar();
        mb.add(new Menu("Location"));
        mb.add(new Menu("Connection"));
        this.setMenuBar(mb);

        this.setSize(800, 800);
>>>>>>> origin/master
        this.setLayout(new FlowLayout());

        nameField = new JTextField("");
        nameField.setColumns(40);
<<<<<<< HEAD
        jloc.add(nameField);
        JButton b = new JButton("OK");
        jloc.add(b);
        JButton b2 = new JButton("Cancel");
        jloc.add(b2);

        //Connection frame Button;
        JButton Conb = new JButton("Cancel");
        jcon.add(Conb);


        this.getContentPane().add(jp);

=======
        def.add(nameField);

        JButton b = new JButton("Search");
        def.add(b);
        JButton b1 = new JButton("Search Connections");
        def.add(b1);
        JButton b2 = new JButton("Exit");
        def.add(b2);
>>>>>>> origin/master
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {

                                    try {
                                        addButtonActionPerformed(evt,nameField.getText());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }
        );


        b2.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    dispose();

                                }
                            }
        );

<<<<<<< HEAD
        Conb.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                     dispose();

                                 }
                             }
        );

=======
        b1.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {

                                    addButton2ActionPerformed(evt);

                                }
                            }
        );

    }
    private void addButton2ActionPerformed(java.awt.event.ActionEvent evt){

        ArrayList<Connection> cons;

        if(!Database.isConnected()){
            Database.connect("it21332","dit21332");
        }

        cons  = Database.getAllCons();
        ConFrame cf = new ConFrame(cons);

        //cf.setList(cons);
        cf.setVisible(true);
>>>>>>> origin/master
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt,String name) throws IOException {
        JFrame j = new JFrame();
        if(localModel.contains(name)){
            ArrayList<Location> loc ;
            //ArrayListContainer ar = new ArrayListContainer();
            if(!Database.isConnected()){
                Database.connect("it21332","dit21332");
            }
            loc = Database.readCitiesFromDB();
            for(Location l : loc){
                System.out.println(l.getName());
                if(l.getName().equals(name)){
                    shower(l);
                }
            }

        }else{
            //// Crawl the city
            Location l = Json.getLoc(name);
            if(l.getId()==0){
                //Some Error Cities have id = 0
                JOptionPane.showMessageDialog(j,
                        "Your Location is invalid. Try again.",
                        "Location error",
                        JOptionPane.ERROR_MESSAGE);
            }else{
                shower(l);
            }
        }
    }

    public void shower(Location l){
        JFrame jf =new JFrame();
<<<<<<< HEAD

        jf.setLocation(600,500);
=======
>>>>>>> origin/master
        jf.setSize(400,600);
        String[] columnNames = {"Location Name", "ID", " X ", " Y "};
        Object[][] locs ={
                {l.getName(),l.getId(),l.getX(),l.getY()},
                {}
        };
<<<<<<< HEAD
        TableModel modelt = new DefaultTableModel(locs,columnNames);
        JTable table = new JTable(modelt);
=======
        TableModel model = new DefaultTableModel(locs, columnNames);

        JTable table = new JTable(model);
>>>>>>> origin/master
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        jf.getContentPane().setLayout(new BorderLayout());
        jf.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);

        jf.add(table, BorderLayout.CENTER);
        jf.setVisible(true);
    }

}