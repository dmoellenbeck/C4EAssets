%dw 1.0
%output application/java
---
flatten payload.apis.versions map {
  apiId: $.apiId,
  apiVersionId: $.id
}