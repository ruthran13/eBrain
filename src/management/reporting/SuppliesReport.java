

package management.reporting;


import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;


public class SuppliesReport {
Connection connection =null;
	public SuppliesReport() {
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

		

		
                TextColumnBuilder<Integer> itemIDColumn = col.column("Invoice No", "Invoice_No", type.integerType());
                TextColumnBuilder<String> OrderDate = col.column("Order Date", "Order_Date", type.stringType());
		TextColumnBuilder<Integer> amountColumn = col.column("Total Amount", "Total_Amount", type.integerType());
		

		try {
			report()
				.setTemplate(Templates.reportTemplate)
				.columns(itemIDColumn,OrderDate , amountColumn)
				.summary(cht.bar3DChart()
						.setTitle("Supplies chart")
						.setTitleFont(boldFont)
						.setCategory(OrderDate)
						.series(cht.serie(amountColumn)))						
				
				.setDataSource("SELECT  Invoice_No,Order_Date,Total_Amount FROM supplies",connection)
				.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		dataSource.add("Tablet", 350, new BigDecimal(300));
		dataSource.add("Laptop", 300, new BigDecimal(500));
		dataSource.add("Smartphone", 450, new BigDecimal(250));
		return dataSource;
	}

	public static void main(String[] args) {
		new SuppliesReport();
	}
}
