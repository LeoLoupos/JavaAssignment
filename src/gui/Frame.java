package gui;

import basics.Location;
import storage.Database;
import threads.ArrayListContainer;

import javax.swing.*;
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

    private DefaultListModel localModel;
    JTextField nameField;
    JTextField ageField;

    public Frame(DefaultListModel dlm) {
        this.localModel = dlm;
        MenuBar mb = new MenuBar();
        mb.add(new Menu("Location"));
        mb.add(new Menu("Connection"));
        this.setMenuBar(mb);

        this.setSize(400, 800);
        this.setLayout(new FlowLayout());
        Container def = this.getContentPane();

        nameField = new JTextField("");
        nameField.setColumns(40);
        def.add(nameField);

        JButton b = new JButton("OK");
        def.add(b);
        JButton b2 = new JButton("Cancel");
        def.add(b2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {

                                        addButtonActionPerformed(evt,nameField.getText());

                                }
                            }
        );

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
        jf.setSize(100,200);
        String[] columnNames = {"Location Name", "ID", " X ", " Y "};
        Object[][] locs ={
                {l.getName(),l.getId(),l.getX(),l.getY()},
                {}
        };
        JTable table = new JTable(locs, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        jf.getContentPane().setLayout(new BorderLayout());
        jf.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
        jf.add(table, BorderLayout.CENTER);
        jf.setVisible(true);
    }

}