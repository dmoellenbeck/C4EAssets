# Onboarding Service
API that creates a sub-organization in the Anypoint platform, assigns external group names and finally sends out an email confirmation.

# Why?
Typically in large organizations, it is very common to have multiple business units leveraging the Sub-Organizations to group their assets.
As part of the on-boarding process, this would mean that someone from the Operations team would gather the required information like the
name of the Sub-Org and also the distinguished names of the AD groups that the users would have to belong to in order to inherit permissions via
external group mapping (external group mapping can be done only for federated orgs). This API automates that process by leveraging Anypoint platform apis to create business orgs and to assign external 
group mappings. This API would then be extended to integrated with other components of the Customer's on-boarding process. For example,
at ExxonMobil, this API has been extended to also integrated with TFS to provision the repository for the consumers as well. 

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

# Config.properties - Please fill the properties file (under src/main/resources) with appropriate values

```
rootOrgId=<plugin the root organization Id>
username=<anypoint platform username>
password=<anypoint platform password>
emailUsername=<username to be used for email>
emailPassword=<password to be used for email>
emailFrom=<address of the sender>
emailTo=<address of the recipient>
```

# Expected Output 

![externalGroupMapping](images/externalGroupMapping.png)

# Email Snapshot