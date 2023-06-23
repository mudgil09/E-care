package ecare;

import java.awt.Container;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class dbcon {
    
    private static int inc = 0;
    String tockenids;

public String getId(){

    long id = Long.parseLong(String.valueOf(System.currentTimeMillis())
            .substring(1,10)
            .concat(String.valueOf(inc)));
    inc = (inc+1)%10;
    return Long.toString(id);
}
    boolean checkUser(String uid,String pass) throws SQLException, ClassNotFoundException{
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection s=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecare", "root", "Pandusai@2003");
        Statement smt=(Statement) s.createStatement();
        ResultSet r=smt.executeQuery("select * from usertable where uid='"+uid+"' and pass='"+pass+"'");
        r.next();
        if(r.getString(1).equals(uid) && r.getString(2).equals(pass)){
            return true;
        }
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Incorrect password retry!");
    	}
        return false;
    }
    ArrayList<String>  getTockens() {
    	ArrayList<String> sr=new ArrayList<String>();
    	try {
    		
    		int i=0;
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection s=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecare", "root", "Pandusai@2003");
            Statement smt=(Statement) s.createStatement();
            ResultSet r=smt.executeQuery("select * from complainttable");
            while(r.next()) {
            	 sr.add(r.getString(1));
            }
           
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, "Incorrect password retry!");
        	}
    	return sr;
    	
    }
    void entertockenid(String userid) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	 Connection s=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecare", "root", "Pandusai@2003");
         Statement smt=(Statement) s.createStatement();   
         smt.execute("update usertable set tokenid = "+"'"+tockenids+"' where uid = "+"'"+userid+"'");
         }
    int checkAdmin(String uid, String pass) throws SQLException, ClassNotFoundException{
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection s=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecare", "root", "Pandusai@2003");
        Statement smt=(Statement) s.createStatement();
        ResultSet r=smt.executeQuery("select * from admintable where uid='"+uid+"' and pass='"+pass+"'");
        r.next();
        if(r.getString(1).equals(uid) && r.getString(2).equals(pass)){
            return 1;
        }
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Incorrect password retry!");
    	}
        return 0;
    }
    int EnternewRegistration(String uid,String pass,String email,String phone,String location){
        int flag=0;
        try
        {     Class.forName("com.mysql.cj.jdbc.Driver");
            Connection s=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecare", "root", "Pandusai@2003");
            Statement smt=(Statement) s.createStatement();
            flag=smt.executeUpdate("insert into usertable values('"+uid+"','"+pass+"','"+email+"','"+phone+"','"+location+"','"+"null"+"')");
            flag=1;
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "Incorrect password retry!");
        }
        return flag;
    }
    int EnterCompliant(String tockenid,String devicetype,String discribe,String issue,String sysspec){
        int flag=0; 
         try{Class.forName("com.mysql.cj.jdbc.Driver");
        	 tockenids=tockenid;
            Connection s=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecare", "root", "Pandusai@2003");
            Statement smt=(Statement) s.createStatement();
            flag=smt.executeUpdate("insert into complainttable values('"+tockenid+"','"+devicetype+"','"+discribe+"','"+issue+"','"+sysspec+"')");
            flag=1;
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "Incorrect password retry!");
        }
        return flag;
    }
    int EnterSolution(String tockenid,String sugges,String advice,String prevention){
        int flag=0; 
         try{Class.forName("com.mysql.cj.jdbc.Driver");
            Connection s=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecare", "root", "Pandusai@2003");
            Statement smt=(Statement) s.createStatement();
            flag=smt.executeUpdate("insert into solutiontable values('"+tockenid+"','"+sugges+"','"+advice+"','"+prevention+"')");
            flag=1;
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "Incorrect password retry!");
        }
        return flag;
    } 
    complaint accknowledgement(String tockenid){
        complaint c=null;
        try{Class.forName("com.mysql.cj.jdbc.Driver");
            Connection s=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecare", "root", "Pandusai@2003");
            Statement smt=(Statement) s.createStatement();
            ResultSet r=smt.executeQuery("select * from complainttable where tockenid='"+tockenid+"'");
            r.next();
            c=new complaint(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5));
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "Incorrect password retry!");
        }
        return c;
    }

}
