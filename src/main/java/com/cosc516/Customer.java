package com.cosc516;

public class Customer {
    private String id;
    private Integer c_custkey;
    private String c_name;
    private String c_address;
    private Integer c_nationkey;
    private String c_phone;
    private Double c_acctbal;
    private String c_mktsegment;
    private String c_comment;

    public Customer() {
    }

    public Customer(Integer c_custkey, String c_name, String c_address, Integer c_nationkey, String c_phone,
            Double c_acctbal, String c_mktsegment, String c_comment) {
        this.c_custkey = c_custkey;
        this.c_name = c_name;
        this.c_address = c_address;
        this.c_nationkey = c_nationkey;
        this.c_phone = c_phone;
        this.c_acctbal = c_acctbal;
        this.c_mktsegment = c_mktsegment;
        this.c_comment = c_comment;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getC_custkey() {
        return this.c_custkey;
    }

    public void setC_custkey(Integer c_custkey) {
        this.c_custkey = c_custkey;
    }

    public String getC_name() {
        return this.c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_address() {
        return this.c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public Integer getC_nationkey() {
        return this.c_nationkey;
    }

    public void setC_nationkey(Integer c_nationkey) {
        this.c_nationkey = c_nationkey;
    }

    public String getC_phone() {
        return this.c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public Double getC_acctbal() {
        return this.c_acctbal;
    }

    public void setC_acctbal(Double c_acctbal) {
        this.c_acctbal = c_acctbal;
    }

    public String getC_mktsegment() {
        return this.c_mktsegment;
    }

    public void setC_mktsegment(String c_mktsegment) {
        this.c_mktsegment = c_mktsegment;
    }

    public String getC_comment() {
        return this.c_comment;
    }

    public void setC_comment(String c_comment) {
        this.c_comment = c_comment;
    }
}