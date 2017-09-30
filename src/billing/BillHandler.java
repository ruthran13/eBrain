/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package billing;

//import com.mysql.jdbc.PreparedStatement;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
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
public class BillHandler{
    
    private float total= 0;
    private ResultSet resultSet;
    private float subTotal = 0;
    private float price = 0;
    private int quantity_total = 0;
    private int current_quantity=0;
    
    
    
    protected String[] SelectItem(int productId, int quantity){
         
        Connection con = DBConnection.getConnection();
        try{
            
            String query = "SELECT `Product_Id`, `Product_Name`, `Price`,`Reorder_Level` FROM `products` WHERE Product_Id = ?";
            java.sql.PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Integer.toString(productId));
            ResultSet rs=null;
            try{
                rs = ps.executeQuery();
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Please checks your inputs","Wrong", JOptionPane.ERROR_MESSAGE);
            }

                 
                String[] str = new String[5];
                    
                if((rs!=null) && (rs.next())){        
                
        
        
                try {
                    price = Float.parseFloat(rs.getString(3));
                    subTotal = price*quantity;
                    total +=subTotal;
                    str[0] = rs.getString(1);
             
                    str[1] = rs.getString(2);
                    str[2] = rs.getString(3);
                    str[3] = String.valueOf(quantity);
                    str[4] = String.valueOf(subTotal);
                     
                    return str;
                } catch (SQLException ex) {
                   Logger.getLogger(BillWindow.class.getName()).log(Level.SEVERE, null, ex);
         
                }
                String[] st = new String[1];
                return st;
            }
                
           // }
            
            
        }catch(SQLException | HeadlessException | NumberFormatException e){
            
        }

