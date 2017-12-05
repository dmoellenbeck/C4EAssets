%dw 1.0
%output application/java
%var environment = payload.deployment.environmentId
%var applicationName = payload.deployment.applicationName
---
flowVars.activeAPIsCounter mapObject ((v,k) -> {
 (k):v
} when (('$k') != environment) otherwise (k): {
  cloudhub : (v.cloudhub + 1) when flowVars.cloudhubAppNames.'$environment' contains applicationName otherwise v.cloudhub,
  on-prem : (v.on-prem + 1) when flowVars.hybridAppNames.'$environment' contains applicationName otherwise v.on-prem
})