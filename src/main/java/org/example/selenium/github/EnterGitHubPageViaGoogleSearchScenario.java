package org.example.selenium.github;

import org.example.selenium.Scenario;
import org.example.selenium.google.GoogleHomePage;

public class EnterGitHubPageViaGoogleSearchScenario implements Scenario<GoogleHomePage, GitHubHomePage> {
	private long timeout = 10;

	public EnterGitHubPageViaGoogleSearchScenario timeout(long timeout) {
		this.timeout = timeout;
		return this;
	}

	@Override
	public GitHubHomePage run(GoogleHomePage entry) {
		return entry
				.search("github")
				.waitForSearchResults(timeout)
				.selectNthResult(0);
	}
}
