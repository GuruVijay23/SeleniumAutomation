package com.cucumber.testmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	
	public void scrollTo(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		new Actions(driver).moveToElement(element).perform();
	}
	
	public void click(WebElement element) {				// click the element
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch(ElementClickInterceptedException e) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch(ElementNotInteractableException e) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch(StaleElementReferenceException e) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
	}
	
	public boolean isElementVisible(String xpath) {				//verify locator visibility
		By byElement = By.xpath(xpath);
		waitTime(1000);
		Boolean check = driver.findElement(byElement).isDisplayed();
		return check;
	}
	
	public boolean isElementVisible(WebElement element) {			// verify element visibility
		Boolean check = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
		}catch(Exception e) {
		}
		return check;
	}
	
	public void selectDropDown(WebElement element, String data) {		// select By Visible Text
		Select select = new Select(element);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			select.selectByVisibleText(data);
		} catch (Exception e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			select.selectByVisibleText(data);
		}
	}
	
	public void selectDropDownByIndex(WebElement element, String data) {	//select By ddIndex
		Select select = new Select(element);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			select.selectByIndex(Integer.parseInt(data) - 1);
		} catch (Exception e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			select.selectByIndex(Integer.parseInt(data) - 1);
		}
	}
	
	public void input(WebElement element, String data) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			element.sendKeys(data);
		} catch(ElementNotInteractableException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			element.click();
			element.sendKeys(data);
		} catch(StaleElementReferenceException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			element.click();
			element.sendKeys(data);
		}
	}
	
	public void input(String xpath, String data) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			element.sendKeys(data);
		} catch(ElementNotInteractableException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			element.click();
			element.sendKeys(data);
		} catch(StaleElementReferenceException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			element.click();
			element.sendKeys(data);
		}
	}
	
	public void emptyInput(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		} catch(ElementNotInteractableException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		} catch(StaleElementReferenceException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		}
	}
	
	public void emptyInput(String xpath) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		} catch(ElementNotInteractableException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		} catch(StaleElementReferenceException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		}
	}
	
	public String read(WebElement element) {
		try {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.getText();
		} catch(ElementNotInteractableException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.getText();
		} catch(StaleElementReferenceException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.getText();
		}
	}
	
	public String read(String xpath) {
		try {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			return element.getText();
		} catch(ElementNotInteractableException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			return element.getText();
		} catch(StaleElementReferenceException e) {
			waitTime(1500);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			WebElement element=driver.findElement(By.xpath(xpath));
			return element.getText();
		}
	}
}
