package com.xom.utils;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class LongPrettyFormatter implements Callable {
	
	private static final Logger logger = Logger.getLogger(LongPrettyFormatter.class);


	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		Long processedCalls = message.getInvocationProperty("processedCalls");
		Long blockedCalls = eventContext.getMessage().getInvocationProperty("blockedCalls");
		logger.info("processedcalls without formatting "+processedCalls);
		logger.info("blockedCalls without formatting "+ blockedCalls);
		String formattedProcessedCalls = format(processedCalls);
		String formattedBlockedCalls = format(blockedCalls);
		message.setInvocationProperty("formattedProcessedCalls", formattedProcessedCalls);
		message.setInvocationProperty("formattedBlockedCalls", formattedBlockedCalls);
		return eventContext.getMessage();
	}
	
	
	
	private static final NavigableMap<Long, String> suffixes = new TreeMap<Long, String> ();
	static {
	  suffixes.put(1000L, "k");
	  suffixes.put(1000000L, "M");
	  suffixes.put(1000000000L, "G");
	  suffixes.put(1000000000000L, "T");
	  suffixes.put(1000000000000000L, "P");
	  suffixes.put(1000000000000000000L, "E");
	}
	
	public static String format(long value) {
		  //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
		  if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
		  if (value < 0) return "-" + format(-value);
		  if (value < 1000) return Long.toString(value); //deal with easy case

		  Entry<Long, String> e = suffixes.floorEntry(value);
		  Long divideBy = e.getKey();
		  String suffix = e.getValue();

		  long truncated = value / (divideBy / 10); //the number part of the output times 10
		  boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
		  return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
		}
	

}
