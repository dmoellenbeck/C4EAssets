package com.xom.utils;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJson implements Callable {
	
	private static final Logger logger = Logger.getLogger(ParseJson.class);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message=eventContext.getMessage();
		Long processedCalls=message.getInvocationProperty("processedCalls");
		Long blockedCalls=message.getInvocationProperty("blockedCalls");
		Long updatedProcessedCalls;
		Long updatedBlockedCalls;
		String payload=(String) message.getPayload();
		logger.info(payload);
		logger.info("currentprocessedCalls = "+processedCalls);
		logger.info("currentblockedCalls = "+blockedCalls);
		try{
		JSONObject root =new JSONObject(payload);
		JSONArray result=root.getJSONArray("response");
		if(result.length()>0){
		JSONObject response=result.getJSONObject(0);
		JSONArray requestDisposition = (JSONArray) response.get("request_disposition");
		if(requestDisposition.length()>0){
			for(int i=0;i<requestDisposition.length();i++){
				if(requestDisposition.getJSONObject(i).has("PROCESSED")){
					JSONObject processed = requestDisposition.getJSONObject(i).getJSONObject("PROCESSED");
					if(processed != null){
					updatedProcessedCalls= processedCalls + processed.getLong("count");
					message.setInvocationProperty("processedCalls",updatedProcessedCalls);
					}
				}else if(requestDisposition.getJSONObject(i).has("BLOCKED")){
					JSONObject blocked = requestDisposition.getJSONObject(i).getJSONObject("BLOCKED");
					if(blocked!=null){
					updatedBlockedCalls= blockedCalls + blocked.getLong("count");
					message.setInvocationProperty("blockedCalls",updatedBlockedCalls);
					}
				}else{
					logger.info("no route defined for payload "+payload);
				}
			}
		
		}
		}
		}catch (JSONException je){
			logger.error("error occured while parsing response "+"exception message"
					+ "is "+je.getMessage()+"exception cause is "+je.getCause()
					+"exception stacktrace is "+je.getStackTrace());
		}
		return message;
	}

}