        return null;
    }

   

    
    
  
       ///////////////////////////////////////////////////////////////////////////////////
    
    
     protected int getLastBillNo(){
        int billNo =0;
     
        Connection con = DBConnection.getConnection();
     
        try {
            
            String query = "SELECT MAX(Bill_No) FROM `sales`";
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            //preparedStmt.setString(1,name);
            
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
            
          
            if(rs.next()){
            billNo= rs.getInt(1);
           
          //  rs.first();
            }
            
 
        } catch (SQLException ex) {
            
        }
        
        return billNo;
    }

     /////////////////////////////////////////////////////////////////////////////////////
     
     
     
     protected void insertIntoSales_Items(String str[]){

        try {   
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO `sales_items`(`Bill_No`, `Product_Id`, `Price`, `Order_Quantity`, `Total_Amount`,`salesman`)"+" VALUES (?,?,?,?,?,?)";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, str[0]);
            preparedStmt.setString(2, str[1]);
            preparedStmt.setString(3, str[2]);
            preparedStmt.setString(4, str[3]);
            preparedStmt.setString(5, str[4]);
            preparedStmt.setString(6, str[5]);
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            ////////////////////////////////////////////////
            
            
            ///////////////////////////////////////////////
        } catch (SQLException ex) {
            Logger.getLogger(BillHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }
     
     
     //////////////////////////////////////////////////////////////////////
     
     protected void update_Sales(int billNo, String total,String emId){
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO `sales`(`Bill_No`, `Total_Amount`,`salesman`) VALUES (?,?,?)";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            
            
            preparedStmt.setString(1,String.valueOf(billNo));
            preparedStmt.setString(2,total);
            preparedStmt.setString(3,emId);
            preparedStmt.executeUpdate();
            preparedStmt.close();
            ////////////////////////////////////////////////
            
         //  this.getData_Cust_name(str[0]);
            
            ///////////////////////////////////////////////
            
        
            
        } catch (SQLException ex) {
            Logger.getLogger(BillHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    
    
     //////////////////////////////////////////////////////////////////////////////////////////////
     
     private int get_Quantity(String product_id){
        int f = 0;
        Connection con = DBConnection.getConnection();
        try {
            
            String query = "SELECT `Total_Quantity` FROM `products` WHERE Product_Id = ?";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,product_id);
            
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
         
             
     
            
            if(rs.next()){
                f= rs.getInt(1);
               return f;
            }
            else return f;
            
        } catch (SQLException ex) {
            Logger.getLogger(BillHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return f;
    }

     
     
    protected void update_Products(String product_id, String quantity){
        int bill_quantity = 0;
        int reorderLevel=0;
        int totalSold=0;
        int safe=0;
        int isProduct;
        try {
            Connection con = DBConnection.getConnection(); 
            isProduct=get_ProductType(product_id);
            
            bill_quantity  = Integer.parseInt(quantity);
            totalSold = get_Total(product_id)+bill_quantity;
            
            
            String query = "UPDATE `products` SET  `Total_Sold`=? WHERE Product_Id = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);



            preparedStmt.setInt(1,totalSold);
            preparedStmt.setString(2,product_id);
            preparedStmt.executeUpdate();
            preparedStmt.close();
            if (isProduct!=0){      //check if it a product is or a sale item
                quantity_total = get_Quantity(product_id);
                
                reorderLevel=get_reorderLevel(product_id);
                
                current_quantity = quantity_total - bill_quantity;
                safe=current_quantity-reorderLevel;
                
                String query11 = "UPDATE `products` SET `Total_Quantity`=? WHERE Product_Id = ?";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt1 = con.prepareStatement(query11);


                preparedStmt1.setString(1,String.valueOf(current_quantity));
                preparedStmt1.setString(2,product_id);
                preparedStmt1.executeUpdate();
                preparedStmt1.close();
                
                
                if (safe<0){
                    String query1 = "UPDATE `products` SET `Inventory_level`=0 WHERE Product_Id = ?";
                    PreparedStatement preStmt = con.prepareStatement(query1);


                    preStmt.setString(1,product_id);
                    preStmt.executeUpdate();
                    preStmt.close();

                }
                if (current_quantity==0){
                    String query2 = "UPDATE `products` SET `Inventory_level`=-1 WHERE Product_Id = ?";
                    PreparedStatement preStmt2 = con.prepareStatement(query2);


                    preStmt2.setString(1,product_id);
                    preStmt2.executeUpdate();
                    preStmt2.close();
                    }
         
                }
            } catch (SQLException ex) {
                Logger.getLogger(BillHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     protected Boolean checks_Products(String product_id, String quantity){
        
        int bill_quantity = 0;
        int isProduct;
        
            isProduct=get_ProductType(product_id);
            bill_quantity  = Integer.parseInt(quantity);
            
            
            
            
            if (isProduct!=0){      //check if it a product is or a sale item
                quantity_total = get_Quantity(product_id);
                
                
                current_quantity = quantity_total - bill_quantity;
                if(current_quantity  >= 0){
                    return true;    //if the product is available
                }
                else{ 
                    return false;
                }
            }
            return true;
        
    }

     
     ///////////////////////////////////////////////////////////////////////////////////////////////////////
     
      

    private int get_ProductType(String product_id) {
        int f = 0;
       Connection con = DBConnection.getConnection(); 
        try {
            
            String query = "SELECT `Product_Type` FROM `products` WHERE Product_Id = ?";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,product_id);
            
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
         
             
         
            
            if(rs.next()){
                f= rs.getInt(1);
               return f;
            }
            else return f;
            //return rs;
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog( null, "Wrong product selected","Error", JOptionPane.ERROR_MESSAGE);
        }
      
     return f;
    }

    private int get_reorderLevel(String product_id) {
         int f = 0;
        Connection con = DBConnection.getConnection(); 
        try {
            
            String query = "SELECT `Reorder_Level` FROM `products` WHERE Product_Id = ?";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,product_id);
            
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
         
             
            
            if(rs.next()){
                f= rs.getInt(1);
               return f;
            }
            
            else return f;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(BillHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return f;
    }

    protected int get_available() {
        return quantity_total;
    }

    private int get_Total(String product_id) {
        int f = 0;
        Connection con = DBConnection.getConnection();
        try {
            
            String query = "SELECT `Total_Sold` FROM `products` WHERE Product_Id = ?";
            
            // create the mysql insert preparedstatement
            java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,product_id);
            
            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
         
             
     
            
            if(rs.next()){
                f= rs.getInt(1);
               return f;
            }
            else return f;
            
        } catch (SQLException ex) {
            Logger.getLogger(BillHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return f;
    }


    protected float getBillTotal() {
        return total;
    }

    protected void setnewTotal(int newTotal) {
        this.total=newTotal;
    }
  
}
