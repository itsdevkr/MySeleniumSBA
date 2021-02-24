package com.pedigreeTest.Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestPage {

	WebDriver driver;
	String sheetName = "pedigreeTest";

	public TestPage(WebDriver driver) {

		this.driver = driver;
	}
	
	public void searchDog() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//div[@class='search']/div/a")).click();
		Thread.sleep(2000);

		ExcelRead er = new ExcelRead();

		String text = er.getCellValue(sheetName, 0, 0);
		WebElement search = driver.findElement(By.xpath("//div[@class='searchdiv']/div/input"));
		Thread.sleep(2000);
		search.sendKeys(text);

		Thread.sleep(2000);
	}

	public void articles() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String Artcles = driver.findElement(By.xpath("//*[@class='searchresult']/div/div/div/h3/span")).getText();
		Thread.sleep(2000);
		String count = Artcles.substring(1, 3);
		System.out.println("no fo articles present in search results for a dog ::::::" + count);
		ExcelWriteData ew = new ExcelWriteData();
		Thread.sleep(2000);
		ew.putCellValue(sheetName, count);
		Thread.sleep(2000);

	}

	public void secondLink() throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='articles-result']/ul[1]/li[2]/a")))
				.click().build().perform();
		Thread.sleep(3000);
	}

	public void logo() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@id='Header_imgLogo']")).click();
		Thread.sleep(2000);
	}

	public void screenshot() throws IOException {
		File screenshot = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String timeStamp = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		
				
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("f");
		
		extent.flush();
		
		FileUtils.copyFile(screenshot, new File(".\\Screenshot\\ss.PNG"));
	}
	
	
}
