%dw 1.0
%output application/java
%var policiesTemplate =
  payload map {
  	id: $.id,
  	name: $.name
  }
---
policiesTemplate map ({
  ($.id): $.name
}) reduce ($ ++ $$) default {}