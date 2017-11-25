%dw 1.0
%output application/json
---
{
	type: "enriched-http-event",
	duration: "90d",
	aggregators: [
		{ 
			dimension: "request_disposition", 
			limit: 5, 
			order: "descending"
		}
	]
}