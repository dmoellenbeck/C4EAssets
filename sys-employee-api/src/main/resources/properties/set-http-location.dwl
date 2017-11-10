%dw 1.0
%output application/java
---
inboundProperties.origin ++ inboundProperties.'http.relative.path' ++ '/' ++ payload[0].GENERATED_KEYS