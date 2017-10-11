package com.xom.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class APIObjectParser implements Callable{

	@SuppressWarnings("unchecked")
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message=eventContext.getMessage();
		String organizationId=null;
		String apiName=message.getInvocationProperty("apiName");
		String description=null;
		Integer portalId = null;
		String apiId=message.getInvocationProperty("apiId");
		Integer apiVersionId=message.getInvocationProperty("apiVersionId");
		String proxyUri=null;
		String endpointUri=null;
		String versionName=null;
		boolean isCloudHub=false;
		boolean isSecure=false;
		boolean containsPortal=false;
		String targetName = "";
		String environmentName = "";
		int lastActiveDelta = 20;
		String applicationName = "";
		
		ArrayList<String> devCloudhubAppNames = message.getInvocationProperty("devCloudhubAppNames");
		ArrayList<String> acceptanceCloudhubAppNames = message.getInvocationProperty("acceptanceCloudhubAppNames");
		ArrayList<String> prodCloudhubAppNames = message.getInvocationProperty("prodCloudhubAppNames");
		
		ArrayList<String> devHybridAppNames = message.getInvocationProperty("devHybridAppNames");
		ArrayList<String> acceptanceHybridAppNames = message.getInvocationProperty("acceptanceHybridAppNames");
		ArrayList<String> prodHybridAppNames = message.getInvocationProperty("prodHybridAppNames");
		
		int devApisOnPrem = message.getInvocationProperty("devApisOnPrem");
		int devApisInCloud = message.getInvocationProperty("devApisInCloud");
		
		int acceptanceApisOnPrem = message.getInvocationProperty("acceptanceApisOnPrem");
		int acceptanceApisInCloud = message.getInvocationProperty("acceptanceApisInCloud");
		
		int prodApisOnPrem = message.getInvocationProperty("prodApisOnPrem");
		int prodApisInCloud = message.getInvocationProperty("prodApisInCloud");
		
		int activeApisInDev =  message.getInvocationProperty("activeApisInDev");
		int activeApisInAcceptance =  message.getInvocationProperty("activeApisInAcceptance");
		int activeApisInProd =  message.getInvocationProperty("activeApisInProd");
		
		HashMap<String,String> policyTemplateIdNameMap = message.getInvocationProperty("policyTemplateIdNameMap");
		
		ArrayList<String> policiesApplied = new ArrayList<String>();
		HashMap<String,HashMap<String,Object>> audit = null;
		ArrayList<String> tags = null;
		Boolean portalIsPublic=message.getInvocationProperty("portalIsPublic");
		String apiVersionCreatedDate = null;
		Integer portalPageCount = message.getInvocationProperty("portalPageCount");
		String rootRAMLContentLength =message.getInvocationProperty("rootRAMLContentLength");
		ArrayList<HashMap<String,Object>> policyTemplates=message.getInvocationProperty("policyTemplates");
		if(policyTemplates.size() != 0){
			isSecure=true;
			for(HashMap<String,Object> policy:policyTemplates){
				System.out.println(policy.get("policyTemplateId").toString()+policyTemplateIdNameMap.get(policy.get("policyTemplateId")));
				policiesApplied.add(policyTemplateIdNameMap.get(policy.get("policyTemplateId")));
			}
		}
		HashMap<String,Object> versionInfo=message.getInvocationProperty("versionInfo");
		if(!versionInfo.isEmpty()){
			organizationId=(String) versionInfo.get("organizationId");
			description=(String) versionInfo.get("description");
			portalId= (Integer) versionInfo.get("portalId");
			versionName=(String) versionInfo.get("name");
			HashMap<String,Object> endpoint=(HashMap<String, Object>) versionInfo.get("endpoint");
			if(endpoint!=null){
				proxyUri=(String) endpoint.get("proxyUri");
				if(endpoint.get("isCloudHub") != null){
				isCloudHub =   ((Boolean) endpoint.get("isCloudHub")).booleanValue();
				}
			}
			endpointUri=(String) versionInfo.get("endpointUri");
			HashMap<String,Object> deployment=(HashMap<String, Object>) versionInfo.get("deployment");
			if (versionInfo.containsKey("lastActiveDelta") && versionInfo.get("lastActiveDelta")!=null){
				lastActiveDelta = Integer.parseInt(versionInfo.get("lastActiveDelta").toString());
			}
			if(deployment!=null){
				applicationName = deployment.get("applicationName").toString();
				if(devCloudhubAppNames.contains(applicationName)){
					activeApisInDev++;
					devApisInCloud++;
				} else if(acceptanceCloudhubAppNames.contains(applicationName)){
					activeApisInAcceptance++;
					acceptanceApisInCloud++;
				} else if(prodCloudhubAppNames.contains(applicationName)){
					activeApisInProd++;
					prodApisInCloud++;
				} else if(devHybridAppNames.contains(applicationName)){
					activeApisInDev++;
					devApisOnPrem++;
				} else if(acceptanceHybridAppNames.contains(applicationName)){
					activeApisInAcceptance++;
					acceptanceApisOnPrem++;
				} else if(prodHybridAppNames.contains(applicationName)){
					activeApisInProd++;
					prodApisOnPrem++;
				} else {
					System.out.println("application name: "+ applicationName + " with versionId: "+ apiVersionId + " and apiId: "+apiId + " not active");
				}
			}
//				if(deployment.get("targetName")!=null){
//					targetName = deployment.get("targetName").toString();
//				}
//				if(deployment.get("environmentName")!=null){
//					environmentName = deployment.get("environmentName").toString();
//				}
//				System.out.println("targetName:"+targetName + "\t"+"environmentName:"+environmentName + "\t" + "lastActiveDelta:"+lastActiveDelta);
//			if((targetName.equals("DevelopmentOnPrem") || environmentName.equals("Development"))){
//				if(lastActiveDelta < 20){
//					activeApisInDev++;
//					if(deployment.get("type").equals("HY")){
//						devApisOnPrem++;
//					}else if(deployment.get("type").equals("CH")){
//						devApisInCloud++;
//					} else {
//						System.out.println("Unknown deployment type : "+ deployment.get("type"));
//					}
//				}
//				
//			} else if((targetName.equals("AcceptanceOnPrem") || environmentName.equals("Acceptance"))){
//				if(lastActiveDelta < 20){
//					activeApisInAcceptance++;
//					if(deployment.get("type").equals("HY")){
//						acceptanceApisOnPrem++;
//					}else if(deployment.get("type").equals("CH")){
//						acceptanceApisInCloud++;
//					} else {
//						System.out.println("Unknown deployment type : "+ deployment.get("type"));
//					}
//				}
//				
//			} else if((targetName.equals("ProductionOnPrem") || environmentName.equals("Production"))){
//				if(lastActiveDelta < 20){
//					activeApisInProd++;
//					if(deployment.get("type").equals("HY")){
//						prodApisOnPrem++;
//					}else if(deployment.get("type").equals("CH")){
//						prodApisInCloud++;
//					} else {
//						System.out.println("Unknown deployment type : "+ deployment.get("type"));
//					}
//				}
//			} else {
//					System.out.println("Unknown Environment Context : "+ "targetName: "+deployment.get("targetName").toString() + " environmentName: "+deployment.get("environmentName").toString());
//			}
//			}
			audit=(HashMap<String, HashMap<String, Object>>) versionInfo.get("audit");
			tags = (ArrayList<String>) versionInfo.get("tags");
			if(audit.containsKey("created")){
				apiVersionCreatedDate=((String) audit.get("created").get("date"));
			}
		}
		List<HashMap<String,Object>> ownerInfo=message.getInvocationProperty("ownerInfo");
		ArrayList<String> owners = new ArrayList<String>();
		if(ownerInfo.size()>0){
			for(HashMap<String,Object> owner:ownerInfo){
				if(owner.containsKey("username")){
				owners.add(owner.get("username").toString());
				}
			}
		}
		if(portalId != null){
			containsPortal = true;
		}
		Api api = new Api(organizationId,apiName,description,versionName,Integer.valueOf(apiId),apiVersionId,portalId,proxyUri,endpointUri,null,apiVersionCreatedDate,portalIsPublic,tags,owners,rootRAMLContentLength,portalPageCount,isCloudHub,isSecure, policiesApplied,containsPortal);
		HashMap<String,Api> finalListOfAPIs=message.getInvocationProperty("finalListOfAPIs");
		finalListOfAPIs.put(apiName+"-"+versionName,api);
		message.setInvocationProperty("finalListOfAPIs", finalListOfAPIs);
		message.setInvocationProperty("devApisOnPrem", devApisOnPrem);
		message.setInvocationProperty("devApisInCloud", devApisInCloud);
		message.setInvocationProperty("acceptanceApisOnPrem", acceptanceApisOnPrem);
		message.setInvocationProperty("acceptanceApisInCloud", acceptanceApisInCloud);
		message.setInvocationProperty("prodApisOnPrem", prodApisOnPrem);
		message.setInvocationProperty("prodApisInCloud", prodApisInCloud);
		message.setInvocationProperty("activeApisInDev", activeApisInDev);
		message.setInvocationProperty("activeApisInAcceptance", activeApisInAcceptance);
		message.setInvocationProperty("activeApisInProd", activeApisInProd);
		return message;
	}

}
