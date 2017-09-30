/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory;

//import com.mysql.jdbc.PreparedStatement;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import billing.*;
import EmployeeManagement.DBConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class SupplyHandler   {
    
    public float total= 0;
    public ResultSet resultSet;
    float subTotal = 0;
    float price = 0;
    int quantity_total = 0;
    
    
    public String SelectItem(int materialId, int quantity){
         
        Connection con = DBConnection.getConnection();
        try{
            
            String query = "SELECT `Material_Name` FROM `materials` WHERE Material_Id = ?";
            java.sql.PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Integer.toString(materialId));
            ResultSet rs=null;
            try{
                rs = ps.executeQuery();
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Please checks your inputs","Wrong", JOptionPane.ERROR_MESSAGE);
            }

                 
                String str = null;
                    
                if((rs!=null) && (rs.next())){        
                
        
        
                    try {
                        str = rs.getString(1);

                        

                    } catch (SQLException ex) {
                       Logger.getLogger(BillWindow.class.getName()).log(Level.SEVERE, null, ex);
         
                }
                return str;
            }
                
           // }
            
            
        }catch(SQLException | HeadlessException | NumberFormatException e){
            
        }

        return null;
    }

   

    
  
       ///////////////////////////////////////////////////////////////////////////////////
    
    
     public int getLastBillNo(){
        int billNo =0;
     
        Connection con = DBConnection.getConnection();
     
        try {
            
           // String query = "SELECT `Cust_Id`, `Cust_Name`, `Cust_Address`, `Cust_Number`, `Cust_email`, `Total_Amount_Purchased`, `Discount_Points` FROM `customers` WHERE Cust_Name = ?";
            String query = "SELECT MAX(invoice_no) FROM `material_supply`";
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            //preparedStmt.setString(1,name);
            
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
            
           //System.out.print(customer_rs.getString(1));
          
            if(rs.next()){
            billNo= rs.getInt(1);
           
          //  rs.first();
            }
            
 
        } catch (SQLException ex) {
            
        }
        
        return billNo;
    }

     /////////////////////////////////////////////////////////////////////////////////////
     
     
     
    
     
     //////////////////////////////////////////////////////////////////////
     
  
    
    
     //////////////////////////////////////////////////////////////////////////////////////////////
     
     public int get_Quantity(String material_id){
        int f = 0;
        Connection con = DBConnection.getConnection();
        try {
            
            String query = "SELECT `Total_Quantity` FROM `materials` WHERE Material_Id = ?";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,material_id);
            
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
         
             
     
            
            if(rs.next()){
                f= rs.getInt(1);
               return f;
            }
            else return f;
            
        } catch (SQLException ex) {
         
        }
        
     return f;
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     public Boolean update_Materials(String material_id, String quantity){
        
        int bill_quantity = 0;
        int current_quantity = 0;
        int reorderLevel=0;
        int safe=0;
        try {
            Connection con = DBConnection.getConnection(); 
            
            

            
            quantity_total = get_Quantity(material_id);
            reorderLevel=get_reorderLevel(material_id);
            bill_quantity  = Integer.parseInt(quantity);
            current_quantity = quantity_total - bill_quantity;
            safe=current_quantity-reorderLevel;
            if(current_quantity  >= 0){
                String query = "UPDATE `materials` SET `Total_Quantity`=? WHERE Material_Id = ?";

                // create the mysql insert preparedstatement
                java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);


                preparedStmt.setString(1,String.valueOf(current_quantity));
                preparedStmt.setString(2,material_id);
                preparedStmt.executeUpdate();
                preparedStmt.close();
                if (safe<0){
                        String query1 = "UPDATE `materials` SET `Inventory_level`=0 WHERE Material_Id = ?";
                        PreparedStatement preStmt = con.prepareStatement(query1);


                        preStmt.setString(1,material_id);
                        preStmt.executeUpdate();
                        preStmt.close();

                    }
                    if (current_quantity==0){
                        String query2 = "UPDATE `materials` SET `Inventory_level`=-1 WHERE Material_Id = ?";
                        PreparedStatement preStmt2 = con.prepareStatement(query2);


                        preStmt2.setString(1,material_id);
                        preStmt2.executeUpdate();
                        preStmt2.close();
                    }
                return true;    //if the material is available

                }
            else{

                return false;

            }

        } catch (SQLException ex) {

        }
        return true;
        
    }

     
     ///////////////////////////////////////////////////////////////////////////////////////////////////////
     
      


    private int get_reorderLevel(String material_id) {
         int f = 0;
        Connection con = DBConnection.getConnection(); 
        try {
            
            String query = "SELECT `Reorder_Level` FROM `materials` WHERE Material_Id = ?";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,material_id);
            
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
         
             
            
            if(rs.next()){
                f= rs.getInt(1);
               return f;
            }
            
            else return f;
            //return rs;
        } catch (SQLException ex) {
            
        }
        
     return f;
    }

    void insertIntoMaterial_Supply(String[] str1) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO `material_supply`( `invoice_no`, `material_no`, `quantity`) VALUES (?,?,?)";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setString(1,str1[0]);
            preparedStmt.setString(2,str1[1]);
            preparedStmt.setString(3,str1[3]);
            preparedStmt.executeUpdate();
            preparedStmt.close();
     
        } catch (SQLException ex) {
         
        }
    }
    
    protected int get_available() {
        return quantity_total;
    }
  
}
