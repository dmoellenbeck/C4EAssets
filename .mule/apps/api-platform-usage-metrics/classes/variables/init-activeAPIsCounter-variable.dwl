%dw 1.0
%output application/java
---
{(flowVars.environments map {
  ($.id): {
  	on-prem: 0,
    cloudhub: 0
  }
})}