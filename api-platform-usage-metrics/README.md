# API Platform Usage Metrics - Dashboard Service
This service is intended to provide visibility into the consumption/adoption of the Anypoint Platform by Customers. It leverages Anypoint platform APIs to iteratively query the business orgs for statistics around Users, Active APIs, Exchange Assets, Runtime Consumption.

# Why?
Typically in large organizations that use the Anypoint platform, it becomes very important to monitor the adoption of the Anypoint platform.
The following are some of the metrics that are important to capture:
* Number of API Definitions
* Number of Active APIs (ones that have been deployed to the runtime)
* Number of assets published in Exchange
* Number of Business Organizations
* On-prem runtime Capacity and CloudHub Capacity Usage (apis deployed on-prem vs Cloudhub)
* Policies being used and the association between a policy and the apis that are using the policy
* Transactions processed in the last quarter

While all of this information is available in the Anypoint platform there is no easy way to look at all of this data in a single plane. The goal of this service is to leverage the Platform apis to query this data and return a json that can be processed by a reporting tool or Splunk to build dashboards.

# Sample Request

```

curl -X GET http://localhost:8082/api/apiplatform/metrics 

```

<details><summary>Sample Response</summary><p>
# Sample Response

```
{
    "totalNumberOfBusinessOrgs": 7,
    "totalNumberOfAPIDefinitions": 84,
    "activeAPIs": [
        {
            "development": {
                "total": 5,
                "on-prem": 3,
                "cloudhub": 2
            }
        },
        {
            "acceptance": {
                "total": 0,
                "on-prem": 0,
                "cloudhub": 0
            }
        },
        {
            "production": {
                "total": 0,
                "on-prem": 0,
                "cloudhub": 0
            }
        }
    ],
    "exchangeAssets": {
        "Total": 11,
        "Custom": 10,
        "Soap APIs": 1,
        "REST APIs": 0,
        "RAML fragments": 0,
        "Templates": 0,
        "Examples": 0,
        "Connectors": 0
    },
    "totalNumberOfUsers": 166,
    "totalNumberOfClientApplications": 1,
    "onPremRuntimeUsageStatistics": {
        "development": 68,
        "acceptance": 25,
        "production": 13
    },
    "cloudhubUsageStatistics": {
        "development": {
            "applicationCount": 22,
            "Medium": 2,
            "Micro": 20
        },
        "acceptance": {
            "applicationCount": 5,
            "Micro": 6
        },
        "production": {
            "applicationCount": 1,
            "Micro": 2
        }
    },
    "totalTransactionsProcessed": 59277,
    "totalTransactionsProcessedInProduction": "Work in progress",
    "totalTransactionsProcessedInAcceptance": "Work in progress",
    "totalTransactionsProcessedInDevelopment": "Work in progress",
    "policiesBeingUsed": [
        "Cross-Origin resource sharing",
        "Simple security manager",
        "HTTP basic authentication",
        "Client ID enforcement",
        "XOM Kerberos Authentication Policy",
        "XOM Windows Authentication",
        "Backend Basic Auth Test",
        "XOM Kerberos Authentication",
        "Rate limiting",
        "Auth0 JWT Token Validation Policy",
        "Kerberos Authentication"
    ],
    "policyApiAssociationList": [
        {
            "XOM Kerberos Authentication Policy": [
                {
                    "apiName": "Kerberos  Delegation Issue",
                    "versionName": "dev",
                    "orgName": "ExxonMobil"
                }
            ],
            "Simple security manager": [
                {
                    "apiName": "MULESOFT-ADMIN-api-deployment",
                    "versionName": "v1-ACC",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "MULESOFT-ADMIN-api-deployment",
                    "versionName": "v1-DEV",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "CLOUD-INT-OP-WADL-POC",
                    "versionName": "v1-DEV",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "ae-https-poc",
                    "versionName": "v1-dev",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "MULESOFT-ADMIN-api-deployment",
                    "versionName": "v1-PRD",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "salesforcepoci2d",
                    "versionName": "v1",
                    "orgName": "ExxonMobil"
                }
            ],
            "XOM Windows Authentication": [
                {
                    "apiName": "Kerberos  Delegation Issue",
                    "versionName": "dev",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "API Performance Test",
                    "versionName": "1-dev",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "idm-api",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-CP-EMIT"
                }
            ],
            "Auth0 JWT Token Validation Policy": [
                {
                    "apiName": "MDTA",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "MultipartIssue",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "MDTA",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-TECH-AIS"
                }
            ],
            "Kerberos Authentication": [
                {
                    "apiName": "Morneau Shepell API",
                    "versionName": "v1-PRD",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "Morneau Shepell API",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "Morneau Shepell API",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                }
            ],
            "Cross-Origin resource sharing": [
                {
                    "apiName": "Success Factor",
                    "versionName": "1",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "DB Test",
                    "versionName": "1.0",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "Bug",
                    "versionName": "v1",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "Financial Forecasting API",
                    "versionName": "1",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-dev",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "access-mgmt-proxy",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "access-mgmt-proxy",
                    "versionName": "v1-acc",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-acc",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "access-mgmt-proxy",
                    "versionName": "v1",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "access-mgmt-proxy",
                    "versionName": "v1-dev",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-PRD",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                },
                {
                    "apiName": "Morneau Shepell API",
                    "versionName": "v1-PRD",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "SMTP",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "Morneau Shepell API",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "Success Factors Proxy API",
                    "versionName": "1",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "Morneau Shepell API",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                }
            ],
            "Client ID enforcement": [
                {
                    "apiName": "Gtirgger",
                    "versionName": "V1",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "XomWSDL",
                    "versionName": "1.0",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "DB Test",
                    "versionName": "1.0",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "API Performance Test",
                    "versionName": "1-dev",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "salesforcepoci2d",
                    "versionName": "v1",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "Lead App",
                    "versionName": "1.0",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "ticket-prc-svc",
                    "versionName": "v1-dev",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "idm-api",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "ticket-prc-svc",
                    "versionName": "v1-prd",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "ticket-prc-svc",
                    "versionName": "v1-acc",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "test",
                    "versionName": "1.0",
                    "orgName": "APPS-MULE-TEST"
                },
                {
                    "apiName": "MDTA",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "MultipartIssue",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "SMTP",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "DB Demo API",
                    "versionName": "v1-DEV",
                    "orgName": "APPS-TECH-AIS"
                },
                {
                    "apiName": "MDTA",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-TECH-AIS"
                }
            ],
            "Backend Basic Auth Test": [
                {
                    "apiName": "DB Test",
                    "versionName": "1.0",
                    "orgName": "ExxonMobil"
                }
            ],
            "Rate limiting": [
                {
                    "apiName": "test",
                    "versionName": "1.0",
                    "orgName": "APPS-MULE-TEST"
                }
            ],
            "HTTP basic authentication": [
                {
                    "apiName": "MULESOFT-ADMIN-api-deployment",
                    "versionName": "v1-ACC",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "MULESOFT-ADMIN-api-deployment",
                    "versionName": "v1-DEV",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "CLOUD-INT-OP-WADL-POC",
                    "versionName": "v1-DEV",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "ae-https-poc",
                    "versionName": "v1-dev",
                    "orgName": "ExxonMobil"
                },
                {
                    "apiName": "MULESOFT-ADMIN-api-deployment",
                    "versionName": "v1-PRD",
                    "orgName": "ExxonMobil"
                }
            ],
            "XOM Kerberos Authentication": [
                {
                    "apiName": "ticket-prc-svc",
                    "versionName": "v1-dev",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-dev",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "idm-api",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "access-mgmt-proxy",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "access-mgmt-proxy",
                    "versionName": "v1-acc",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "test123",
                    "versionName": "1",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-ACC",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-acc",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "access-mgmt-proxy",
                    "versionName": "v1",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "access-mgmt-proxy",
                    "versionName": "v1-dev",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "ticket-prc-svc",
                    "versionName": "v1-prd",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "ticket-prc-svc",
                    "versionName": "v1-acc",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-PRD",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "request-api-proxy",
                    "versionName": "v1-PRD",
                    "orgName": "APPS-CP-EMIT"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                },
                {
                    "apiName": "Manufacturing System Api",
                    "versionName": "v1-dev",
                    "orgName": "APPS-MANU-MRO"
                }
            ]
        }
    ],
    "totalNumberOfUnsecureAPIs": 44,
    "totalNumberOfUndocumentedAPIs": 55,
    "businessOrgs": [
        {
            "businessOrgName": "ExxonMobil",
            "businessOrgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
            "processedCalls": 0,
            "blockedCalls": 0,
            "apiVersions": [
                {
                    "Access Manager-1.0": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Access Manager",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 20419633,
                        "apiVersionId": 564367,
                        "portalId": 80335,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-06-16T13:15:36.197Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "JBZUMBR@NA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "TASSA Process API-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "TASSA Process API",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 13073067,
                        "apiVersionId": 179104,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-04-11T19:21:48.354Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Success Factor-1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Success Factor",
                        "versionName": "1",
                        "apiVersionDescription": null,
                        "apiId": 19480839,
                        "apiVersionId": 417476,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/successfactors",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-06-08T20:10:42.001Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "SFDC-Utility-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "SFDC-Utility",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 16438824,
                        "apiVersionId": 195700,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-18T04:02:02.133Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "sivapitestbasis-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "sivapitestbasis",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 61000638,
                        "apiVersionId": 4112241,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-10-10T04:37:44.953Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "SIV@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "MULESOFT-ADMIN-api-deployment-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Simple security manager",
                            "HTTP basic authentication"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "MULESOFT-ADMIN-api-deployment",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": "",
                        "apiId": 17529414,
                        "apiVersionId": 259171,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-26T07:32:32.727Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "nsilpan@AP.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Gtirgger-V1": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Gtirgger",
                        "versionName": "V1",
                        "apiVersionDescription": null,
                        "apiId": 55023614,
                        "apiVersionId": 3555259,
                        "portalId": 97602,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-27T06:27:26.737Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "llstrass"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "XomWSDL-1.0": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "XomWSDL",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 12495858,
                        "apiVersionId": 174567,
                        "portalId": 66080,
                        "apiVersionProxyEndpointId": "http://0.0.0.0/TESTWS",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-03-30T14:06:40.072Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "MULESOFT-ADMIN-api-deployment-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Simple security manager",
                            "HTTP basic authentication"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "MULESOFT-ADMIN-api-deployment",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 17529414,
                        "apiVersionId": 258959,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-26T07:07:27.236Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "nsilpan@AP.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "API Performance Test-WSDLTest": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "API Performance Test",
                        "versionName": "WSDLTest",
                        "apiVersionDescription": "",
                        "apiId": 46741269,
                        "apiVersionId": 4085654,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-10-09T14:28:25.947Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Kerberos  Delegation Issue-dev": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "XOM Kerberos Authentication Policy",
                            "XOM Windows Authentication"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Kerberos  Delegation Issue",
                        "versionName": "dev",
                        "apiVersionDescription": null,
                        "apiId": 46620872,
                        "apiVersionId": 2956926,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/kerberosdelegationissue/api",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-13T02:09:29.614Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Hivemind Question API-1.0": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Hivemind Question API",
                        "versionName": "1.0",
                        "apiVersionDescription": "API for Hivemind application",
                        "apiId": 20328414,
                        "apiVersionId": 549266,
                        "portalId": 84249,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": "http://hivemind.xom.com:770/api/",
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-06-15T21:50:01.913Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "sbartl2@UPSTREAMACCTS.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "DB Test-1.0": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "Client ID enforcement",
                            "Backend Basic Auth Test"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "DB Test",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 11354895,
                        "apiVersionId": 145386,
                        "portalId": 54845,
                        "apiVersionProxyEndpointId": "http://0.0.0.0/xomdb/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-02-08T02:34:50.057Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Bug-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Bug",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 46425066,
                        "apiVersionId": 2945170,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0/mulebug3",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-12T14:40:31.550Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "nsilpan@AP.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "sivtestbasis123-v1": {
                        "isCloudHub": true,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "sivtestbasis123",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 61004933,
                        "apiVersionId": 4112695,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/sivbasis",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-10-10T04:52:23.359Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "SIV@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "CLOUD-INT-OP-WADL-POC-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Simple security manager",
                            "HTTP basic authentication"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "CLOUD-INT-OP-WADL-POC",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 25684692,
                        "apiVersionId": 991693,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-13T07:49:20.453Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "nsilpan@AP.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "apibestpractice-v1": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "apibestpractice",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 11690213,
                        "apiVersionId": 160961,
                        "portalId": 60381,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-03-07T09:12:13.814Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "API Performance Test-1-dev": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement",
                            "XOM Windows Authentication"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "API Performance Test",
                        "versionName": "1-dev",
                        "apiVersionDescription": null,
                        "apiId": 46741269,
                        "apiVersionId": 2967043,
                        "portalId": 94554,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/APPS-TECH-AIS/apiperformance/api",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-13T09:20:44.370Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Financial Forecasting API-1": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Financial Forecasting API",
                        "versionName": "1",
                        "apiVersionDescription": "Test",
                        "apiId": 27168431,
                        "apiVersionId": 1211119,
                        "portalId": 85289,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": "https://apigatewaydev.na.xom.com/forecast",
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-19T19:09:44.132Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [
                            "xom"
                        ],
                        "apiOwner": [
                            "PLSCHI1@NA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "AD API-0.1": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "AD API",
                        "versionName": "0.1",
                        "apiVersionDescription": "List AD all groups and AD groups by ID or Name",
                        "apiId": 11287054,
                        "apiVersionId": 136639,
                        "portalId": 54023,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-01-19T02:37:11.459Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "Setsanee"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "ae-https-poc-v1-dev": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Simple security manager",
                            "HTTP basic authentication"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "ae-https-poc",
                        "versionName": "v1-dev",
                        "apiVersionDescription": null,
                        "apiId": 61039203,
                        "apiVersionId": 4116374,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-10-10T06:50:01.605Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "nsilpan@AP.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "MULESOFT-ADMIN-api-deployment-v1-PRD": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Simple security manager",
                            "HTTP basic authentication"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "MULESOFT-ADMIN-api-deployment",
                        "versionName": "v1-PRD",
                        "apiVersionDescription": "",
                        "apiId": 17529414,
                        "apiVersionId": 259178,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-26T07:32:58.795Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "nsilpan@AP.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "AEAddToSchedule-1.0": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "AEAddToSchedule",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 12082812,
                        "apiVersionId": 169336,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-03-20T15:19:28.074Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "SUV@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Emma LUIS-Production": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Emma LUIS",
                        "versionName": "Production",
                        "apiVersionDescription": "LUIS Production API for Emma",
                        "apiId": 18658487,
                        "apiVersionId": 345022,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": "https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/1ee0db5a-cec7-4769-9f9e-3b58fa3a76d3?subscription-key=9f1db94abc974009a8c014e62384dad8&timezoneOffset=0&verbose=true&q=",
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-06-02T17:17:22.233Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "cmsower@upstreamaccts.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "salesforcepoci2d-v1": {
                        "isCloudHub": true,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Simple security manager",
                            "Client ID enforcement"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "salesforcepoci2d",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 46721581,
                        "apiVersionId": 2965358,
                        "portalId": 94513,
                        "apiVersionProxyEndpointId": "https://0.0.0.0:8082/sftoi2d_ep",
                        "apiVersionImplementationEndpoint": "https://salesforcepoci2d.cloudhub.io/sftoi2d_ep",
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-13T08:11:02.018Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "BBOZANY@EA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Emma LUIS-Staging": {
                        "isCloudHub": true,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Emma LUIS",
                        "versionName": "Staging",
                        "apiVersionDescription": "LUIS staging API for Emma chat bot",
                        "apiId": 18658487,
                        "apiVersionId": 345005,
                        "portalId": 77921,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": "https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/1ee0db5a-cec7-4769-9f9e-3b58fa3a76d3?subscription-key=9f1db94abc974009a8c014e62384dad8&staging=true&timezoneOffset=0&verbose=true&q=",
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-06-02T17:15:31.137Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "cmsower@upstreamaccts.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "apibestpractice-v1-dev": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "apibestpractice",
                        "versionName": "v1-dev",
                        "apiVersionDescription": "",
                        "apiId": 11690213,
                        "apiVersionId": 162172,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-03-08T04:43:57.201Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "MAPIS-V1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "MAPIS",
                        "versionName": "V1",
                        "apiVersionDescription": null,
                        "apiId": 20157344,
                        "apiVersionId": 514981,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-06-14T13:18:27.027Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "BBOZANY@EA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Lead App-1.0": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement"
                        ],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "Lead App",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 12414499,
                        "apiVersionId": 173560,
                        "portalId": 65262,
                        "apiVersionProxyEndpointId": "http://0.0.0.0/lead",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-03-28T14:48:47.633Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "BASIS-ITSM-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "f6c67fb1-ffef-4dbf-a006-77615803c4fb",
                        "apiName": "BASIS-ITSM",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 19985185,
                        "apiVersionId": 474279,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0/basis/itsm",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-06-13T04:11:14.727Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    }
                }
            ],
            "numberOfAPIDefinitions": 30,
            "numberOfActiveAPIsInDev": 5,
            "numberOfActiveAPIsInAcceptance": 0,
            "numberOfActiveAPIsInProd": 0,
            "devAPIsOnPrem": 3,
            "devAPIsInCloud": 2,
            "acceptanceAPIsOnPrem": 0,
            "acceptanceAPIsInCloud": 0,
            "prodAPIsOnPrem": 0,
            "prodAPIsInCloud": 0,
            "totalNumberOfUnsecureAPIs": 15,
            "totalNumberOfUndocumentedAPIs": 18,
            "policiesBeingUsed": [
                "Cross-Origin resource sharing",
                "Simple security manager",
                "HTTP basic authentication",
                "Client ID enforcement",
                "XOM Kerberos Authentication Policy",
                "XOM Windows Authentication",
                "Backend Basic Auth Test"
            ]
        },
        {
            "businessOrgName": "APPS-CP-EMIT",
            "businessOrgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
            "processedCalls": 59277,
            "blockedCalls": 39644,
            "apiVersions": [
                {
                    "ticket-prc-svc-v1-dev": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "ticket-prc-svc",
                        "versionName": "v1-dev",
                        "apiVersionDescription": null,
                        "apiId": 43000974,
                        "apiVersionId": 2697187,
                        "portalId": 92530,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/ticket-prc-svc-v1-dev",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-03T16:37:10.997Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "FSKYT@SA.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "DB Demo API MSW-v1 - DEV": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "DB Demo API MSW",
                        "versionName": "v1 - DEV",
                        "apiVersionDescription": "API for demonstration by connecting to MSSQL database",
                        "apiId": 43968290,
                        "apiVersionId": 2784421,
                        "portalId": 92985,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-06T06:03:48.989Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "MSW@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "request-api-proxy-v1-dev": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "request-api-proxy",
                        "versionName": "v1-dev",
                        "apiVersionDescription": null,
                        "apiId": 25053071,
                        "apiVersionId": 952908,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/request-api-proxy",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-10T15:52:18.717Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "assubra@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "idm-api-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "idm-api",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": "",
                        "apiId": 36503678,
                        "apiVersionId": 2272295,
                        "portalId": 92035,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/idm-api",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-22T12:40:51.604Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "JBZUMBR@NA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "access-mgmt-proxy-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "access-mgmt-proxy",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": null,
                        "apiId": 25527770,
                        "apiVersionId": 2489470,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-28T19:33:55.056Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "kksoo@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "access-mgmt-proxy-v1-acc": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "access-mgmt-proxy",
                        "versionName": "v1-acc",
                        "apiVersionDescription": null,
                        "apiId": 25527770,
                        "apiVersionId": 1828354,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-07T03:45:14.187Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "kksoo@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "test123-1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "test123",
                        "versionName": "1",
                        "apiVersionDescription": null,
                        "apiId": 24200840,
                        "apiVersionId": 919291,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-07T18:52:30.135Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "assubra@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "idm-api-v1-PRD": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "idm-api",
                        "versionName": "v1-PRD",
                        "apiVersionDescription": "",
                        "apiId": 36503678,
                        "apiVersionId": 2272304,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-22T12:41:17.309Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "JBZUMBR@NA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "idm-api-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement",
                            "XOM Windows Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "idm-api",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": "",
                        "apiId": 36503678,
                        "apiVersionId": 2272280,
                        "portalId": 92035,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/idm-api",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-22T12:40:21.781Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "JBZUMBR@NA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "request-api-proxy-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "request-api-proxy",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": null,
                        "apiId": 25053071,
                        "apiVersionId": 2630091,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-01T18:18:07.644Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "assubra@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "request-api-proxy-v1-acc": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "request-api-proxy",
                        "versionName": "v1-acc",
                        "apiVersionDescription": null,
                        "apiId": 25053071,
                        "apiVersionId": 1839230,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-07T13:46:05.787Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "assubra@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "access-mgmt-proxy-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "access-mgmt-proxy",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 25527770,
                        "apiVersionId": 978994,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-12T14:45:13.022Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "kksoo@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "access-mgmt-proxy-v1-dev": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "access-mgmt-proxy",
                        "versionName": "v1-dev",
                        "apiVersionDescription": null,
                        "apiId": 25527770,
                        "apiVersionId": 979643,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-12T15:37:00.023Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "kksoo@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "ticket-prc-svc-v1-prd": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "XOM Kerberos Authentication",
                            "Client ID enforcement"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "ticket-prc-svc",
                        "versionName": "v1-prd",
                        "apiVersionDescription": "",
                        "apiId": 43000974,
                        "apiVersionId": 2697571,
                        "portalId": 92532,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/ticket-prc-svc-v1",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-03T16:53:08.966Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "FSKYT@SA.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "ticket-prc-svc-v1-acc": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "XOM Kerberos Authentication",
                            "Client ID enforcement"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "ticket-prc-svc",
                        "versionName": "v1-acc",
                        "apiVersionDescription": "",
                        "apiId": 43000974,
                        "apiVersionId": 2697345,
                        "portalId": 92531,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/ticket-prc-svc-v1-acc",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-03T16:43:46.286Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "FSKYT@SA.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "request-api-proxy-v1-PRD": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "request-api-proxy",
                        "versionName": "v1-PRD",
                        "apiVersionDescription": null,
                        "apiId": 25053071,
                        "apiVersionId": 2092728,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-16T20:02:48.979Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "assubra@NA.xom.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "ITCMApi-v1 - DEV": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "0b0d7d08-234d-4b2d-9dbe-ab582cc1ee15",
                        "apiName": "ITCMApi",
                        "versionName": "v1 - DEV",
                        "apiVersionDescription": "ITCM Api Proxy application",
                        "apiId": 46345231,
                        "apiVersionId": 2940358,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-12T10:06:34.685Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "MSW@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    }
                }
            ],
            "numberOfAPIDefinitions": 17,
            "numberOfActiveAPIsInDev": 0,
            "numberOfActiveAPIsInAcceptance": 0,
            "numberOfActiveAPIsInProd": 0,
            "devAPIsOnPrem": 0,
            "devAPIsInCloud": 0,
            "acceptanceAPIsOnPrem": 0,
            "acceptanceAPIsInCloud": 0,
            "prodAPIsOnPrem": 0,
            "prodAPIsInCloud": 0,
            "totalNumberOfUnsecureAPIs": 3,
            "totalNumberOfUndocumentedAPIs": 11,
            "policiesBeingUsed": [
                "Client ID enforcement",
                "XOM Kerberos Authentication",
                "Cross-Origin resource sharing",
                "XOM Windows Authentication"
            ]
        },
        {
            "businessOrgName": "APPS-FIN-UPST",
            "businessOrgId": "9502d036-d660-42ef-bf4e-08a7cf323f18",
            "processedCalls": 0,
            "blockedCalls": 0,
            "apiVersions": [
                {
                    "IDEAS Global Interface-1.0": {
                        "isCloudHub": true,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "9502d036-d660-42ef-bf4e-08a7cf323f18",
                        "apiName": "IDEAS Global Interface",
                        "versionName": "1.0",
                        "apiVersionDescription": "IDEAS Global Interface",
                        "apiId": 23560152,
                        "apiVersionId": 875020,
                        "portalId": 84562,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": "http://hoeizwd01.upstreamaccts.xom.com:9080/TmsService.svc",
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-04T18:13:30.265Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "llopez7@UPSTREAMACCTS.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    }
                }
            ],
            "numberOfAPIDefinitions": 1,
            "numberOfActiveAPIsInDev": 0,
            "numberOfActiveAPIsInAcceptance": 0,
            "numberOfActiveAPIsInProd": 0,
            "devAPIsOnPrem": 0,
            "devAPIsInCloud": 0,
            "acceptanceAPIsOnPrem": 0,
            "acceptanceAPIsInCloud": 0,
            "prodAPIsOnPrem": 0,
            "prodAPIsInCloud": 0,
            "totalNumberOfUnsecureAPIs": 1,
            "totalNumberOfUndocumentedAPIs": 0,
            "policiesBeingUsed": []
        },
        {
            "businessOrgName": "APPS-MANU-MRO",
            "businessOrgId": "06fd140b-f801-41fa-8593-cd4a271abe73",
            "processedCalls": 0,
            "blockedCalls": 0,
            "apiVersions": [
                {
                    "Manufacturing System Api-v1": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "06fd140b-f801-41fa-8593-cd4a271abe73",
                        "apiName": "Manufacturing System Api",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 14301532,
                        "apiVersionId": 190079,
                        "portalId": 72425,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-05T02:59:16.131Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Manufacturing System Api-v1-dev": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "XOM Kerberos Authentication",
                            "XOM Kerberos Authentication",
                            "XOM Kerberos Authentication",
                            "XOM Kerberos Authentication",
                            "XOM Kerberos Authentication",
                            "XOM Kerberos Authentication",
                            "XOM Kerberos Authentication",
                            "XOM Kerberos Authentication"
                        ],
                        "orgId": "06fd140b-f801-41fa-8593-cd4a271abe73",
                        "apiName": "Manufacturing System Api",
                        "versionName": "v1-dev",
                        "apiVersionDescription": "",
                        "apiId": 14301532,
                        "apiVersionId": 190080,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-05T03:00:47.462Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Manufacturing System Api-v1-acc": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "06fd140b-f801-41fa-8593-cd4a271abe73",
                        "apiName": "Manufacturing System Api",
                        "versionName": "v1-acc",
                        "apiVersionDescription": "",
                        "apiId": 14301532,
                        "apiVersionId": 1412779,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-24T12:27:15.009Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    }
                }
            ],
            "numberOfAPIDefinitions": 3,
            "numberOfActiveAPIsInDev": 0,
            "numberOfActiveAPIsInAcceptance": 0,
            "numberOfActiveAPIsInProd": 0,
            "devAPIsOnPrem": 0,
            "devAPIsInCloud": 0,
            "acceptanceAPIsOnPrem": 0,
            "acceptanceAPIsInCloud": 0,
            "prodAPIsOnPrem": 0,
            "prodAPIsInCloud": 0,
            "totalNumberOfUnsecureAPIs": 2,
            "totalNumberOfUndocumentedAPIs": 2,
            "policiesBeingUsed": [
                "Cross-Origin resource sharing",
                "XOM Kerberos Authentication"
            ]
        },
        {
            "businessOrgName": "APPS-MULE-TEST",
            "businessOrgId": "e21b40d8-4638-4872-a0bb-a5b7d3044756",
            "processedCalls": 0,
            "blockedCalls": 0,
            "apiVersions": [
                {
                    "blah-2.0-dev": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "e21b40d8-4638-4872-a0bb-a5b7d3044756",
                        "apiName": "blah",
                        "versionName": "2.0-dev",
                        "apiVersionDescription": "",
                        "apiId": 44145326,
                        "apiVersionId": 2797703,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-06T18:25:59.688Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "tanetg"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "blah-2.0-acceptance": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "e21b40d8-4638-4872-a0bb-a5b7d3044756",
                        "apiName": "blah",
                        "versionName": "2.0-acceptance",
                        "apiVersionDescription": "",
                        "apiId": 44145326,
                        "apiVersionId": 2951104,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-12T20:16:26.678Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "tanetg"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "test-1.0": {
                        "isCloudHub": true,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Rate limiting",
                            "Client ID enforcement"
                        ],
                        "orgId": "e21b40d8-4638-4872-a0bb-a5b7d3044756",
                        "apiName": "test",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 44145235,
                        "apiVersionId": 2797690,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-06T18:25:26.221Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "tanetg"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "test-2.0": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "e21b40d8-4638-4872-a0bb-a5b7d3044756",
                        "apiName": "test",
                        "versionName": "2.0",
                        "apiVersionDescription": "",
                        "apiId": 44145235,
                        "apiVersionId": 2797695,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-06T18:25:38.793Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "tanetg"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "blah-1.0": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "e21b40d8-4638-4872-a0bb-a5b7d3044756",
                        "apiName": "blah",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 44145326,
                        "apiVersionId": 2797699,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-06T18:25:50.213Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "tanetg"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    }
                }
            ],
            "numberOfAPIDefinitions": 5,
            "numberOfActiveAPIsInDev": 0,
            "numberOfActiveAPIsInAcceptance": 0,
            "numberOfActiveAPIsInProd": 0,
            "devAPIsOnPrem": 0,
            "devAPIsInCloud": 0,
            "acceptanceAPIsOnPrem": 0,
            "acceptanceAPIsInCloud": 0,
            "prodAPIsOnPrem": 0,
            "prodAPIsInCloud": 0,
            "totalNumberOfUnsecureAPIs": 4,
            "totalNumberOfUndocumentedAPIs": 5,
            "policiesBeingUsed": [
                "Rate limiting",
                "Client ID enforcement"
            ]
        },
        {
            "businessOrgName": "APPS-TECH-AIS",
            "businessOrgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
            "processedCalls": 0,
            "blockedCalls": 0,
            "apiVersions": [
                {
                    "SIV APP-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "SIV APP",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 18447882,
                        "apiVersionId": 318447,
                        "portalId": 77405,
                        "apiVersionProxyEndpointId": "http://0.0.0.0/ais/sivapp/v1",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-31T12:06:33.202Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "MDTA-v1-DEV": {
                        "isCloudHub": true,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement",
                            "Auth0 JWT Token Validation Policy"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "MDTA",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 27044392,
                        "apiVersionId": 1190461,
                        "portalId": 85399,
                        "apiVersionProxyEndpointId": "https://0.0.0.0:8082/APP-TECH-AIS/MDTA",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-19T07:12:02.405Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "DB Demo API_NP-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "DB Demo API_NP",
                        "versionName": "v1",
                        "apiVersionDescription": "Connect SQLDB",
                        "apiId": 41338581,
                        "apiVersionId": 2534817,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-30T02:43:41.408Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "ttrongw@AP.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Active Directory-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Active Directory",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 21710239,
                        "apiVersionId": 722964,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-06-25T07:33:26.260Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Morneau Shepell API-v1-PRD": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "Kerberos Authentication"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Morneau Shepell API",
                        "versionName": "v1-PRD",
                        "apiVersionDescription": "",
                        "apiId": 28597229,
                        "apiVersionId": 3255005,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-20T07:40:27.810Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "DB Demo API-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "DB Demo API",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": "",
                        "apiId": 13023099,
                        "apiVersionId": 178758,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-04-11T04:38:29.326Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "SMTP-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "SMTP",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": "",
                        "apiId": 39462175,
                        "apiVersionId": 2654564,
                        "portalId": 92468,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-02T11:09:56.635Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "APTTUS-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "APTTUS",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": "",
                        "apiId": 43613065,
                        "apiVersionId": 3885946,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-10-05T01:12:19.554Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "CUD@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "MultipartIssue-v1-DEV": {
                        "isCloudHub": true,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Auth0 JWT Token Validation Policy",
                            "Client ID enforcement"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "MultipartIssue",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 59390523,
                        "apiVersionId": 3937903,
                        "portalId": 99021,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-10-06T07:32:14.267Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Change Demo-v1-PRD": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Change Demo",
                        "versionName": "v1-PRD",
                        "apiVersionDescription": "",
                        "apiId": 18285320,
                        "apiVersionId": 308408,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-30T12:04:51.570Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "SMTP-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "Client ID enforcement"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "SMTP",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 39462175,
                        "apiVersionId": 2694811,
                        "portalId": 92468,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-03T14:58:38.947Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "PTJtest-1.0": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "PTJtest",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 23247066,
                        "apiVersionId": 850405,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-03T08:48:33.901Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "pmingbu@AP.XOM.COM"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "SMTP-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "SMTP",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 39462175,
                        "apiVersionId": 2367565,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-25T06:38:24.847Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "DB Demo API-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "DB Demo API",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": "",
                        "apiId": 13023099,
                        "apiVersionId": 178752,
                        "portalId": 67650,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-04-11T04:14:20.536Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Common Logging Service-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Common Logging Service",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": "Custom Mulesoft message logging service",
                        "apiId": 55275008,
                        "apiVersionId": 3572590,
                        "portalId": 98751,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-27T16:43:48.989Z",
                        "portalIsPublic": true,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TNGUYE1@NA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "APTTUS-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "APTTUS",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 43613065,
                        "apiVersionId": 2753573,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-05T07:29:43.166Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "CUD@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Bug Tracking-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Bug Tracking",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 23235456,
                        "apiVersionId": 849446,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-03T07:30:10.671Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Change Demo-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Change Demo",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": "",
                        "apiId": 18285320,
                        "apiVersionId": 306755,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-30T08:46:24.339Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "DB Demo API-v1": {
                        "isCloudHub": false,
                        "containsPortal": true,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "DB Demo API",
                        "versionName": "v1",
                        "apiVersionDescription": "API for demonstration by connecting to MSSQL database",
                        "apiId": 13023099,
                        "apiVersionId": 178678,
                        "portalId": 67650,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-04-10T20:47:24.357Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Morneau Shepell API-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "Kerberos Authentication"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Morneau Shepell API",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": "",
                        "apiId": 28597229,
                        "apiVersionId": 2505942,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-08-29T06:57:34.643Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Test Delivery-1.0": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Test Delivery",
                        "versionName": "1.0",
                        "apiVersionDescription": null,
                        "apiId": 25987471,
                        "apiVersionId": 1015714,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/delivery/deliveries",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-14T16:20:14.974Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "PYADAV@NA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "MDTA-v1-ACC": {
                        "isCloudHub": true,
                        "containsPortal": true,
                        "isSecure": true,
                        "policiesApplied": [
                            "Client ID enforcement",
                            "Auth0 JWT Token Validation Policy"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "MDTA",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": "",
                        "apiId": 27044392,
                        "apiVersionId": 2608557,
                        "portalId": 85399,
                        "apiVersionProxyEndpointId": "http://0.0.0.0:8081/api",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-01T03:37:57.409Z",
                        "portalIsPublic": false,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Success Factors Proxy API-1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Success Factors Proxy API",
                        "versionName": "1",
                        "apiVersionDescription": "Proxy API to Success Factors, there is no logic implements in MuleSoft.",
                        "apiId": 54473539,
                        "apiVersionId": 3517339,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/APPS_CP_HR/successfactors",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-09-26T08:13:43.242Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "tanetg"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Change Demo-v1-ACC": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Change Demo",
                        "versionName": "v1-ACC",
                        "apiVersionDescription": "",
                        "apiId": 18285320,
                        "apiVersionId": 308402,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-30T12:04:19.723Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Change Demo-v1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Change Demo",
                        "versionName": "v1",
                        "apiVersionDescription": null,
                        "apiId": 18285320,
                        "apiVersionId": 306752,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-30T08:46:09.984Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "SIV Demo-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "SIV Demo",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 18429531,
                        "apiVersionId": 316556,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "http://0.0.0.0/ais/sivdemo",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-31T04:11:07.476Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Morneau Shepell API-v1-DEV": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": true,
                        "policiesApplied": [
                            "Cross-Origin resource sharing",
                            "Kerberos Authentication"
                        ],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Morneau Shepell API",
                        "versionName": "v1-DEV",
                        "apiVersionDescription": null,
                        "apiId": 28597229,
                        "apiVersionId": 1456387,
                        "portalId": null,
                        "apiVersionProxyEndpointId": "https://0.0.0.0/APPS_TECH_AIS/MorneauShepell",
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-07-25T12:42:54.126Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "TGA@AP.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    },
                    "Robi_test-1": {
                        "isCloudHub": false,
                        "containsPortal": false,
                        "isSecure": false,
                        "policiesApplied": [],
                        "orgId": "d1c2cd73-22c2-47d2-8331-c034d97b7bb6",
                        "apiName": "Robi_test",
                        "versionName": "1",
                        "apiVersionDescription": null,
                        "apiId": 16919334,
                        "apiVersionId": 223173,
                        "portalId": null,
                        "apiVersionProxyEndpointId": null,
                        "apiVersionImplementationEndpoint": null,
                        "apiVersionDeployment": null,
                        "apiVersionCreationDate": "2017-05-22T07:40:51.944Z",
                        "portalIsPublic": null,
                        "apiVersionTags": [],
                        "apiOwner": [
                            "RSERFOZ@EA.XOM.com"
                        ],
                        "rootRAMLContentLength": null,
                        "portalPageCount": null
                    }
                }
            ],
            "numberOfAPIDefinitions": 28,
            "numberOfActiveAPIsInDev": 0,
            "numberOfActiveAPIsInAcceptance": 0,
            "numberOfActiveAPIsInProd": 0,
            "devAPIsOnPrem": 0,
            "devAPIsInCloud": 0,
            "acceptanceAPIsOnPrem": 0,
            "acceptanceAPIsInCloud": 0,
            "prodAPIsOnPrem": 0,
            "prodAPIsInCloud": 0,
            "totalNumberOfUnsecureAPIs": 19,
            "totalNumberOfUndocumentedAPIs": 19,
            "policiesBeingUsed": [
                "Client ID enforcement",
                "Auth0 JWT Token Validation Policy",
                "Cross-Origin resource sharing",
                "Kerberos Authentication"
            ]
        },
        {
            "businessOrgName": "CLOUD-INT-OP",
            "businessOrgId": "205fcee8-689a-4cc2-a9d4-3f0ca772bc9d",
            "processedCalls": 0,
            "blockedCalls": 0,
            "apiVersions": [
                {}
            ],
            "numberOfAPIDefinitions": 0,
            "numberOfActiveAPIsInDev": 0,
            "numberOfActiveAPIsInAcceptance": 0,
            "numberOfActiveAPIsInProd": 0,
            "devAPIsOnPrem": 0,
            "devAPIsInCloud": 0,
            "acceptanceAPIsOnPrem": 0,
            "acceptanceAPIsInCloud": 0,
            "prodAPIsOnPrem": 0,
            "prodAPIsInCloud": 0,
            "totalNumberOfUnsecureAPIs": 0,
            "totalNumberOfUndocumentedAPIs": 0,
            "policiesBeingUsed": []
        }
    ]
}
```
</p></details>

# Config.properties - Please fill the properties file (under src/main/resources) with appropriate values

```
anypointUsername=<anypoint platform username>
anypointPassword=<anypoint platform password>
rootOrgId=<plugin the root organization Id>
devEnvironmentId=<id of the dev environment>
acceptanceEnvironmentId=<id of the acceptance environment>
prodEnvironmentId=<id of the production environment>

anypoint.accountsApi.uri=accounts/api/organizations
anypoint.apiplatform.uri=apiplatform/repository/v2/organizations
anypoint.analytics.uri=analytics/1.0
anypoint.exchange.uri=exchange/api/v1/assets
anypoint.hybrid.uri=hybrid/api/v1/applications
anypoint.cloudhub.uri=cloudhub/api/applications
```

