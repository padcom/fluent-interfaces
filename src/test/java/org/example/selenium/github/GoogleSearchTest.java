package org.example.selenium.github;

import org.example.selenium.SeleniumTest;
import org.example.selenium.github.EnterGitHubPageViaGoogleSearchScenario;
import org.example.selenium.google.GoogleHomePage;
import org.junit.Test;

public class GoogleSearchTest extends SeleniumTest {
	@Test
	public void search_for_github() {
		new GoogleHomePage(driver)
			.search("github")
			.waitForSearchResults(10)
			.selectNthResult(0)
			.assertPageHeaderExists();
	}

	@Test
	public void search_for_github_using_scenario() {
		new GoogleHomePage(driver)
			.run(new EnterGitHubPageViaGoogleSearchScenario()
				.timeout(20))
			.assertPageHeaderExists();
	}
}
