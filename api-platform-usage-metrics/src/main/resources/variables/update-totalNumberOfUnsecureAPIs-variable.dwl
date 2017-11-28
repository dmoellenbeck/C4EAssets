%dw 1.0
%output application/java
---
flowVars.totalNumberOfUnsecureAPIs + 1 when (sizeOf payload) == 0 otherwise 0