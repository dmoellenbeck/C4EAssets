%dw 1.0
%output application/java
%var policiesBeingUsed = flowVars.policiesBeingUsed distinctBy $
%var policyApiAssociationList = flowVars.policyApiList groupBy $.policyTemplateId
%function mapAPIData(input)
  input map {
    apiName: $.apiName,
    apiVersionName: $.apiVersionName,
    organizationId: $.organizationId
  }
---
{
	policiesBeingUsed: policiesBeingUsed,
	policyApiAssociationList: policyApiAssociationList mapObject ((v, k) ->
  		{
    		(k): mapAPIData(v)
  		}
	),
	totalNumberOfUnsecureAPIs: flowVars.totalNumberOfUnsecureAPIs,
	totalNumberOfUndocumentedAPIs: flowVars.totalNumberOfUndocumentedAPIs,
	orgsWithoutScriptUserPermissions: flowVars.orgsWithoutScriptUserPermissions
}