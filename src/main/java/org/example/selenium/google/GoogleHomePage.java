package org.example.selenium.google;

import org.example.selenium.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends Page {
	@FindBy(name = "q")
	WebElement searchBox;

	@FindBy(name = "btnG")
	WebElement searchButton;

	public GoogleHomePage(WebDriver driver) {
		super(driver);
		driver.navigate().to("http://www.google.pl?q=1");
	}

	public SearchResultPage search(String query) {
		searchBox.clear();
		searchBox.sendKeys(query);
		searchButton.click();
		return new SearchResultPage(driver);
	}
}
