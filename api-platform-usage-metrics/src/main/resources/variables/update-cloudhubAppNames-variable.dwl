%dw 1.0
%output application/java
%var appList = payload filter $.status == "STARTED"
---
flowVars.cloudhubAppNames ++
{
  (flowVars.envId): appList map $.domain
}