package com.cucumber.testmethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMethods {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public void waitTime(int sec) {
			try {
				Thread.sleep(sec);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
