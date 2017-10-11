package com.xom.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class HierarchyIterator implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message=eventContext.getMessage();
		@SuppressWarnings("unchecked")
		HashMap<String,Object> payload=(HashMap<String, Object>) message.getPayload();
		HashMap<String,String> orgIdNameMap = new HashMap<String,String>();
		ArrayList<String> orgIdList=new ArrayList<String>();
		if(!(payload.isEmpty()) && payload.containsKey("id")){
			orgIdList.add(payload.get("id").toString());
			orgIdNameMap.put(payload.get("id").toString(), payload.get("name").toString());
		}
		if(payload.containsKey("subOrganizations")){
			@SuppressWarnings("unchecked")
			ArrayList<HashMap<String,Object>> subOrgs=(ArrayList<HashMap<String, Object>>) payload.get("subOrganizations");
			if(subOrgs.size()>0){
				for(HashMap<String,Object> map:subOrgs){
				loopThroughSubOrgs(map,orgIdList,orgIdNameMap);
				}
			}
		}
		message.setInvocationProperty("orgIdList", orgIdList);
		message.setInvocationProperty("orgIdNameMap", orgIdNameMap);
		return message;
	}

	private void loopThroughSubOrgs(HashMap<String,Object> map, ArrayList<String> orgIdList, HashMap<String, String> orgIdNameMap) {
		if(map.containsKey("id")){
			orgIdList.add(map.get("id").toString());
			orgIdNameMap.put(map.get("id").toString(), map.get("name").toString());
		}
		if(map.containsKey("subOrganizations")){
			@SuppressWarnings("unchecked")
			ArrayList<HashMap<String,Object>> subOrgs=(ArrayList<HashMap<String, Object>>) map.get("subOrganizations");
			if(subOrgs.size()>0){
			for(HashMap<String,Object> subOrgMap:subOrgs){
				loopThroughSubOrgs(subOrgMap,orgIdList,orgIdNameMap);
			}
			}
		}
	}

}
