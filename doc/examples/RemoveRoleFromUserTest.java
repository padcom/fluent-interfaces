package org.example;

import ...

public class RemoveRoleFromUserTest extends SeleniumTest {
	private static final String NEW_ROLE_NAME = UniqueId.next();
	private static final String NEW_ROLE_DESCRIPTION = UniqueId.next();
	private static final String NEW_EXTERNAL_ID = UniqueId.next();
	public static final int ROLE_LEVEL = 3;
	private static final String NEW_USER_NAME = UniqueId.next();
	private static final String EMAIL = new Date().getTime() + "@example.org";
	private static final String ORGUNIT = "Demo";
	private static final String NO_ROLE_ASSIGNED_MESSAGE = "This user is not assigned to any role.";

	@Test
	public void should_remove_role_from_user_test() {
		new LoginPage(driver)
				.login()
				.run(new CreateRoleScenario(NEW_ROLE_DESCRIPTION, NEW_ROLE_NAME)
						.level(ROLE_LEVEL)
						.permission("User", "view")
						.orgUnitRestricted(false)
						.externalId(NEW_EXTERNAL_ID))
				.run(new CreateUserScenario(NEW_USER_NAME).orgunit(ORGUNIT).email(EMAIL))
				.run(new AddRolesToUserScenario(NEW_USER_NAME, NEW_ROLE_NAME))
				.run(new RemoveRolesFromUserScenario(NEW_USER_NAME, NEW_ROLE_NAME))
				.gotoViewRoles()
				.assertNoRoleAssigned(NO_ROLE_ASSIGNED_MESSAGE)
				.logout();
	}
}
