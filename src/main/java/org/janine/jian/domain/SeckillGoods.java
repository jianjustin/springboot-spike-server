package org.janine.jian.domain;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 秒杀商品信息
 * @author jian
 *
 */
public class SeckillGoods {
	
	private BigDecimal id;
	private BigDecimal goods_id;
	private double seckill_price;
	private int stock_count;
	private Date start_date;
	private Date end_date;
	private int version;
	
	//商品主信息
	private String goods_name;
	private String goods_title;
	private String goods_img;
	private String goods_detail;
	private double goods_price;
	private int goods_stock;
	private Date create_date;
	private Date update_date;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(BigDecimal goods_id) {
		this.goods_id = goods_id;
	}
	public double getSeckill_price() {
		return seckill_price;
	}
	public void setSeckill_price(double seckill_price) {
		this.seckill_price = seckill_price;
	}
	public int getStock_count() {
		return stock_count;
	}
	public void setStock_count(int stock_count) {
		this.stock_count = stock_count;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_title() {
		return goods_title;
	}
	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public String getGoods_detail() {
		return goods_detail;
	}
	public void setGoods_detail(String goods_detail) {
		this.goods_detail = goods_detail;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_stock() {
		return goods_stock;
	}
	public void setGoods_stock(int goods_stock) {
		this.goods_stock = goods_stock;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	

}
