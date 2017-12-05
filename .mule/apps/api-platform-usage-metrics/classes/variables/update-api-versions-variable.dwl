%dw 1.0
%output application/java
%var apiId = flowVars.apiId as :string
---
flowVars.apiVersions +
(flowVars.apiNames.'$apiId' ++ "-" ++ flowVars.versionName): {
	isCloudHub: payload.endpoint.isCloudHub default false,
	containsPortal: true when payload.portalId != null otherwise false,
	isSecure: (sizeOf flowVars.policiesApplied) > 0,
	policiesApplied: flowVars.policiesApplied,
	orgId: payload.organizationId,
	apiName: flowVars.apiNames.'$apiId',
	versionName: payload.name,
	apiVersionDescription: payload.description,
	apiId: payload.apiId,
	apiVersionId: payload.id,
	portalId: payload.portalId,
	apiVersionProxyEndpointId: payload.endpoint.proxyUri,
	apiVersionImplementationEndpoint: payload.endpointUri,
	apiVersionDeployment: null,
	apiVersionCreationDate: flowVars.apiCreationDates.'$apiId',
	portalIsPublic: flowVars.portalIsPublic,
	apiOwner: flowVars.apiOwner,
	rootRAMLContentLength: null,
	portalPageCount: null
}