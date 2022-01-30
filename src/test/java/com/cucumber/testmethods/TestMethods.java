package com.cucumber.testmethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMethods {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public void waitTime(int milliseconds) {
			try {
				Thread.sleep(milliseconds);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void scrollPage(int x,int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}
	
}
