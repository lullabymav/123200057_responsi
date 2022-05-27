/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ViewMovie extends JFrame{
    // GUI
    JLabel lTitle = new JLabel("Title");
    JLabel lPlot = new JLabel("Plot");
    JLabel lChar = new JLabel("Character");
    JLabel lAct = new JLabel("Acting");
    
    JTextField fTitle = new JTextField();
    JTextField fPlot = new JTextField();
    JTextField fChar = new JTextField();
    JTextField fAct = new JTextField();
    
    JButton btnAdd = new JButton("Add");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnReset = new JButton("Clear");
    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object columnName[] = {"Title", "Plot", "Character", "Acting", "Score"};

    public ViewMovie() {
        tableModel = new DefaultTableModel(columnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        setTitle("Movie Data");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(700,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lTitle);
        lTitle.setBounds(510, 20, 90, 20);
        add(fTitle);
        fTitle.setBounds(510, 40, 120, 20);
        
        add(lPlot);
        lPlot.setBounds(510, 60, 90, 20);
        add(fPlot);
        fPlot.setBounds(510, 80, 120, 20);
        
        add(lChar);
        lChar.setBounds(510, 100, 90, 20);
        add(fChar);
        fChar.setBounds(510, 120, 120, 20);
        
        add(lAct);
        lAct.setBounds(510, 140, 90, 20);
        add(fAct);
        fAct.setBounds(510, 160, 120, 20);
        
        add(btnAdd);
        btnAdd.setBounds(510, 190, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
    }
    
    public String getTitle(){
        return fTitle.getText();
    }
    
    public String getPlot(){
        return fPlot.getText();
    }
    
    public String getChar(){
        return fChar.getText();
    }
    
    public String getAct(){
        return fAct.getText();
    }
    
    public void hapusLayar(){
        fTitle.setText("");
        fPlot.setText("");
        fChar.setText("");
        fAct.setText("");
    }
}
