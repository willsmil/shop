package com.shop.model.domain;

import java.util.Date;

public class Order_form {
  private Long order_form_id;
  private Long goods_id;
  private Long user_id;
  private Long solder_id;
  private Double unit_price;
  private Long buy_number;
  private Long address_id;
  private String phone;
  private Date date;
  private boolean pay_state;
  private int shipping_state;

  public Long getOrder_form_id() {
    return order_form_id;
  }

  public void setOrder_form_id(Long order_form_id) {
    this.order_form_id = order_form_id;
  }

  public Long getGoods_id() {
    return goods_id;
  }

  public void setGoods_id(Long goods_id) {
    this.goods_id = goods_id;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Long getSolder_id() {
    return solder_id;
  }

  public void setSolder_id(Long solder_id) {
    this.solder_id = solder_id;
  }

  public Double getUnit_price() {
    return unit_price;
  }

  public void setUnit_price(Double unit_price) {
    this.unit_price = unit_price;
  }

  public Long getBuy_number() {
    return buy_number;
  }

  public void setBuy_number(Long buy_number) {
    this.buy_number = buy_number;
  }

  public Long getAddress_id() {
    return address_id;
  }

  public void setAddress_id(Long address_id) {
    this.address_id = address_id;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public boolean getPay_state() {
    return pay_state;
  }

  public void setPay_state(boolean pay_state) {
    this.pay_state = pay_state;
  }

  public boolean isPay_state() {
    return pay_state;
  }

  public int getShipping_state() {
    return shipping_state;
  }

  public void setShipping_state(int shipping_state) {
    this.shipping_state = shipping_state;
  }
}
