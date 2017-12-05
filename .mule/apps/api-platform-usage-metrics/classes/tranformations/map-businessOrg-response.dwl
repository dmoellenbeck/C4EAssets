%dw 1.0
%output application/java
---
flowVars.businessOrgs when flowVars.businessOrgs.error == null otherwise []