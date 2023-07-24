package bean;

import java.util.List;

public class Menu implements java.io.Serializable{
	//InvalidClassException(エラー)が出ないようにするために宣言している
	private static final long serialVersionUID = 1L;
	
	private String ranking;
	private String name;
	private String kcal;
	private String price;
	private String count;
	private List<Menu> menulist;
	
	private static final int _RNAKING = 0;
	private static final int _NAME = 1;
	private static final int _KCAL = 2;
	private static final int _PRICE = 3;
	private static final int _COUNT = 4;


	public Menu() {
		super();
	}

	public Menu(String ranking, String name, String kcal, String price, String count) {
		this.ranking = ranking;
		this.name = name;
		this.kcal = kcal.replace("\"", "");
		this.price = price.replace("\"", "");
		this.count = count;
	}

	public Menu(String[] csvColumns) {
		this(csvColumns[_RNAKING], csvColumns[_NAME], csvColumns[_KCAL], csvColumns[_PRICE], csvColumns[_COUNT]);
	}
	
	public List<Menu> getMenulist() {
		return menulist;
	}
	public void setMenulist(List<Menu> menulist) {
		this.menulist = menulist;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKcal() {
		return kcal;
	}
	public void setKcal(String kcal) {
		this.kcal = kcal;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
