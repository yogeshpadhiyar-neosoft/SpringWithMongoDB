package com.neosoft.springMongo.constant;

public class Regex {
    public final static String USERNAME="^[a-z][a-z0-9]{5,15}$";
    public final static String EMAIL_ID="^([a-z0-9_\\-\\.]+)@([a-z0-9_\\-\\.]+)\\.([a-z]{2,5})$";
    public final static String PASSWORD="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[&@#$%]).{8,20})";
    public final static String MOBILE_NO="^[1-9][0-9]{9}$";
    public final static String PIN_CODE="^\\w\\w\\w\\w\\w\\w$";
}
