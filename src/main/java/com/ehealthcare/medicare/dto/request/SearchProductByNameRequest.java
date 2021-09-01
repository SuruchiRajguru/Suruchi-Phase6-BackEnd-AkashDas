package com.ehealthcare.medicare.dto.request;

public class SearchProductByNameRequest {
	private String searchText;

	public SearchProductByNameRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchProductByNameRequest(String searchText) {
		super();
		this.searchText = searchText;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "SearchProductByNameRequest [searchText=" + searchText + "]";
	}
	
	
}
