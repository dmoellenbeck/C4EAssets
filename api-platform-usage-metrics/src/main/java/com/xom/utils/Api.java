package com.xom.utils;

import java.io.Serializable;
import java.util.ArrayList;

public class Api implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5152855184843305813L;
	public Api(String orgId, String apiName, String apiVersionDescription, String versionName,
			Integer apiId, Integer apiVersionId, Integer portalId,
			String apiVersionProxyEndpointId,
			String apiVersionImplementationEndpoint,
			String apiVersionDeployment, String apiVersionCreationDate,
			Boolean portalIsPublic, ArrayList<String> apiVersionTags, ArrayList<String> apiOwner,String rootRAMLContentLength,Integer portalPageCount,boolean isCloudHub,boolean isSecure,ArrayList<String> policiesApplied, boolean containsPortal) {
		super();
		this.orgId = orgId;
		this.apiName = apiName;
		this.apiVersionDescription = apiVersionDescription;
		this.versionName = versionName;
		this.apiId = apiId;
		this.apiVersionId = apiVersionId;
		this.portalId = portalId;
		this.apiVersionProxyEndpointId = apiVersionProxyEndpointId;
		this.apiVersionImplementationEndpoint = apiVersionImplementationEndpoint;
		this.apiVersionDeployment = apiVersionDeployment;
		this.apiVersionCreationDate = apiVersionCreationDate;
		this.portalIsPublic = portalIsPublic;
		this.apiVersionTags = apiVersionTags;
		this.apiOwner = apiOwner;
		this.isCloudHub = isCloudHub;
		this.isSecure = isSecure;
		this.policiesApplied = policiesApplied;
		this.containsPortal = containsPortal;
	}
	private boolean isCloudHub;
	private boolean containsPortal;
	private boolean isSecure;
	private ArrayList<String> policiesApplied;
	public ArrayList<String> getPoliciesApplied() {
		return policiesApplied;
	}
	public void setPoliciesApplied(ArrayList<String> policiesApplied) {
		this.policiesApplied = policiesApplied;
	}
	public boolean getContainsPortal() {
		return containsPortal;
	}
	public void setContainsPortal(boolean containsPortal) {
		this.containsPortal = containsPortal;
	}
	public boolean getIsSecure() {
		return isSecure;
	}
	public void setIsSecure(boolean isSecure) {
		this.isSecure = isSecure;
	}
	public boolean getIsCloudHub() {
		return isCloudHub;
	}
	public void setIsCloudHub(boolean isCloudHub) {
		this.isCloudHub = isCloudHub;
	}
	private String orgId;
	private String apiName;
	private String versionName;
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	private String apiVersionDescription;
	private Integer apiId;
	private Integer apiVersionId;
	private Integer portalId;
	private String apiVersionProxyEndpointId;
	private String apiVersionImplementationEndpoint;
	private String apiVersionDeployment;
	private String apiVersionCreationDate;
	private Boolean portalIsPublic;
	private ArrayList<String> apiVersionTags;
	private ArrayList<String> apiOwner;
	private String rootRAMLContentLength;
	private Integer portalPageCount;
	public String getRootRAMLContentLength() {
		return rootRAMLContentLength;
	}
	public void setRootRAMLContentLength(String rootRAMLContentLength) {
		this.rootRAMLContentLength = rootRAMLContentLength;
	}
	public Integer getPortalPageCount() {
		return portalPageCount;
	}
	public void setPortalPageCount(Integer portalPageCount) {
		this.portalPageCount = portalPageCount;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getApiVersionDescription() {
		return apiVersionDescription;
	}
	public void setApiVersionDescription(String apiVersionDescription) {
		this.apiVersionDescription = apiVersionDescription;
	}
	public Integer getApiId() {
		return apiId;
	}
	public void setApiId(Integer apiId) {
		this.apiId = apiId;
	}
	public Integer getApiVersionId() {
		return apiVersionId;
	}
	public void setApiVersionId(Integer apiVersionId) {
		this.apiVersionId = apiVersionId;
	}
	public Integer getPortalId() {
		return portalId;
	}
	public void setPortalId(Integer portalId) {
		this.portalId = portalId;
	}
	public String getApiVersionProxyEndpointId() {
		return apiVersionProxyEndpointId;
	}
	public void setApiVersionProxyEndpointId(String apiVersionProxyEndpointId) {
		this.apiVersionProxyEndpointId = apiVersionProxyEndpointId;
	}
	public String getApiVersionImplementationEndpoint() {
		return apiVersionImplementationEndpoint;
	}
	public void setApiVersionImplementationEndpoint(
			String apiVersionImplementationEndpoint) {
		this.apiVersionImplementationEndpoint = apiVersionImplementationEndpoint;
	}
	public String getApiVersionDeployment() {
		return apiVersionDeployment;
	}
	public void setApiVersionDeployment(String apiVersionDeployment) {
		this.apiVersionDeployment = apiVersionDeployment;
	}
	public String getApiVersionCreationDate() {
		return apiVersionCreationDate;
	}
	public void setApiVersionCreationDate(String apiVersionCreationDate) {
		this.apiVersionCreationDate = apiVersionCreationDate;
	}
	public Boolean getPortalIsPublic() {
		return portalIsPublic;
	}
	public void setPortalIsPublic(Boolean portalIsPublic) {
		this.portalIsPublic = portalIsPublic;
	}
	public ArrayList<String> getApiVersionTags() {
		return apiVersionTags;
	}
	public void setApiVersionTags(ArrayList<String> apiVersionTags) {
		this.apiVersionTags = apiVersionTags;
	}
	public ArrayList<String> getApiOwner() {
		return apiOwner;
	}
	public void setApiOwner(ArrayList<String> apiOwner) {
		this.apiOwner = apiOwner;
	}
	

}
