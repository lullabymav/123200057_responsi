/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ModelMovie {
    static final String DB_URL = "jdbc:mysql://localhost/my_movie";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection conn;
    Statement statement;
    
    private String Title;
    private int Plot, Char, Act, Score;

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setPlot(int Plot) {
        this.Plot = Plot;
    }

    public void setChar(int Char) {
        this.Char = Char;
    }

    public void setAct(int Act) {
        this.Act = Act;
    }

    public void setScore(int Score) {
        this.Score = (this.Plot + this.Char + this.Act)/3;
    }
    
    public ModelMovie() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Failed");
        }
    }
    
    public void insertData(String Title, String Plot, String Char, String Act){
        int dataTotal = 0;
        try {
//           String query = "SELECT * FROM movie WHERE title=" + Title; 
//           System.out.println(Title + " " + Plot + " " + Char + " " + Act);
//           ResultSet resultSet = statement.executeQuery(query);
//           
//           while (resultSet.next()){ 
//                dataTotal++;
//            }
            
            if (dataTotal == 0) {
               String query = "INSERT INTO `movie` (`title`,`plot`,`character`,`acting`,`score`) VALUES('" + Title + "','" + this.Plot + "','" + this.Char + "','" + this.Act + "','" + this.Score + "')";
                
                statement = (Statement) conn.createStatement();
                statement.executeUpdate(query);
                System.out.println("Input Success");
                JOptionPane.showMessageDialog(null, "Data Succesfully Added");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Already Exist");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getData(){
        int dataTotal = 0;
        try{
            statement = conn.createStatement();
            String query = "SELECT * FROM movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                dataTotal++;
            }
            return dataTotal;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] readMovie(){
        try{
            int dataTotal = 0;
            
            String data[][] = new String[getData()][5];
            
            String query = "SELECT * FROM movie"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[dataTotal][0] = resultSet.getString("title"); 
                data[dataTotal][1] = resultSet.getString("plot");                
                data[dataTotal][2] = resultSet.getString("character");
                data[dataTotal][3] = resultSet.getString("acting");
                data[dataTotal][4] = resultSet.getString("score");
                dataTotal++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void updateMovie(String Title, String Plot, String Char, String Act){
        int dataTotal = 0;
         try {
           String query = "SELECT * FROM movie WHERE title=" + Title; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                dataTotal++;
            }
           
             if (dataTotal == 1) {
                query = "UPDATE movie SET title='" + Title + "', plot='" + Plot + "', character='" + Char + "', acting='" + Act + "', score = '" + Score + "' WHERE title=" + Title;
                statement = (Statement) conn.createStatement();
                statement.executeUpdate(query);
                System.out.println("Update Success");
                JOptionPane.showMessageDialog(null, "Data has successfully updated");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data doesn't exist");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void deleteMovie (String Title) {
        try{
            String query = "DELETE FROM movie WHERE title = '"+ Title +"'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Successfully Deleted");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}

