package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SearchItem implements Serializable{

	private String id;
	private String item_name;
	private String ad_word;
	private double sell_price;
	private String img_url;
	private String brand_name;
	private String category_name;
	private int sell_num;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getAd_word() {
		return ad_word;
	}
	public void setAd_word(String ad_word) {
		this.ad_word = ad_word;
	}
	public double getSell_price() {
		return sell_price;
	}
	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getSell_num() {
		return sell_num;
	}
	public void setSell_num(int sell_num) {
		this.sell_num = sell_num;
	}
	
}
