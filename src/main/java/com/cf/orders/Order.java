package com.cf.orders;

import org.springframework.stereotype.Component;

@Component
public class Order {

    private int id;
    private int address_id;
    private int product_id;
    private String phone;
    private String delivery_status;
    private String order_status;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
