%dw 1.0
%output application/java
%function flattenApiVersion(apiVersion)
	apiVersion mapObject $
%var totalNumberOfUnsecureAPIs = sizeOf ((flowVars.apiVersions map flattenApiVersion($)) filter $.isSecure == false)
%var totalNumberOfUndocumentedAPIs = sizeOf ((flowVars.apiVersions map flattenApiVersion($)) filter $.containsPortal == false)
%var policiesBeingUsed = flatten ((flowVars.apiVersions map flattenApiVersion($) filter $.containsPortal == true) map $.policiesApplied) distinctBy $
---
flowVars.businessOrgs +
{
	businessOrgName: flowVars.businessOrgName,
	businessOrgId: flowVars.businessOrgId,
	processedCalls: flowVars.processedCalls,
  	blockedCalls: flowVars.blockedCalls,
  	apiVersions: flowVars.apiVersions,
  	numberOfAPIDefinitions: sizeOf (flowVars.apiVersions),
  	totalNumberOfUnsecureAPIs: totalNumberOfUnsecureAPIs,
  	totalNumberOfUndocumentedAPIs: totalNumberOfUndocumentedAPIs,
  	policiesBeingUsed: policiesBeingUsed default []
}