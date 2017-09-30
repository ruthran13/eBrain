/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AttendanceEntry {
    private Connection con = null;
    private PreparedStatement pst = null;
    
    public AttendanceEntry(){
         con = DBConnection.getConnection();
    }    
    public boolean addArrivalAuto(int emID){
        try{
                
                String query = "INSERT INTO `employee_attendance` (`Emp_Id`, `att_date`,`year`, `month`, `date`, `Arrival_Time`, `Departure_Time`,`working_Time`) VALUES (?,?,?, ?, ?,?,?,?)";
                
                pst = con.prepareStatement(query);
                pst.setInt(1, emID);
                pst.setString(2,new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) );
                pst.setString(3,new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()) );
                pst.setString(4,new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()) );
                pst.setString(5,new SimpleDateFormat("dd").format(Calendar.getInstance().getTime()) );
                pst.setString(6,new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime())  );
                pst.setString(7,"");
                pst.setFloat(8, (float) 0.0);
                pst.executeUpdate();
                pst.close();
                return true;
            }catch(HeadlessException | SQLException e){
                e.printStackTrace(System.err);
                return false;
            }
    }
        
        public boolean addDepatureAuto(int emID){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm" );
            
            String q2="SELECT `Arrival_Time`, `Departure_Time` FROM `employee_attendance` WHERE (`Emp_Id`=? and  `att_date`=?)";
            PreparedStatement ps2 = con.prepareStatement(q2);
            ps2.setInt(1, emID);
            ps2.setString(2,new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) );
            ResultSet rs2 = ps2.executeQuery();
            Date arr_time = null;
            if( (rs2.next())){
                String ar= rs2.getString(1);
                arr_time = sdf.parse(ar);
            }
            ps2.close();
            String da = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
            Date dep_date = sdf.parse(da); 
            
            float difference= (dep_date.getTime() - arr_time.getTime())/(60*1000);
                
            String query = "UPDATE `employee_attendance` SET `Departure_Time`=?,`working_Time`=? WHERE (`Emp_Id`=? and `att_date`=?)";

            
            pst = con.prepareStatement(query);
            pst.setInt(3, emID);
            pst.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) );
            pst.setString(1,  da);
            pst.setFloat(2, difference);

            pst.executeUpdate();
            pst.close();
            return true;

        }catch(HeadlessException | SQLException e){
            e.printStackTrace(System.err);
            return false;

        } catch (ParseException ex) {
            Logger.getLogger(AttendanceEntry.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    
    
}
