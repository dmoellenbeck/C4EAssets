%dw 1.0
%output application/java
---
flowVars.totalNumberOfAPIDefinitions + sum (payload.apis map sizeOf $.versions)