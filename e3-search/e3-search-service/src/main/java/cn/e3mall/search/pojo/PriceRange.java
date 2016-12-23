package cn.e3mall.search.pojo;

public class PriceRange {

	private int min;
	private int max;
	private int gap;
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getGap() {
		return gap;
	}
	public void setGap(int gap) {
		this.gap = gap;
	}
	public PriceRange(int min, int max, int gap) {
		super();
		this.min = min;
		this.max = max;
		this.gap = gap;
	}
	public PriceRange(){
		super();
		this.min = 0;
		this.max = 0;
		this.gap = 0;
	}
}
