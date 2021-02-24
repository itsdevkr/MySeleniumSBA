package com.pedigreeTest.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pedigreeTest.Pages.TestPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pedigree {

	WebDriver driver;

	@Test
	/*public void f() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.pedigree.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TestPage tp = new TestPage(driver);
		tp.searchDog();
		tp.articles();
		tp.secondLink();
		tp.logo();
		tp.screenshot();
		driver.close();

	}
*/
	
	public void f() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.pedigree.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TestPage tp = new TestPage(driver);
		tp.searchDog();
		tp.articles();
		tp.secondLink();
		tp.logo();
		tp.screenshot();
		driver.quit();
	}
	
}
