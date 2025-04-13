package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    // Data provider 1

    @DataProvider(name = "Provider1_LoginData")
    public String[][] getData() throws IOException {
        String path = ".//testData//Opencart_LoginData.xlsx";  // taking .xlxs file from testData

        ExcelUtility xlutil = new ExcelUtility(path);   // creating an object for ExcelUtility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String logindata[][]=new String[totalrows][totalcols];

        for (int i=1;i<=totalrows;i++){
            for (int j=0;j<totalcols;j++){
                logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return logindata; // returning two dimension array

    }



    // Data provider 2 (name of provider must be different)
    // Data provider 3
    // Data provider 4
}
