%dw 1.0
%output application/java
---
flowVars.policiesBeingUsed ++ (payload map flowVars.policyTemplates[$.policyTemplateId])