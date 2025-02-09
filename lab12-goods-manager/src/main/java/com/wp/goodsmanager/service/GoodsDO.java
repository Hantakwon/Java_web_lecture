package com.wp.goodsmanager.service;

public class GoodsDO {

	private String code;
	private String title;
	private String writer;
	private int price;
	
	public GoodsDO() {
	}

	public GoodsDO(String code, String title, String writer, int price) {
		this.code = code;
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "GoodsDO [code=" + code + ", title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	
}
