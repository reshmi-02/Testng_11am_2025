package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void browserSetup() throws IOException {
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
		
		FileReader fr = new FileReader(f);
		
		Properties prop = new Properties();
		
		prop.load(fr);
		
		String browsername = prop.getProperty("browser");
		String url = prop.getProperty("testurl");
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get(url);
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get(url);
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(url);
		}
		else {
			System.out.println("Enter a valid browsername");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@DataProvider
	public String[][] excelReader() throws IOException {
		
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Tesstng_11am_july29_2025\\ExcelFiles\\excel.xlsx");
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fi);
		
		Sheet sheet = wb.getSheet("login");
		
		int rowcount = sheet.getPhysicalNumberOfRows();
		
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		
		String data [][] = new String [rowcount-1][cellcount];  //3 2 
		
		//[ [1,2],[1,2],[1,2]  ]
		
		
		for(int i=1 ; i<rowcount;i++) {  //2<4 
			
			
			for(int j=0 ; j<cellcount;j++) {  //j=0   0<2  
				
				Cell cell = sheet.getRow(i).getCell(j);  //2 0 
				
				DataFormatter format = new DataFormatter();
				
				String value = format.formatCellValue(cell);
				
				data[i-1][j]=value;  //data[1][0] = value
				
			}
			
		
			
		}
		
		
		return data;
		
	}
	

}
