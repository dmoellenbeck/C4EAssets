%dw 1.0
%output application/java

%function mapHierarchy(input)
  input match {
    :object -> {(input.id): input.name} + mapHierarchy(input.subOrganizations),
    :array -> input map mapHierarchy($),
    default -> {}
  }

%var flattenHierarchy = ((argument) ->
  argument match {
    argument when (argument is :array) -> (argument map flattenHierarchy($)) reduce ($ ++ $$),
    argument when (argument is :object) -> argument mapObject (flattenHierarchy($)),
    default -> argument
  }
)

---
flattenHierarchy(mapHierarchy(payload[0]))