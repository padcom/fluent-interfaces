package org.example.selenium.google;

import java.util.List;

import org.example.selenium.Page;
import org.example.selenium.github.GitHubHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends Page {
	private static final String CSS_SEARCH_RESULT_LINKS = "li.g div.rc > h3.r > a";

	@FindBy(css = CSS_SEARCH_RESULT_LINKS)
	List<WebElement> results;

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public SearchResultPage waitForSearchResults(long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_SEARCH_RESULT_LINKS)));
		return new SearchResultPage(driver);
	}

	public GitHubHomePage selectNthResult(int n) {
		results.get(n).click();
		return new GitHubHomePage(driver);
	}
}
