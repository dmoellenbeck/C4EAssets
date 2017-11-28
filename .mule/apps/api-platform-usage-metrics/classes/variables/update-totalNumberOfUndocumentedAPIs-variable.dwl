%dw 1.0
%output application/java
%function getTotalNumberOfUndocumentedAPIs(input)
	sizeOf (flatten input.apis.versions map {
	  portalId: $.portalId
	} filter $.portalId == null)
---
flowVars.totalNumberOfUndocumentedAPIs + getTotalNumberOfUndocumentedAPIs(payload)