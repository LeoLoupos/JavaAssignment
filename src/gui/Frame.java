package gui;

import basics.Connection;
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

    private class myActionListener
    {
        void sayHello(){
            System.out.println("Hello"+nameField);
        }
    }
    JMenuBar menuBar;

    private DefaultListModel localModel;
    JTextField nameField;
    JTextField ageField;

    public Frame(DefaultListModel dlm) {
        this.localModel = dlm;
        MenuBar mb = new MenuBar();
        mb.add(new Menu("Location"));
        mb.add(new Menu("Connection"));
        this.setMenuBar(mb);

        this.setSize(800, 800);
        this.setLayout(new FlowLayout());
        Container def = this.getContentPane();

        nameField = new JTextField("");
        nameField.setColumns(40);
        def.add(nameField);

        JButton b = new JButton("Search");
        def.add(b);
        JButton b1 = new JButton("Search Connections");
        def.add(b1);
        JButton b2 = new JButton("Exit");
        def.add(b2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {

                                        addButtonActionPerformed(evt,nameField.getText());

                                }
                            }
        );

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
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt,String name) {
        JFrame j = new JFrame();

        if(localModel.contains(name)){
            ArrayList<Location> loc ;
            ArrayListContainer ar = new ArrayListContainer();

            if(!Database.isConnected()){
                Database.connect("it21332","dit21332");
            }

            loc = Database.readCitiesFromDB();

            int i =0;
            for(Location l : loc){
                if(l.getName().equals(name)){
                    shower(l);
                    i++;
                }
            }

        }else{
            //Crawl the city
            JPanel jp = new JPanel();
            JTextArea jt = new JTextArea("Oops");
            j.setSize(200,400);
            j.getContentPane().setLayout(new BorderLayout());
            j.getContentPane().add(jp,BorderLayout.SOUTH);
            jp.add(jt);
            j.setVisible(true);
        }
    }

    public void shower(Location l){
        JFrame jf =new JFrame();
        jf.setSize(400,600);
        String[] columnNames = {"Location Name", "ID", " X ", " Y "};
        Object[][] locs ={
                {l.getName(),l.getId(),l.getX(),l.getY()},
                {}
        };
        TableModel model = new DefaultTableModel(locs, columnNames);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        jf.getContentPane().setLayout(new BorderLayout());
        jf.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);

        jf.add(table, BorderLayout.CENTER);
        jf.setVisible(true);
    }

}