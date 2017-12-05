%dw 1.0
%output application/java
%var mapIterative = ((argument) ->
  argument match {
    argument when (argument is :array) -> (argument map mapIterative($)) reduce ($ ++ $$),
    argument when (argument is :object) -> argument mapObject (mapIterative($)),
    default -> argument
  }
)
---
mapIterative(payload.apis map {
  ($.id): $.name
})