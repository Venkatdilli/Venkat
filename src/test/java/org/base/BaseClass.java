package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/**
	 * @author DilliBabu
	 * @see Reusable Method
	 * 
	 */

	public static WebDriver driver;
	JavascriptExecutor js;
	FileInputStream stream;
	// WorkBook book = null;
	private int locator;
	private String file;

	/**
	 * @see to get a WebBrowser
	 * @param name
	 */

	public  void getdriver(String name) {

		switch (name) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("Invalid BrowserName");
			break;
		}

		driver.manage().window().maximize();

	}

	/**
	 * @see To Initilize the URL
	 * @param url
	 */
	public void launchUrl(String url) {
		driver.get(url);
	}

	/**
	 * @see To get a Text from WebBrowser
	 * @param element
	 * @return text
	 */
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @see To get a Attribute Value from WebDriver
	 * @param element
	 * @return attribute
	 */
	public String getAttributes(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	/**
	 * @see To find a Locator
	 * @param name
	 * @param value
	 * @return else
	 */
	public WebElement findByLocator(String name, String value) {

		WebElement ele = null;
		switch (name) {
		case "id":
			WebElement findElement = driver.findElement(By.id(value));

			break;
		case "name":
			WebElement findElement2 = driver.findElement(By.name(value));
			break;

		case "classname":
			WebElement findElement3 = driver.findElement(By.className(value));
		default:
			break;
		case "xpath":
			WebElement findElement4 = driver.findElement(By.xpath(value));
			break;
		}
		return ele;
	}

	/**
	 * @see Waits untill to find a locator
	 */
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	/**
	 * @see To take a Screenshot of a result
	 * @return byte[]
	 */
	public byte[] screenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}
	/**
	 * @see Driver wait for given time
	 * @throws InterruptedException
	 */
	private void sleep() throws InterruptedException {
		Thread.sleep(3000);
	}

	/**
	 * @return
	 * @see To get the project path
	 * @return path
	 */

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}

	/**
	 * @see To get a property File value
	 * @param Key
	 * @return (String) properties.get(Key);
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public static String getPropertyFileValue(String Key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		return (String) properties.get(Key);
	}

	/**
	 * @see To give Inputs to the text box
	 * @param element
	 * @param data
	 */

	public void Sendkeys(WebElement element, String data)

	{
		element.sendKeys(data);

	}

	/**
	 * @see To click the button
	 * @param element
	 */
	public void btnclick(WebElement element) {
		element.click();
	}

	/**
	 * @see To clear the text box
	 * @param element
	 */
	public void clear(WebElement element) {
		element.clear();
	}

	public Alert a;

	public void alerts() {
		a = driver.switchTo().alert();

	}

	/**
	 * @see Dismiss the alert box
	 */
	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * @see Accept the alert box
	 */
	public void alertAccept() {
		driver.switchTo().alert().accept();
	}

	/**
	 * @see To enter a text using javascript
	 * @param data
	 * @param element
	 */
	public void entertextbyjs(String data, WebElement element) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	/**
	 * @see Get a attribute by using javascript
	 * @param element
	 * @return string
	 */

	public String getAttributeByJs(WebElement element) {
		String string = js.executeScript("return arguments[0].getAttribute('value')", element).toString();
		return string;

	}

	/**
	 * @see
	 * @param element
	 * @param data
	 */
	public void selectbyvalue(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByValue(data);
	}

	public void selectbyindex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public void selectbyVisibletext(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByVisibleText(data);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	/**
	 * @see To Select a DropDown by using it type
	 * @param locator
	 * @param type
	 * @param value
	 */
	public void selectDropDown(By locator, String type, String value) {
		Select select = new Select(getElement(locator));
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));

			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Invalid select class");
			break;
		}
	}

	/**
	 * @see To get a Attribute Value without using javascript
	 * @param element
	 * @param data
	 * @return string
	 */
	public String GetAttri(WebElement element, String data) {
		return element.getAttribute(data);
	}

	/**
	 * @see To get a data from Excel
	 * @param Sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws IOException]
	 */
	public String GetDataFromExcel(String Sheetname, int rowno, int cellno) throws IOException {
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\TestMavenBuild\\Excel\\Data 2.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		CellType cellType = cell.getCellType();
		String data1 = null;
		switch (cellType) {
		case STRING:
			data1 = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
				data1 = format.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					data1 = String.valueOf(round);
				} else {
					data1 = String.valueOf(numericCellValue);
				}
			}
			break;             
         
			
		default:
			System.out.println("Invalid Data From Excel");
			break;
		}
		return data1;

	}

	/**
	 * @see To create a sheet,row and column and enter a value in sheet
	 * @param data
	 * @param cellno
	 * @param rowno
	 * @param Sheetname
	 * @throws IOException
	 */
	public void CreateSheetFromExcel(String data, int cellno, int rowno, String Sheetname) throws IOException {
		File file = new File("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\TestMavenBuild\\\\Excel\\\\Data 2.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet createSheet = book.createSheet(Sheetname);
		Row createRow = createSheet.createRow(rowno);
		Cell createCell = createRow.createCell(cellno);
		createCell.setCellValue(data);
		FileOutputStream stream1 = new FileOutputStream(file);
		book.write(stream1);

	}

//	public void implicitwait(int sec) {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
//	}
	/**
	 * @see It used to perform
	 * @param element
	 */
	public void click(WebElement element) {
		element.click();

	}

}
