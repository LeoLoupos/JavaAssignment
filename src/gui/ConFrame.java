package gui;

import basics.Connection;
import basics.Location;
import storage.Database;
import threads.ArrayListContainer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Leo on 04/06/16.
 */
public class ConFrame extends JFrame {

    public ArrayList<Connection> model;
    JTextField nameField;
    JTextField toField;


    public ConFrame(ArrayList<Connection> arr){
        this.model = arr;
        this.setSize(800, 800);

        this.setLayout(new FlowLayout());
        Container def = this.getContentPane();

        nameField = new JTextField("");
        toField = new JTextField("");
        nameField.setColumns(40);
        toField.setColumns(40);
        def.add(nameField);
        def.add(toField);
        JButton b = new JButton("Search");
        def.add(b);
        JButton b1 = new JButton("Exit");
        def.add(b1);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {

                                    addButtonActionPerformed(evt,nameField.toString(),toField.toString());

                                }
                            }
        );
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt,String namef,String namet) {
        JFrame j = new JFrame();
        int y =0;
        for(int i=0;i<=model.size();i++){
            Connection co ;
            co = new Connection();
            //co = (Connection) model.getElementAt(i);

            String tmpf = co.getFromname();
            String tmpt = co.getToname();
            if(tmpf==namef && tmpt==namet){
                shower(co);
                y++;

            }

        }

        if(y<1){
            JPanel jpa = new JPanel();
            JTextArea jt = new JTextArea("Oops");
            j.setSize(400,400);
            j.getContentPane().setLayout(new BorderLayout());
            j.getContentPane().add(j,BorderLayout.SOUTH);
            jpa.add(jt);
            j.setVisible(true);
        }


    }


    public void shower(Connection con ){
        JFrame jf =new JFrame();
        jf.setSize(400,600);
        String[] columnNames = {"From", "to", " IDfrom ", " IDto "};
        Object[][] cons ={
                {con.getFromname(),con.getToname(),con.getIdf(),con.getIdt()},
                {}
        };
        TableModel model = new DefaultTableModel(cons, columnNames);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        jf.getContentPane().setLayout(new BorderLayout());
        jf.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);

        jf.add(table, BorderLayout.CENTER);
        jf.setVisible(true);
    }

    //public void setList(DefaultListModel dlm){
      //  this.model = dlm;


    //}
}
