/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

//import java.lang.Math;
//import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.*;
import java.util.Scanner; 
/**
 *
 * @author Velma Muhatia and Queen Frimpong
 */
public class Wavy3 {
    int randomInt;


    public Wavy3(int random){
        this.randomInt = random;
}
    
    public static void main(String[] args) {
    	
    	//File Enya = new File("enyaonebyone.wav");
    	
    	//generating pulse rate of patient
    	/**
    	int pulse = usingThreadLocalClass();
    	
    	//checking if pulse rate is stable or not
    	if (pulse < 60) {
    		JOptionPane.showMessageDialog(null,"Too Low! Admin has to calm patient down!");
    		PlaySound(Enya);
    	}
    	else if (pulse > 100) {
    		JOptionPane.showMessageDialog(null,"Too High! Admin has to calm patient down!");
    		PlaySound(Enya);
    	}
    	else if(pulse >= 60 && pulse <= 100) {
    		JOptionPane.showMessageDialog(null,"Normal!");
    	}
    	else {
    		JOptionPane.showMessageDialog(null,"Wrong!");
    	}
    	*/
    
        userdatabase();
    }
    
    static int usingThreadLocalClass() {
        
	int randomInt = ThreadLocalRandom.current().nextInt(40, 220);
	System.out.println("Random number generated is : " + randomInt);
    return randomInt;
    
	}
    
    
    static void PlaySound (File sound){
        try
        {
           Clip clip=AudioSystem.getClip(); 
           clip.open(AudioSystem.getAudioInputStream(sound));
           clip.start();
      Thread.sleep(clip.getMicrosecondLength()/1000);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error");
    }
    }
    
    static void userdatabase() {
    	// JDBC driver name and database URL
    	String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    	String DB_URL = "jdbc:mysql://localhost:3306/mental";
    	
    	//Database credentials
    	String USER = "root";
    	String PASS = "";
    	
    	Connection conn = null;
   	 	Statement stmt = null; 
   	 	PreparedStatement pstmt = null;
   	 	
   	 	
   	 try{
   		//STEP 2: Register JDBC driver
   		Class.forName(JDBC_DRIVER);
		
	    //STEP 3: Open a connection
	    System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();
	   
	    File Enya = new File("enyaonebyone.wav");
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Admin, enter patient's details below");
	    System.out.println();
	    
	    System.out.println("Name of patient:  ");
	    String username = sc.next();
	    System.out.println("Patient's Fave song: ");
	    String song= sc.next();
	    
	    int pulserr = usingThreadLocalClass();
	    
	    
	    //SQL query
	    String sql7 = "insert into mentallove "
				+ " (patientname, songchoice, pulserate)" + " values (?, ?, ?)";
	    
	    pstmt = conn.prepareStatement(sql7);
	    pstmt.setString(1, username);	
	    pstmt.setString(2, song);
	    //pstmt.setInt(3, pulser);
	    pstmt.setInt(3, pulserr);
	    
	    pstmt.executeUpdate();
	    
	    ResultSet rs = stmt.executeQuery("Select * from mentallove");
	   
   		System.out.println("Insert complete");
	    
   		
	  //STEP 5: Extract data from result set
   		
   		String pane = "";
   		int ncol = rs.getMetaData().getColumnCount();
   	    for (int i = 1; i <= ncol; i++) { 
   	        pane += rs.getMetaData().getColumnName(i) + " "; 
   	    }
   	    pane = pane + "\n";
   	    
	    while(rs.next()){
	    	
	       //Retrieve data by column name
	       String name = rs.getString("patientname") + " ";
	       String psong = rs.getString("songchoice") + " ";
	       int pulsepat = rs.getInt("pulserate");

	       //Display values
	       pane = pane + name + psong + pulsepat;
	       pane = pane + "\n";
	       
	    }
	    rs.last();
	    JOptionPane.showMessageDialog(null, pane, null, 0);
	    
	    //STEP 6: Clean-up environment
	    rs.close();
	    stmt.close();
	    conn.close();
	    sc.close();
	    
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          stmt.close();
	    }catch(SQLException se2){
	    }// nothing we can do
	    
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	    
	 }//end try
	 System.out.println("Goodbye!");

}
	        
 }
    
     

    

