/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Lenovo
 */
public class ControllerMovie {
    ModelMovie modelMovie;
    ViewMovie viewMovie;

    ControllerMovie(ModelMovie model, ViewMovie view) {
        this.modelMovie = model;
        this.viewMovie = view;
        
        if (modelMovie.getData()!=0) {
            String dataMovie[][] = modelMovie.readMovie();
            viewMovie.table.setModel((new JTable(dataMovie, viewMovie.columnName)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data doesn't exist");
        }
        
        viewMovie.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Title = viewMovie.getTitle();
                String Plot = viewMovie.getPlot();
                String Char = viewMovie.getChar();
                String Act = viewMovie.getAct(); 
                modelMovie.insertData(Title, Plot, Char, Act);
         
                String dataMovie[][] = modelMovie.readMovie();
                viewMovie.table.setModel((new JTable(dataMovie, viewMovie.columnName)).getModel());
            }
        });
        
        viewMovie.btnReset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                viewMovie.hapusLayar();
            }
            
        });
        
        viewMovie.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Title = viewMovie.getTitle();
                String Plot = viewMovie.getPlot();
                String Char = viewMovie.getChar();
                String Act = viewMovie.getAct(); 
                modelMovie.insertData(Title, Plot, Char, Act);
                
                String dataMovie[][] = modelMovie.readMovie();
                viewMovie.table.setModel((new JTable(dataMovie, viewMovie.columnName)).getModel());
            }
        });
        
        viewMovie.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int row = viewMovie.table.getSelectedRow();
                
                String selectedData = viewMovie.table.getValueAt(row, 0).toString();

                System.out.println(selectedData);

                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete " + selectedData + "?", "Option...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelMovie.deleteMovie(selectedData);
                    String dataMovie[][] = modelMovie.readMovie();
                    viewMovie.table.setModel(new JTable(dataMovie, viewMovie.columnName).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Delete Cancel");
                }
            }
        }
        );
    }
    
}
