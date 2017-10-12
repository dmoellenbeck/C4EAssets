# user-org-roles-details-service

# Why???
Typically in large organizations, we have seen that the process to get on-boarded to the Anypoint platform happens via a front end/form/web-site. 
This front-end typically gathers details about business org name that needs to be created, external group map names for the roles etc..
In order to provide personalized service to an existing user based on their username/profile or a for a new user to find out if his/her business-org has
already been on-boarded and if so, find out what are the external group names for each of the roles, there is a need for a service that leverages
the Anypoint platform apis and returns that information. This service does exactly that.

This service has two endpoints:

# To return the business organizations that the user is part of and the roles that the user is assigned to within each business org

# Sample Request

```

curl -X GET 'http://localhost:8082/details/user?userName=skparna%40NA.XOM.COM' 

```

# Sample Response

```
[
    {
        "ExxonMobil": [
            "Organization Administrators",
            "Cloudhub Developer (Acceptance)",
            "Exchange Viewers",
            "Cloudhub Admin (Production)"
        ]
    },
    {
        "APPS-CP-EMIT": [
            "Organization Administrators"
        ]
    },
    {
        "APPS-DATA-DATA": []
    },
    {
        "APPS-DATA-TECH": []
    },
    {
        "APPS-FIN-UPST": [
            "Organization Administrators"
        ]
    },
    {
        "APPS-MAD-IDE": []
    },
    {
        "APPS-MANU-MRO": [
            "Organization Administrators"
        ]
    },
    {
        "APPS-MS-SUP": []
    },
    {
        "APPS-MULE-TEST": [
            "Organization Administrators",
            "Cloudhub Admin (Sandbox)",
            "Cloudhub Admin (Design)"
        ]
    },
    {
        "APPS-TECH-AIS": [
            "Organization Administrators"
        ]
    },
    {
        "APPS-TECH-AIS-AE": []
    },
    {
        "APPS-TECH-SPS": []
    },
    {
        "BOT-PROTO": []
    },
    {
        "CLOUD-INT-OP": [
            "Organization Administrators"
        ]
    },
    {
        "DIGITAL-MANU-API": []
    },
    {
        "ITS-GLBL-PLNG": []
    },
    {
        "MANUFACTURING-TEST": []
    },
    {
        "PROJ-EMPO-DSIT": []
    },
    {
        "TRAINING-VIDEO": []
    },
    {
        "UIT-UTDD-UTC": []
    }
]
```

# To return the Business organizations and the different roles per business-org with corresponding external group names if applicable


# Sample Request

```
curl -X GET http://localhost:8082/details/orgs
```

# Sample Response

