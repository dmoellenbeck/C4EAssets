%dw 1.0
%output application/java
---
{
	onPremRuntimeUsageStatistics: flowVars.onPremRuntimeUsageStatistics,
	cloudhubUsageStatistics: flowVars.cloudhubUsageStatistics
}