%dw 1.0
%output application/java
%var started = payload.data filter $.lastReportedStatus == "STARTED"
---
flowVars.onPremRuntimeUsageStatistics
++
{
	(flowVars.envName): sizeOf started
}