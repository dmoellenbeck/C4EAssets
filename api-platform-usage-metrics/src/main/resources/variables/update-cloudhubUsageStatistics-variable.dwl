%dw 1.0
%output application/java
%var started = payload filter $.status == "STARTED"
---
flowVars.cloudhubUsageStatistics ++ ((flowVars.envName): started groupBy $.workerType mapObject ( (v, k) ->
  (k): sum v.workers
) ++ {applicationCount: sizeOf started})
