%dw 1.0
%output application/java
---
{
	totalNumberOfAPIDefinitions: payload[0],
	totalTransactionsProcessed: payload[1],
	exchangeAssets: payload[2],
	totalNumberOfUsers: payload[3],
	totalNumberOfClientApplications: payload[4],
	runtimeUsageStatistics: payload[5],
	policiesBeingUsed: payload[6].policiesBeingUsed,
	policyApiAssociationList: payload[6].policyApiAssociationList,
	totalNumberOfUnsecureAPIs: payload[6].totalNumberOfUnsecureAPIs,
	totalNumberOfUndocumentedAPIs: payload[6].totalNumberOfUndocumentedAPIs,
	activeAPIs: payload[7],
	businessOrgs: payload[8]
}