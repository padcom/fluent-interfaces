package org.example.selenium.tvn24;

import org.example.selenium.SeleniumTest;
import org.example.selenium.google.GoogleHomePage;
import org.junit.Test;

public class GoogleSearchTest extends SeleniumTest {
	@Test
	public void search_for_future_processing() {
		new GoogleHomePage(driver)
			.search("tvn24")
			.waitForSearchResults(10)
			.selectNthResult(0)
			.assertPageHeaderExists();
	}

	@Test
	public void search_for_future_processing_using_scenario() {
		new GoogleHomePage(driver)
			.run(new EnterTvn24PageViaGoogleSearchScenario()
				.timeout(20))
			.assertPageHeaderExists();
	}
}
