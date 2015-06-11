package org.example.selenium.tvn24;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.selenium.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tvn24HomePage extends Page {
	public Tvn24HomePage(WebDriver driver) {
		super(driver);
	}

	public Tvn24HomePage assertPageHeaderExists() {
		assertThat(driver.findElements(By.cssSelector("#tvn24")).size()).isEqualTo(1);
		return this;
	}
}
