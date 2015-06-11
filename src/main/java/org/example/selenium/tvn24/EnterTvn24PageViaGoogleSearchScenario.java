package org.example.selenium.tvn24;

import org.example.selenium.Scenario;
import org.example.selenium.google.GoogleHomePage;

public class EnterTvn24PageViaGoogleSearchScenario implements Scenario<GoogleHomePage, Tvn24HomePage> {
	private long timeout = 10;

	public EnterTvn24PageViaGoogleSearchScenario timeout(long timeout) {
		this.timeout = timeout;
		return this;
	}

	@Override
	public Tvn24HomePage run(GoogleHomePage entry) {
		return entry
				.search("tvn24")
				.waitForSearchResults(timeout)
				.selectNthResult(0);
	}
}
