package com.example.saad.traveljournal;

/**
 * Created by saad on 30/10/2018.
 */

public class ProfileInfo {

    private String Uid;
    private String Key;
    private String Name;
    private String Age;
    private String City;
    private String Country;
    private String Phone;

    public ProfileInfo() {

    }

    public ProfileInfo(String uid, String key, String name, String age, String city, String country, String phone) {
        Uid = uid;
        Key = key;
        Name = name;
        Age = age;
        City = city;
        Country = country;
        Phone = phone;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
