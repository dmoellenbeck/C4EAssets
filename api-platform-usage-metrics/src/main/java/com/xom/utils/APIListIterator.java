package com.xom.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class APIListIterator implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		@SuppressWarnings("unchecked")
		HashMap<String,Object> payload =  (HashMap<String, Object>) message.getPayload();
		ArrayList<HashMap<Integer,HashMap<String,Object>>> apiVersionList=new ArrayList<HashMap<Integer,HashMap<String,Object>>>();
		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String,Object>> apis= (ArrayList<HashMap<String, Object>>) payload.get("apis");
		for(HashMap<String,Object> api:apis){
			if(!api.isEmpty()){
				String apiName=(String) api.get("name");
				if(api.containsKey("versions")){
					@SuppressWarnings("unchecked")
					ArrayList<HashMap<String,Object>> versions=(ArrayList<HashMap<String, Object>>) api.get("versions");
					if(versions.size()>0){
						for(HashMap<String,Object> version:versions){
							loopThroughVersions(apiName,version,apiVersionList);
						}
					}
				}
			}	
		}
		message.setInvocationProperty("apiVersionIdList", apiVersionList);
 		return message;
	}

	private void loopThroughVersions(String apiName,
			HashMap<String, Object> version, ArrayList<HashMap<Integer, HashMap<String, Object>>> apiVersionList) {
		Integer apiVersionId= (Integer) version.get("id");
		Integer apiId=(Integer) version.get("apiId");
		HashMap<String,Object> apiIdMap=new HashMap<String,Object>();
		apiIdMap.put("apiId", Integer.toString(apiId));
		apiIdMap.put("apiName",apiName);
		if(version.containsKey("portal")){
			@SuppressWarnings("unchecked")
			HashMap<String,Object> isPublic=(HashMap<String, Object>) version.get("portal");
			apiIdMap.put("portalIsPublic", isPublic.get("isPublic"));
		}else{
			apiIdMap.put("portalIsPublic", null);
		}
		HashMap<Integer,HashMap<String,Object>> versionIdMap=new HashMap<Integer,HashMap<String,Object>>();
		versionIdMap.put(apiVersionId, apiIdMap);
		apiVersionList.add(versionIdMap);
	}

}
