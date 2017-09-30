package inventory;


import management.inventory.ProductRecord;
import management.inventory.MaterialRecord;
import EmployeeManagement.DBConnection;
import java.awt.HeadlessException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class GetSupplies extends javax.swing.JFrame {
    private Connection con=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    private Statement st=null;
    private int total;
        /**
     * Creates new form PatientRegistration
     */
    public GetSupplies() {
        initComponents();
        setLocationRelativeTo(null);
        total=0;
    }
private void Reset()
{
    txtProductID.setText("");
    txtInvoiceNo.setText("");
    jLabel4.setText("");
    txtQuantity.setText("");
   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JTextField();
        txtInvoiceNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSupply = new javax.swing.JButton();
        btnGetData1 = new javax.swing.JButton();
        btnGetData2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProductID1 = new javax.swing.JTextField();
        txtInvoiceNo1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQuantity1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnNew1 = new javax.swing.JButton();
        btnSupply1 = new javax.swing.JButton();
        btnGetData5 = new javax.swing.JButton();
        btnGetData6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Get Supply");
        setMinimumSize(new java.awt.Dimension(737, 327));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Details"));

        jLabel1.setText("Product ID");

        jLabel2.setText("Invoice No");

        txtProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIDActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantity");

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSupply.setText("Get Supply");
        btnSupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplyActionPerformed(evt);
            }
        });

        btnGetData1.setText("View Supplies");
        btnGetData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetData1ActionPerformed(evt);
            }
        });

        btnGetData2.setText("View Products Details");
        btnGetData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetData2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGetData1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGetData2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSupply)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGetData1)
                .addGap(18, 18, 18)
                .addComponent(btnGetData2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(" Amount   :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductID, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(txtQuantity)
                            .addComponent(txtInvoiceNo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Products", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Materials Details"));

        jLabel5.setText("Material ID");

        jLabel7.setText("Invoice No");

        txtProductID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductID1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Quantity");

        txtQuantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantity1ActionPerformed(evt);
            }
        });
        txtQuantity1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantity1KeyTyped(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNew1.setText("New");
        btnNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew1ActionPerformed(evt);
            }
        });

        btnSupply1.setText("Get Supply");
        btnSupply1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupply1ActionPerformed(evt);
            }
        });

        btnGetData5.setText("View Supplies");
        btnGetData5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetData5ActionPerformed(evt);
            }
        });

        btnGetData6.setText("View Material Details");
        btnGetData6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetData6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGetData5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGetData6, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(btnNew1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupply1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew1)
                .addGap(11, 11, 11)
                .addComponent(btnSupply1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGetData5)
                .addGap(18, 18, 18)
                .addComponent(btnGetData6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText(" Amount   :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductID1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(txtQuantity1)
                            .addComponent(txtInvoiceNo1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtInvoiceNo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtProductID1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Raw Materials", jPanel3);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
    Reset();
    
    }//GEN-LAST:event_btnNewActionPerformed

    
    
    private void btnSupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplyActionPerformed
       
    try {
        con = DBConnection.getConnection();
        
        if (txtProductID.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter product id","Error", JOptionPane.ERROR_MESSAGE);
                Reset();
                return;

            }
        if (txtInvoiceNo.getText().equals("")) {
            JOptionPane.showMessageDialog( this, "Please enter invoice no","Error", JOptionPane.ERROR_MESSAGE);
            Reset();
            return;

        }

        if (txtQuantity.getText().equals("")) {
            JOptionPane.showMessageDialog( this, "Please enter amount of quantity","Error", JOptionPane.ERROR_MESSAGE);
            Reset();
            return;
        }
        
        int quantity,proID,inNo;
        try{
            quantity=  parseInt(txtQuantity.getText());
            proID=parseInt(txtProductID.getText());
            inNo=parseInt(txtInvoiceNo.getText());
        }
        catch(NumberFormatException e1){
             JOptionPane.showMessageDialog(this,"Wrong Inputs","Wrong",JOptionPane.WARNING_MESSAGE);
             Reset();
            return;
        }
        
        int a = 0;
        int t=0;
        int re=0;
        int to=0;
        try{
            
            String sq4= "Select Price,Product_Type,Reorder_Level, Total_Quantity from products where Product_Id= '" + txtProductID.getText() + "'";
            pst=con.prepareStatement(sq4);
            
            rs= pst.executeQuery();
            while (rs.next()) {
                a = rs.getInt("Price");
                t=rs.getInt("Product_Type");
                re=rs.getInt("Reorder_Level");
                to=rs.getInt("Total_Quantity");
            }
            
           
        }catch(HeadlessException | SQLException ex){
            Reset();
            JOptionPane.showMessageDialog(this,ex);
        } 

        if (t==1){ 
            total =(a*quantity);

            jLabel4.setText(String.valueOf(total));



            

            String sq1 = "UPDATE `products` SET `Total_Quantity`=`Total_Quantity`+"+ quantity +" where Product_Id= "+ txtProductID.getText();
            st=con.createStatement();
            st.executeUpdate(sq1);



           String query1 = "INSERT INTO `supplies`(`Invoice_No`, `Product_Id`, `Order_Quantity`, `Total_Amount`)" + "VALUES (?,?,?,?)";

            try {
                PreparedStatement preparedStmt1 = con.prepareStatement(query1);
                preparedStmt1.setString(1,txtInvoiceNo.getText());
                
                preparedStmt1.setString(2,txtProductID.getText());
                preparedStmt1.setString(3,txtQuantity.getText());
                preparedStmt1.setString(4,String.valueOf(total));
                
                preparedStmt1.executeUpdate();
                preparedStmt1.close();

            }
            catch(HeadlessException | SQLException ex){
                Reset();
                JOptionPane.showMessageDialog(this,"ERROR","ERROR",JOptionPane.WARNING_MESSAGE);
            } 



            //updat ethe inventory level 
            
            if (re<=(to+quantity)){
                String query2 = "UPDATE `products` SET `Inventory_level`=1 WHERE Product_Id = ?";
                PreparedStatement preStmt = con.prepareStatement(query2);


                preStmt.setString(1,txtProductID.getText());
                preStmt.executeUpdate();
                preStmt.close();
            }



             JOptionPane.showMessageDialog(this,"Successfully Added","Supplies",JOptionPane.INFORMATION_MESSAGE); 
        }
        else{
            Reset();
            JOptionPane.showMessageDialog(this,"Wrong Product","Wrong",JOptionPane.WARNING_MESSAGE);
        }
      }catch(HeadlessException | SQLException ex){
          Reset();
            JOptionPane.showMessageDialog(this,"ERROR","ERROR",JOptionPane.WARNING_MESSAGE);
        }   

    }//GEN-LAST:event_btnSupplyActionPerformed

    private void txtProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductIDActionPerformed

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnGetData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetData1ActionPerformed
        this.dispose();
        SuppliesRecord frm=new SuppliesRecord(this);
        frm.setVisible(true);
    }//GEN-LAST:event_btnGetData1ActionPerformed

    private void btnGetData2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetData2ActionPerformed
      //this.enable(false);
        ProductRecord frm=new ProductRecord();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGetData2ActionPerformed

    private void txtProductID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductID1ActionPerformed

    private void txtQuantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantity1ActionPerformed

    private void txtQuantity1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantity1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantity1KeyTyped

    private void btnNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew1ActionPerformed
        Reset1();
        
        
    }//GEN-LAST:event_btnNew1ActionPerformed

    private void btnSupply1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupply1ActionPerformed
        try {
        con = DBConnection.getConnection();
        
        if (txtProductID1.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter product id","Error", JOptionPane.ERROR_MESSAGE);
                Reset1();
                return;

            }
        if (txtInvoiceNo1.getText().equals("")) {
            JOptionPane.showMessageDialog( this, "Please enter invoice no","Error", JOptionPane.ERROR_MESSAGE);
            Reset1();
            return;

        }

        if (txtQuantity1.getText().equals("")) {
            JOptionPane.showMessageDialog( this, "Please enter amount of quantity","Error", JOptionPane.ERROR_MESSAGE);
            Reset1();
            return;
        }
        
        int quantity,proID,inNo;
        try{
            quantity=  parseInt(txtQuantity1.getText());
            proID=parseInt(txtProductID1.getText());
            inNo=parseInt(txtInvoiceNo1.getText());
        }
        catch(NumberFormatException e1){
             JOptionPane.showMessageDialog(this,"Wrong Inputs","Wrong",JOptionPane.WARNING_MESSAGE);
             Reset1();
            return;
        }
        int a = 0;
        int re=0;
        int to=0;
        try{
            
            String sq4= "Select Price,Reorder_Level, Total_Quantity from materials where material_Id= '" + txtProductID1.getText() + "'";
            pst=con.prepareStatement(sq4);
            rs= pst.executeQuery();
            while (rs.next()) {
                a = rs.getInt("Price");
                re=rs.getInt("Reorder_Level");
                to=rs.getInt("Total_Quantity");
            }
            
           
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        } 

            total =(a*quantity);

            jLabel10.setText(String.valueOf(total));



            

            String sq1 = "UPDATE `materials` SET `Total_Quantity`=`Total_Quantity`+"+ quantity +" where Material_Id= "+ txtProductID1.getText();
            st=con.createStatement();
            st.executeUpdate(sq1);



           String query1 = "INSERT INTO `supplies`(`Invoice_No`, `Product_Id`, `Order_Quantity`, `Total_Amount`)" + "VALUES (?,?,?,?)";

            try {
                PreparedStatement preparedStmt1 = con.prepareStatement(query1);
                preparedStmt1.setString(1,txtInvoiceNo1.getText());
                
                preparedStmt1.setString(2,txtProductID1.getText());
                preparedStmt1.setString(3,txtQuantity1.getText());
                preparedStmt1.setString(4,String.valueOf(total));
                
                preparedStmt1.executeUpdate();
                preparedStmt1.close();

            }
            catch(HeadlessException | SQLException ex){
                Reset1();
                JOptionPane.showMessageDialog(this,"ERROR","ERROR",JOptionPane.WARNING_MESSAGE);
            } 



            //updat ethe inventory level 
            
            if (re<=(to+quantity)){
                String query2 = "UPDATE `materials` SET `Inventory_level`=1 WHERE material_Id = ?";
                PreparedStatement preStmt = con.prepareStatement(query2);


                preStmt.setString(1,txtProductID1.getText());
                preStmt.executeUpdate();
                preStmt.close();
            }



             JOptionPane.showMessageDialog(this,"Successfully Added","Supplies",JOptionPane.INFORMATION_MESSAGE); 

      }catch(HeadlessException | SQLException ex){
            Reset1();
            JOptionPane.showMessageDialog(this,"ERROR","ERROR",JOptionPane.WARNING_MESSAGE);
        } 
        
        txtProductID1.setText("");
        txtInvoiceNo1.setText("");

        txtQuantity1.setText("");
        jLabel10.setText("");
                
                
    }//GEN-LAST:event_btnSupply1ActionPerformed

    private void btnGetData5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetData5ActionPerformed
        this.setVisible(false);
        SuppliesRecord frm=new SuppliesRecord(this);
        frm.setVisible(true);
    }//GEN-LAST:event_btnGetData5ActionPerformed

    private void btnGetData6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetData6ActionPerformed
        MaterialRecord frm=new MaterialRecord();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGetData6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetData1;
    private javax.swing.JButton btnGetData2;
    private javax.swing.JButton btnGetData5;
    private javax.swing.JButton btnGetData6;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNew1;
    private javax.swing.JButton btnSupply;
    private javax.swing.JButton btnSupply1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    protected javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTextField txtInvoiceNo;
    public javax.swing.JTextField txtInvoiceNo1;
    public javax.swing.JTextField txtProductID;
    public javax.swing.JTextField txtProductID1;
    public javax.swing.JTextField txtQuantity;
    public javax.swing.JTextField txtQuantity1;
    // End of variables declaration//GEN-END:variables

    private void Reset1() {
        txtProductID1.setText("");
        txtInvoiceNo1.setText("");
        txtQuantity1.setText("");
        jLabel10.setText("");
    }

   
}
