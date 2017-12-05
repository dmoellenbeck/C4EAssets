%dw 1.0
%output application/java
%var appList = payload.data filter $.lastReportedStatus == "STARTED"
---
flowVars.hybridAppNames ++
{
  (flowVars.envId): appList map $.name
}
