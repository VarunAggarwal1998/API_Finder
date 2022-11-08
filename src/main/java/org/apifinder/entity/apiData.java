package org.apifinder.entity;

public class apiData {
	
	private int apiId;
	private String api;
	private String description;
	private String auth;
	private String https;
	private String cors;
	private String link;
	private String category;
	
	public apiData(int apiId, String api, String description, String auth, String https, String cors, String link,
			String category) {
		super();
		this.apiId = apiId;
		this.api = api;
		this.description = description;
		this.auth = auth;
		this.https = https;
		this.cors = cors;
		this.link = link;
		this.category = category;
	}
	
	public apiData(String api,String description, String auth, String https, String cors, String link, String category) {
		super();
		this.api = api;
		this.description = description;
		this.auth = auth;
		this.https = https;
		this.cors = cors;
		this.link = link;
		this.category = category;
	}
	
	public int getApiId() {
		return apiId;
	}
	public void setApiId(int apiId) {
		this.apiId = apiId;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getHttps() {
		return https;
	}
	public void setHttps(String https) {
		this.https = https;
	}
	public String getCors() {
		return cors;
	}
	public void setCors(String cors) {
		this.cors = cors;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	public String toString() {
		return "apiData [apiId=" + apiId + ", api=" + api + ", description=" + description + ", auth=" + auth
				+ ", https=" + https + ", cors=" + cors + ", link=" + link + ", category=" + category + "]";
	}
	
	
	
}

