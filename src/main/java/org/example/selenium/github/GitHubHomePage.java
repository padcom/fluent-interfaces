package org.example.selenium.github;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.selenium.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubHomePage extends Page {
	public GitHubHomePage(WebDriver driver) {
		super(driver);
	}

	public GitHubHomePage assertPageHeaderExists() {
		assertThat(driver.findElements(
				By.cssSelector("#start-of-content")).size()).isEqualTo(1);
		return this;
	}
}
