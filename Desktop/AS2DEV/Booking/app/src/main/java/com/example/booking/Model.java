package com.example.booking;

public class Model {
    private String id,name,mail,ph,address,pin,inDate,outDate,country,Other,adultsNumber,childsNumber,roomtype;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }

    public String getAdultsNumber() {
        return adultsNumber;
    }

    public void setAdultsNumber(String adultsNumber) {
        this.adultsNumber = adultsNumber;
    }

    public String getChildsNumber() {
        return childsNumber;
    }

    public void setChildsNumber(String childsNumber) {
        this.childsNumber = childsNumber;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public Model(String id, String name, String mail, String ph, String address, String pin, String inDate, String outDate, String country, String other, String adultsNumber, String childsNumber, String roomtype) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.ph = ph;
        this.address = address;
        this.pin = pin;
        this.inDate = inDate;
        this.outDate = outDate;
        this.country = country;
        Other = other;
        this.adultsNumber = adultsNumber;
        this.childsNumber = childsNumber;
        this.roomtype = roomtype;
    }
}
