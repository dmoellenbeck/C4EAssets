%dw 1.0
%output application/java
%var mapIterative = ((argument) ->
  argument match {
    argument when (argument is :array) -> (argument map mapIterative($)) reduce ($ ++ $$),
    argument when (argument is :object) -> argument mapObject (mapIterative($)),
    default -> argument
  }
)
%var environments = mapIterative(flowVars.environments map {
  ($.id):$.name
})
---
flowVars.activeAPIsCounter mapObject (
  (environments[$$]): ($ ++ { total: $.on-prem + $.cloudhub}) 
)