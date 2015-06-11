package org.example.scenario.role;

import ...

public class CreateRoleScenario implements Scenario<EntryPage, ViewRolePage> {
	private final String name;
	private final String description;
	private int level = 2;
	private final Map<String, String[]> permissionToApply = new LinkedHashMap<>();
	private String externalId = UniqueId.next();
	private boolean orgUnitRestricted = false;

	public CreateRoleScenario(String description, String name) {
		this.description = description;
		this.name = name;
	}

	@Override
	public ViewRolePage run(EMSPage entry) {
		return entry
				.gotoUsersTab()
				.gotoRolesPage()
				.gotoCreateRolePage()
				.typeDesctiption(description)
				.typeName(name)
				.selectRoleLevel(level)
				.selectPermissions(permissionToApply)
				.typeExternalId(externalId)
				.checkOrgUnitRestriction(orgUnitRestricted)
				.submit();
	}

	public CreateRoleScenario level(int level) {
		this.level = level;
		return this;
	}

	public CreateRoleScenario permission(String function, String... modifiers) {
		permissionToApply.put(function, modifiers);
		return this;
	}

	public CreateRoleScenario externalId(String externalId) {
		this.externalId = externalId;
		return this;
	}

	public CreateRoleScenario orgUnitRestricted(boolean restricted) {
		this.orgUnitRestricted = restricted;
		return this;
	}
}
