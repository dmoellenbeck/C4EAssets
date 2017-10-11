package com.xom.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessOrg {
	
	private String businessOrgName;
	private String businessOrgId;
	private Long processedCalls;
	private Long blockedCalls;
	private ArrayList<HashMap<String,Api>> apiVersions;
	private int numberOfAPIDefinitions;
	private int numberOfActiveAPIsInDev;
	private int numberOfActiveAPIsInAcceptance;
	private int numberOfActiveAPIsInProd;
	private int devAPIsOnPrem;
	private int devAPIsInCloud;
	private int acceptanceAPIsOnPrem;
	private int acceptanceAPIsInCloud;
	private int prodAPIsOnPrem;
	private int prodAPIsInCloud;
	private int totalNumberOfUnsecureAPIs;
	private int totalNumberOfUndocumentedAPIs;
	private ArrayList<String> policiesBeingUsed;
	public ArrayList<String> getPoliciesBeingUsed() {
		return policiesBeingUsed;
	}
	public void setPoliciesBeingUsed(ArrayList<String> policiesBeingUsed) {
		this.policiesBeingUsed = policiesBeingUsed;
	}
	public String getBusinessOrgName() {
		return businessOrgName;
	}
	public void setBusinessOrgName(String businessOrgName) {
		this.businessOrgName = businessOrgName;
	}
	public String getBusinessOrgId() {
		return businessOrgId;
	}
	public void setBusinessOrgId(String businessOrgId) {
		this.businessOrgId = businessOrgId;
	}
	public Long getProcessedCalls() {
		return processedCalls;
	}
	public void setProcessedCalls(Long processedCalls) {
		this.processedCalls = processedCalls;
	}
	public Long getBlockedCalls() {
		return blockedCalls;
	}
	public void setBlockedCalls(Long blockedCalls) {
		this.blockedCalls = blockedCalls;
	}
	public ArrayList<HashMap<String, Api>> getApiVersions() {
		return apiVersions;
	}
	public void setApiVersions(ArrayList<HashMap<String, Api>> apiVersions) {
		this.apiVersions = apiVersions;
	}
	public int getNumberOfAPIDefinitions() {
		return numberOfAPIDefinitions;
	}
	public void setNumberOfAPIDefinitions(int numberOfAPIDefinitions) {
		this.numberOfAPIDefinitions = numberOfAPIDefinitions;
	}
	public int getNumberOfActiveAPIsInDev() {
		return numberOfActiveAPIsInDev;
	}
	public void setNumberOfActiveAPIsInDev(int numberOfActiveAPIsInDev) {
		this.numberOfActiveAPIsInDev = numberOfActiveAPIsInDev;
	}
	public int getNumberOfActiveAPIsInAcceptance() {
		return numberOfActiveAPIsInAcceptance;
	}
	public void setNumberOfActiveAPIsInAcceptance(int numberOfActiveAPIsInAcceptance) {
		this.numberOfActiveAPIsInAcceptance = numberOfActiveAPIsInAcceptance;
	}
	public int getNumberOfActiveAPIsInProd() {
		return numberOfActiveAPIsInProd;
	}
	public void setNumberOfActiveAPIsInProd(int numberOfActiveAPIsInProd) {
		this.numberOfActiveAPIsInProd = numberOfActiveAPIsInProd;
	}
	public int getDevAPIsOnPrem() {
		return devAPIsOnPrem;
	}
	public void setDevAPIsOnPrem(int devAPIsOnPrem) {
		this.devAPIsOnPrem = devAPIsOnPrem;
	}
	public int getDevAPIsInCloud() {
		return devAPIsInCloud;
	}
	public void setDevAPIsInCloud(int devAPIsInCloud) {
		this.devAPIsInCloud = devAPIsInCloud;
	}
	public int getAcceptanceAPIsOnPrem() {
		return acceptanceAPIsOnPrem;
	}
	public void setAcceptanceAPIsOnPrem(int acceptanceAPIsOnPrem) {
		this.acceptanceAPIsOnPrem = acceptanceAPIsOnPrem;
	}
	public int getAcceptanceAPIsInCloud() {
		return acceptanceAPIsInCloud;
	}
	public void setAcceptanceAPIsInCloud(int acceptanceAPIsInCloud) {
		this.acceptanceAPIsInCloud = acceptanceAPIsInCloud;
	}
	public int getProdAPIsOnPrem() {
		return prodAPIsOnPrem;
	}
	public void setProdAPIsOnPrem(int prodAPIsOnPrem) {
		this.prodAPIsOnPrem = prodAPIsOnPrem;
	}
	public int getProdAPIsInCloud() {
		return prodAPIsInCloud;
	}
	public void setProdAPIsInCloud(int prodAPIsInCloud) {
		this.prodAPIsInCloud = prodAPIsInCloud;
	}
	public int getTotalNumberOfUnsecureAPIs() {
		return totalNumberOfUnsecureAPIs;
	}
	public void setTotalNumberOfUnsecureAPIs(int totalNumberOfUnsecureAPIs) {
		this.totalNumberOfUnsecureAPIs = totalNumberOfUnsecureAPIs;
	}
	public int getTotalNumberOfUndocumentedAPIs() {
		return totalNumberOfUndocumentedAPIs;
	}
	public void setTotalNumberOfUndocumentedAPIs(int totalNumberOfUndocumentedAPIs) {
		this.totalNumberOfUndocumentedAPIs = totalNumberOfUndocumentedAPIs;
	}
	
	

}
