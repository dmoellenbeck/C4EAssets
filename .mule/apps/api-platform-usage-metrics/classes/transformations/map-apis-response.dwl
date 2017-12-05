%dw 1.0
%output application/java
---
flatten payload.apis.versions map {
  orgId: $.organizationId,
  apiId: $.apiId,
  apiVersionId: $.id,
  versionName: $.name,
  portalId: $.portalId,
  portalIsPublic: $.portal.isPublic default false
}