```
[
    {
        "ExxonMobil": [
            {
                "API Creators": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Viewers": []
            },
            {
                "Audit Log Viewers": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Cloudhub Admin (Acceptance)": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.CLOUD.UG,ou=Standard Accounts,dc=NA,dc=XOM,dc=com",
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Cloudhub Admin (Development)": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Cloudhub Admin (DR)": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Cloudhub Admin (Production)": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Cloudhub Developer (Acceptance)": []
            },
            {
                "Cloudhub Developer (Development)": []
            },
            {
                "Cloudhub Developer (DR)": []
            },
            {
                "Cloudhub Developer (Production)": []
            },
            {
                "Cloudhub Support (Acceptance)": []
            },
            {
                "Cloudhub Support (Development)": []
            },
            {
                "Cloudhub Support (DR)": []
            },
            {
                "Cloudhub Support (Production)": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Exchange Administrators": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Exchange Contributors": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Exchange Viewers": [
                    "CN=EMIT.ALLWTYPES.UG,OU=AccMan,DC=NA,DC=XOM,DC=com"
                ]
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Portals Viewer": [
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.cloud.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            }
        ]
    },
    {
        "APPS-CP-EMIT": [
            {
                "API Creators": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "API Versions Owner": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-DATA-DATA": [
            {
                "API Creators": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "API Versions Owner": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-DATA-TECH": [
            {
                "API Creators": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "API Versions Owner": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "CN=MULESOFT.APPS.CP.EMIT.UG,OU=Standard Accounts,DC=na,DC=xom,DC=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-FIN-UPST": [
            {
                "API Creators": [
                    "cn=APPS-FIN-UPST-MULESOFT-ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=APPS-FIN-UPST-MULESOFT-ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Cloudhub Admin (Design)": []
            },
            {
                "Cloudhub Admin (Sandbox)": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=APPS-FIN-UPST-MULESOFT-ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-MAD-IDE": [
            {
                "API Creators": [
                    "cn=APPS-FIN-UPST-MULESOFT-ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=APPS-FIN-UPST-MULESOFT-ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Cloudhub Admin (Design)": []
            },
            {
                "Cloudhub Admin (Sandbox)": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=APPS-FIN-UPST-MULESOFT-ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-MANU-MRO": [
            {
                "API Creators": [
                    "cn=MFGAPI.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=MFGAPI.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=MFGAPI.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-MS-SUP": [
            {
                "API Creators": [
                    "cn=MFGAPI.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=MFGAPI.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=MFGAPI.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-MULE-TEST": [
            {
                "API Creators": [
                    "cn=COLLIBRA.DEV.ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com",
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Versions Owner": []
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Cloudhub Admin (Design)": []
            },
            {
                "Cloudhub Admin (Sandbox)": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=COLLIBRA.DEV.ADMIN.UG,OU=Standard Accounts,dc=NA,dc=XOM,dc=com",
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-TECH-AIS": [
            {
                "API Creators": [
                    "cn=EMIT.APPS.TECH.SVCS.APPL.INTEG.ITGTN.ALLWTYPES.UG,ou=AccMan,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=MULESOFT.APPS.TECH.AIS.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=MULESOFT.APPS.TECH.AIS.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-TECH-AIS-AE": [
            {
                "API Creators": [
                    "cn=EMIT.APPS.TECH.SVCS.APPL.INTEG.ITGTN.ALLWTYPES.UG,ou=AccMan,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=MULESOFT.APPS.TECH.AIS.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=MULESOFT.APPS.TECH.AIS.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "APPS-TECH-SPS": [
            {
                "API Creators": [
                    "cn=EMIT.APPS.TECH.SVCS.APPL.INTEG.ITGTN.ALLWTYPES.UG,ou=AccMan,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=MULESOFT.APPS.TECH.AIS.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=MULESOFT.APPS.TECH.AIS.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "BOT-PROTO": [
            {
                "API Creators": [
                    "cn=EMIT.APPS.TECH.SVCS.APPL.INTEG.ITGTN.ALLWTYPES.UG,ou=AccMan,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "API Versions Owner": [
                    "cn=MULESOFT.APPS.TECH.AIS.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=MULESOFT.APPS.TECH.AIS.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "CLOUD-INT-OP": [
            {
                "API Creators": []
            },
            {
                "API Versions Owner": []
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.CLOUD.UG,ou=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "DIGITAL-MANU-API": [
            {
                "API Creators": []
            },
            {
                "API Versions Owner": []
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.CLOUD.UG,ou=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "ITS-GLBL-PLNG": [
            {
                "API Creators": []
            },
            {
                "API Versions Owner": []
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.CLOUD.UG,ou=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "MANUFACTURING-TEST": [
            {
                "API Creators": []
            },
            {
                "API Versions Owner": []
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.CLOUD.UG,ou=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "PROJ-EMPO-DSIT": [
            {
                "API Creators": []
            },
            {
                "API Versions Owner": []
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.CLOUD.UG,ou=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "TRAINING-VIDEO": [
            {
                "API Creators": []
            },
            {
                "API Versions Owner": []
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.CLOUD.UG,ou=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    },
    {
        "UIT-UTDD-UTC": [
            {
                "API Creators": []
            },
            {
                "API Versions Owner": []
            },
            {
                "Audit Log Viewers": []
            },
            {
                "Exchange Administrators": []
            },
            {
                "Exchange Contributors": []
            },
            {
                "Exchange Viewers": []
            },
            {
                "Organization Administrators": [
                    "cn=EMIT.APPS.MULESOFT.TECHADMIN.FC.PRD.UG,ou=Standard Accounts,dc=na,dc=xom,dc=com",
                    "cn=EMIT.APPS.MULESOFT.ADMINUSR.CLOUD.UG,ou=Standard Accounts,dc=NA,dc=XOM,dc=com"
                ]
            },
            {
                "Portals Viewer": []
            }
        ]
    }
]
```

# Config.properties - Please fill the properties file (under src/main/resources) with appropriate values

```
rootOrgId=<plugin the root organization Id>
anypoint.username=<anypoint platform username>
anypoint.password=<anypoint platform password>

anypoint.accountsApi.uri=accounts/api/organizations
anypoint.apiplatform.uri=apiplatform/repository/v2/organizations

api.name=UserDetailsService
api.version=1.0
```

