import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		
		int xSize = (driver.findElements(By.xpath(table_xPath)).size());
		int ySize = (driver.findElements(By.xpath(Table.getRow_xPath(table_xPath, 1))).size());

		ArrayList<String>[][] totalTable = new ArrayList[xSize][ySize];
		for (int x=0; x<=xSize; x++) {
			List<String> tempRow = Table.getText(driver.findElements(By.xpath(Table.getRow_xPath(table_xPath, x+1))));
			//tempRow.get(1);
			System.out.println("tempRow: "+tempRow);
			for (int y=0; y<=ySize; y++) {
				totalTable[x][y].add(tempRow.get(y));
				System.out.println("totalTable: "+totalTable);
			}
		}
	}
}