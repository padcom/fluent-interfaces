package org.example.scenario.user;

import ...

public class CreateUserScenario implements Scenario<EntryPage, UserViewPage> {
	private final String username;
	private String firstName = "John";
	private String lastName = "Doe";
	private String phone = "0123456789";
	private String externalId = "";
	private String email = "john.doe@example.com";
	private String orgunit = "Demo";
	private String timeZone = "Europe/Oslo";

	public CreateUserScenario(String username) {
		this.username = username;
	}

	@Override
	public UserViewPage run(EMSPage entry) {
		return entry
				.gotoUsersTab()
				.gotoUsersPage()
				.gotoCreateUserPage()
				.fillUserName(username)
				.fillFirstName(firstName)
				.fillLastName(lastName)
				.fillEmail(email)
				.fillPhone(phone)
				.fillExternalId(externalId)
				.selectSubOrgUnit(orgunit)
				.selectTimeZone(timeZone)
				.clickSaveOnSuccess();
	}

	public CreateUserScenario orgunit(String orgunit) {
		this.orgunit = orgunit;
		return this;
	}

	public CreateUserScenario timeZone(String timeZone) {
		this.timeZone = timeZone;
		return this;
	}

	public CreateUserScenario email(String email) {
		this.email = email;
		return this;
	}

	public CreateUserScenario firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public CreateUserScenario lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public CreateUserScenario externalId(String externalId) {
		this.externalId = externalId;
		return this;
	}
}
