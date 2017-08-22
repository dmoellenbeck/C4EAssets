# Onboarding Service
API that creates a sub-organization in the Anypoint platform, assigns external group names and finally sends out an email confirmation.

# Why?

# Sample Request

```
{
	"businessGroupName": "APPS-MULE-TEST",
	"orgAdminGroupNames": ["cn=COLLIBRA.DEV.ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com", "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"],
	"apiCreatorGroupNames": ["cn=COLLIBRA.DEV.ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com", "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"],
	"userName":"sai"
}
```

# Sample Response

```
{"message":"Organization Created and external group names have been configured"}
```

# Email Snapshot