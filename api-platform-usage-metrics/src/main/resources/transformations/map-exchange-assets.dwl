%dw 1.0
%output application/java
%var total = sizeOf flowVars.assetsList
%var assets = flowVars.assetsList
---
({ "Total": total } ++
(assets groupBy $.type mapObject (v, k) -> {
  (capitalize pluralize k): sizeOf v
})) when total > 0 otherwise {}
