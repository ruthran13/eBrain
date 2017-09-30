package management.reporting;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.exception.DRException;


public class ProductChartReport {
    
        
Connection connection =null;
	public ProductChartReport() {
		
                
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
               //Get_Data();
 
	}

	private void build() {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		TextColumnBuilder<String> itemColumn = col.column("Product", "Product_Name", type.stringType());
                TextColumnBuilder<Integer> itemIDColumn = col.column("Product ID", "Product_Id", type.integerType());
                TextColumnBuilder<String> productType = col.column("Product Type", "Product_Type", type.stringType());
		TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "Total_Quantity", type.integerType());
		TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "price", type.bigDecimalType());

		try {
			report()
				.setTemplate(Templates.reportTemplate)
				.columns(itemColumn,itemIDColumn, productType, quantityColumn,unitPriceColumn)
				.summary(
					cht.pie3DChart()
						.setTitle("Products Pie Chart")
						.setTitleFont(boldFont)
						.setKey(itemColumn)
						.series(
							cht.serie(quantityColumn)))
				.pageFooter(Templates.footerComponent)
                                .setDataSource("SELECT  Product_Name,Product_Id,Product_Type, Total_Quantity,price FROM products",connection)
				.show();
                        
		} catch (DRException e) {
			e.printStackTrace();
		}
	}
        
       	public static void main(String[] args) {
		new ProductChartReport();
	}
}
