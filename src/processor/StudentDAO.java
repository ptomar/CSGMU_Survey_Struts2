/*It is a java class and has to methods saveForm and retriveForm that store data to the database and retirive data from
 *  the database respectively
 */
package processor;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.StudentBean;

@WebServlet(name = "StudentDAO", urlPatterns = {"/StudentDAO"})

public class StudentDAO {
	public void datasave(String id,String name,String address,String zip,
			String city,String state,String cellphone,String email,String url,String date,String camp,
			String university,String comments,String month,String year,String recommend,String data) throws ServletException,
    IOException {
	        StudentBean studentObject = new StudentBean();
	        	       
	        studentObject.setId(id);
	        studentObject.setName(name);
	        studentObject.setAddress(address);
	        studentObject.setCity(city);
	        studentObject.setState(state);
	        studentObject.setZip(zip);
	        studentObject.setCellphone(cellphone);
	        studentObject.setEmail(email);
	        studentObject.setURL(url);
	        studentObject.setDate(date);
	        studentObject.setCamp(camp);
	        studentObject.setComments(comments);
	        studentObject.setUniversity(university);
	        studentObject.setMonth(month);
	        studentObject.setYear(year);
	        studentObject.setRecommend(recommend);
	        
	             	            
	        try
		       {
		    	   Class.forName("oracle.jdbc.driver.OracleDriver");
	    } catch (ClassNotFoundException ex) {
	        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
		    	        	        
	        try {
	        	 
	        	 Connection dbconnection;
	        	 dbconnection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "ptomar", "oagrah");
	             
	            String query = "insert into survey_details values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	           
	            PreparedStatement prepared = dbconnection.prepareStatement(query);
	           
	            prepared.setString(1, studentObject.getId());
	            prepared.setString(2, studentObject.getName());
	            prepared.setString(3, studentObject.getAddress());
	            prepared.setString(4, studentObject.getCity());
	            prepared.setString(5, studentObject.getState());
	            prepared.setString(6, studentObject.getZip());
	            prepared.setString(7, studentObject.getCellphone());
	            prepared.setString(8, studentObject.getEmail());
	            prepared.setString(9, studentObject.getURL());
	            prepared.setString(10, studentObject.getDate());
	            prepared.setString(11, studentObject.getCamp());
	            prepared.setString(12, studentObject.getUniversity());
	            prepared.setString(13, studentObject.getComments());
	            prepared.setString(14, studentObject.getMonth());
	            prepared.setString(15, studentObject.getYear());
	            prepared.setString(16, studentObject.getRecommend());
	            
	            prepared.executeUpdate();
	            prepared.close();
	            if (dbconnection != null) {
	            	dbconnection.close();
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
       
	}
	
	//Function to retrieve stduent details 
	    public StudentBean retrieveForm(String id) {
	        StudentBean studentObject = new StudentBean();
	 
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            Connection dbconnection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "ptomar", "oagrah");
	            Statement query = dbconnection.createStatement();
	            id="'"+id+"'";
	            ResultSet result = query.executeQuery("Select * from survey_details where id =" + id);
	            
	            while (result.next()) {
	            	
	            	studentObject.setId(result.getString(1));
	            	studentObject.setName(result.getString(2));
	            	studentObject.setAddress(result.getString(3));
	            	studentObject.setCity(result.getString(4));
	            	studentObject.setState(result.getString(5));
	            	studentObject.setZip(result.getString(6));
	            	studentObject.setCellphone(result.getString(7));
	            	studentObject.setEmail(result.getString(8));
	            	studentObject.setURL(result.getString(9));
	            	studentObject.setDate(result.getString(10));
	            	studentObject.setCamp(result.getString(11));
	            	studentObject.setUniversity(result.getString(12));
	            	studentObject.setComments(result.getString(13));
	            	studentObject.setMonth(result.getString(14));
	            	studentObject.setYear(result.getString(15));	                
	            	studentObject.setRecommend(result.getString(16));
	             
	            }
	            
	            dbconnection.close();
	           
	        } catch (Exception e) {
	        }
	        
       return studentObject; 
	    }

	 
		public String idsRetreiveFromDb(){
			String id_list="";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection dbconnection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "ptomar", "oagrah");
	            Statement query = dbconnection.createStatement();
	            ResultSet result = query.executeQuery("Select id from survey_details");
	            while (result.next()) {
	            	id_list=id_list+result.getString(1)+",";
	            }
	            dbconnection.close();
				
			}
			catch (Exception e) { }
			return id_list;
		}

}
