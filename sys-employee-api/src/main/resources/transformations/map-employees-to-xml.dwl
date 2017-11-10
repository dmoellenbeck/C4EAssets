%dw 1.0
%output application/xml
---
employees: {
	(payload map (emp) -> 
		employee: {
			id: emp.no,
  			dateOfBirth: emp.dob,
  			firstName: emp.first_name,
  			lastName: emp.last_name,
  			gender: 'Male' when emp.gender == 'M' otherwise 'Female',
  			hireDate: emp.hire_date
		}
	)
}