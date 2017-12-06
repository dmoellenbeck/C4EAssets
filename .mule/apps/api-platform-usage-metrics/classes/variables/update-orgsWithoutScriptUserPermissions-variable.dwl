%dw 1.0
%output application/java
---
flowVars.orgsWithoutScriptUserPermissions +
{
	orgId: flowVars.currentOrgId,
	orgName: flowVars.orgIdNameMap[flowVars.currentOrgId]
}