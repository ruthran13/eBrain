package EmployeeManagement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
  private static Connection conn = null;

  /** A private Constructor prevents any other class from instantiating. */
  private DBConnection() {
  }

  /** Static 'instance' method
     * @return  the connection to samples database*/
  public synchronized static Connection getConnection () {
    if(conn==null){
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/eBrain", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    return conn;
  }

}
