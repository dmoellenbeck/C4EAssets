%dw 1.0
%output application/java
---
flowVars.processedCalls + (payload.response[0].request_disposition[0].PROCESSED.count default 0)
