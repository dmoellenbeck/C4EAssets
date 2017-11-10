%dw 1.0
%output application/json
---
{
	id: payload[0].no,
  	dateOfBirth: payload[0].dob,
  	firstName: payload[0].first_name,
  	lastName: payload[0].last_name,
  	gender: 'Male' when payload[0].gender == 'M' otherwise 'Female',
  	hireDate: payload[0].hire_date
}