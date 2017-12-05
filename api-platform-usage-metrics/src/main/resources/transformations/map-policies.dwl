%dw 1.0
%output application/java
---
(payload.policyTemplateId) map flowVars.policyTemplates[$] default []