%dw 1.0
%output application/json
---
{
	totalNumberOfBusinessOrgs: sizeOf flowVars.orgIdList,
	totalNumberOfAPIDefinitions: payload.totalNumberOfAPIDefinitions,
	activeAPIs: payload.activeAPIs,
	exchangeAssets: payload.exchangeAssets,
	totalNumberOfUsers: payload.totalNumberOfUsers,
	totalNumberOfClientApplications: payload.totalNumberOfClientApplications,
	onPremRuntimeUsageStatistics: payload.runtimeUsageStatistics.onPremRuntimeUsageStatistics,
	cloudhubUsageStatistics: payload.runtimeUsageStatistics.cloudhubUsageStatistics,
	totalTransactionsProcessed: payload.totalTransactionsProcessed,
	totalTransactionsProcessedInProduction: "Work in progress",
	totalTransactionsProcessedInAcceptance: "Work in progress",
	totalTransactionsProcessedInDevelopment: "Work in progress",
	policiesBeingUsed: payload.policiesBeingUsed,
	policyApiAssociationList: payload.policyApiAssociationList,
	totalNumberOfUnsecureAPIs: payload.totalNumberOfUnsecureAPIs,
	totalNumberOfUndocumentedAPIs: payload.totalNumberOfUndocumentedAPIs,
	businessOrgs: payload.businessOrgs
}