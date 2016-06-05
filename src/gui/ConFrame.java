package gui;

<<<<<<< HEAD
        import basics.Connection;
        import basics.Data;
        import basics.Json;
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
=======
import basics.Connection;
import basics.Location;
import storage.Database;
import threads.ArrayListContainer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
>>>>>>> origin/master

/**
 * Created by Leo on 04/06/16.
 */
<<<<<<< HEAD
public class ConFrame extends JPanel {

    public ArrayList<Connection> model;
    JTextField nameField1;
    JTextField nameField2;


    public ConFrame() {
        nameField1 = new JTextField("From");
        nameField1.setColumns(40);
        nameField2 = new JTextField("To");
        nameField2.setColumns(40);
        this.add(nameField1);
        this.add(nameField2);

        JButton b = new JButton("Search");
        this.add(b);
=======
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
>>>>>>> origin/master

        b.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {

<<<<<<< HEAD
                                    try {
                                        addButtonActionPerformed(evt,nameField1.getText(),nameField2.getText());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
=======
                                    addButtonActionPerformed(evt,nameField.toString(),toField.toString());
>>>>>>> origin/master

                                }
                            }
        );
    }

<<<<<<< HEAD
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt,String namef,String namet) throws IOException,SQLException {
        // 3rd jtabbedpane, + file explorer
        if (!Database.isConnected()) {
            Database.connect("it21332", "dit21332");
        }
        Connection Conn = new Connection();
        Conn = Database.getCon(namef, namet);
        if(Conn.getIdf()== 0){
            JOptionPane.showMessageDialog(this,
                    "Your Location is invalid. Try again.",
                    "Location error",
                    JOptionPane.ERROR_MESSAGE);
        }
        ArrayList<Data> data ;
        data = Json.getData(Conn);
        if(data.size()==0){
            //Dialog
        }else {
            shower(data);
        }
    }

    public void shower(ArrayList<Data> dt){
        JFrame jf =new JFrame();

        jf.setLocation(600,500);
        jf.setSize(400,600);
        //String[] columnNames = {"From", "ID", "To", " ID "};
        String[] columnNames = {"Arrival", "Department"};
        Object[][] locs = new Object[2][dt.size()];
        for(int x=0;x<dt.size();x++){
            for(int y=0;y<2;y++){
                if(y==0) {
                    locs[y][x] = dt.get(x).getDepart();
                }else{
                    locs[y][x] = dt.get(y).getArrival();
                }
            }
        }



        TableModel modelt = new DefaultTableModel(locs,columnNames);
        JTable table = new JTable(modelt);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        jf.getContentPane().setLayout(new BorderLayout());
        jf.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
        jf.add(table, BorderLayout.CENTER);
        jf.setVisible(true);
    }
}
=======
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
>>>>>>> origin/master
