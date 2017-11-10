%dw 1.0
%output application/json
---
payload map {
	id: $.no,
  	dateOfBirth: $.dob,
  	firstName: $.first_name,
  	lastName: $.last_name,
  	gender: 'Male' when $.gender == 'M' otherwise 'Female',
  	hireDate: $.hire_date
}