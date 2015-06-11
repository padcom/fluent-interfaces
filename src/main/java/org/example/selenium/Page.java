package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

/**
 * Base class for all pages
 *
 * @author Maciej Hryniszak
 */
public abstract class Page {
	private static final int MAX_TIME_FOR_PAGE_TO_LOAD = 60000;

	protected final WebDriver driver;

	/**
	 * Page constructor and initializer
	 * @param driver WebDriver to initialize the page with
	 */
	public Page(WebDriver driver) {
		// initialize internal state
		this.driver = driver;
		// wait for the page to load
		new WaitForPageToLoad().apply(driver, new String[] { String.valueOf(MAX_TIME_FOR_PAGE_TO_LOAD) });
		// initialize page elements
		PageFactory.initElements(driver, this);
	}

	/**
	 * A method to run the given scenario
	 * @param scenario Scenario to run
	 * @return final page or exception if that final state can't be achieved
	 */
	public <Input extends Page, Output extends Page> Output run(Scenario<Input, Output> scenario) {
		return scenario.run((Input) this);
	}
}
