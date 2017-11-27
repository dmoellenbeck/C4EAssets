%dw 1.0
%output application/java
---
payload map {
  assetId: $.assetId,
  type: $.type
}
