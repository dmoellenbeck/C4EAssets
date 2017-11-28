%dw 1.0
%output application/java
---
flowVars.policyApiList ++
(payload map {
  policyTemplateId: flowVars.policyTemplates[$.policyTemplateId],
  apiName: $.configurationData.apiName,
  apiVersionName: $.configurationData.apiVersionName,
  organizationId: flowVars.orgIdNameMap[$.organizationId]
}) default []