package com.xiter.igou.model;


/**
 * Description:商品实体
 * 
 * @author liufeihua
 * @date 2014-11-18下午4:19:35
 * @version 1.0
 * 
 */
public class Goods implements java.io.Serializable {

	private String id;
	private String shopId;
	private String code;
	private String name;
	private String thumbnail;
	private String price;
	private String weight;
	private String color;
	private String factoryAddr;
	private String producer;
	private String productedDate;
	private String registerDate;
	private String isHost;
	private String describes;

	public Goods() {
	}

	public Goods(String shopId, String code, String name, String thumbnail,
			String price, String weight, String color, String factoryAddr,
			String producer, String productedDate, String registerDate,
			String isHost, String describes) {
		this.shopId = shopId;
		this.code = code;
		this.name = name;
		this.thumbnail = thumbnail;
		this.price = price;
		this.weight = weight;
		this.color = color;
		this.factoryAddr = factoryAddr;
		this.producer = producer;
		this.productedDate = productedDate;
		this.registerDate = registerDate;
		this.isHost = isHost;
		this.describes = describes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFactoryAddr() {
		return factoryAddr;
	}

	public void setFactoryAddr(String factoryAddr) {
		this.factoryAddr = factoryAddr;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getProductedDate() {
		return productedDate;
	}

	public void setProductedDate(String productedDate) {
		this.productedDate = productedDate;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getIsHost() {
		return isHost;
	}

	public void setIsHost(String isHost) {
		this.isHost = isHost;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", shopId=" + shopId + ", code=" + code
				+ ", name=" + name + ", thumbnail=" + thumbnail + ", price="
				+ price + ", weight=" + weight + ", color=" + color
				+ ", factoryAddr=" + factoryAddr + ", producer=" + producer
				+ ", productedDate=" + productedDate + ", registerDate="
				+ registerDate + ", isHost=" + isHost + ", describes="
				+ describes + "]";
	}

}
