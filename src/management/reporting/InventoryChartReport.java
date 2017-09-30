

package management.reporting;


import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class InventoryChartReport {
Connection connection =null;
	public InventoryChartReport() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/eBrain","root","");
	} catch (SQLException e) {
		e.printStackTrace();
		return;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
        }	
            
            build();
	}

	private void build() {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		TextColumnBuilder<String> itemColumn = col.column("Order Type", "Order_Type_code", type.stringType());
                TextColumnBuilder<Integer> itemIDColumn = col.column("Product ID", "Product_Id", type.integerType());
                TextColumnBuilder<String> productType = col.column("Order Date", "Order_Date", type.stringType());
		TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "Quantity", type.integerType());
		TextColumnBuilder<Integer> unitPriceColumn = col.column("Inventory Level", "Inventory_Level", type.integerType());

		try {
			report()
				.setTemplate(Templates.reportTemplate)
                                
				.columns(itemIDColumn,itemColumn,productType, quantityColumn, unitPriceColumn)
				.pageFooter(Templates.footerComponent)
				.setDataSource("SELECT  Product_Id,Order_Type,Order_Date,Quantity,Inventory_Level FROM inventory",connection)
				.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	

	public static void main(String[] args) {
		new InventoryChartReport();
	}
}
