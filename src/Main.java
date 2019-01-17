import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) {
		// User defined variables
//		Scanner yr = new Scanner(System.in);
//		System.out.print("Enter Year you want to look up: ");
//		int year = yr.nextInt();
		
		int year = 2019;
		String url = ("https://www.treasury.gov/resource-center/data-chart-center/interest-rates/Pages/TextView.aspx?data=yieldYear&year="+year);
		
		// Create Driver object
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Eclipse\\selenium-java\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		
		String table_xPath = ("//table/tbody/tr/td/div/table/tbody/tr");
		
		ArrayList<ArrayList<String>> totalTable = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerTable = Table.getText(driver.findElements(By.xpath(Table.getHeader_xPath(table_xPath))));
		ArrayList<String> rowTable = new ArrayList<String>();

		totalTable.add(headerTable);
		
		int entries = (driver.findElements(By.xpath(table_xPath)).size());
		for (int x=1; x<entries; x++) {
			rowTable = Table.getText(driver.findElements(By.xpath(Table.getRow_xPath(table_xPath, x+1))));
			totalTable.add(rowTable);
		}
		System.out.println("totalTable_H: "+totalTable.get(0));
		System.out.println("totalTable_1: "+totalTable.get(1));
		System.out.println("totalTable_2: "+totalTable.get(2));
		driver.close();
	}
}