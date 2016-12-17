package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SearchResult implements Serializable{

	private List<SearchItem> itemList;
	private List<Map> categoryList;
	private List<Map> priceRange;
	private long recordCount;
	private long totalPage;
	public List<SearchItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<Map> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Map> categoryList) {
		this.categoryList = categoryList;
	}
	public List<Map> getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(List<Map> priceRange) {
		this.priceRange = priceRange;
	}
}
