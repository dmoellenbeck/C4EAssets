%dw 1.0
%output application/java
---
payload[1].data map {
  id: $.id,
  name: $.name
}