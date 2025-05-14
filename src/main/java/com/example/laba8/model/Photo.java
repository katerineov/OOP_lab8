package com.example.laba8.model;

public class Photo {
    private String Name;
    private String PhoneNumber;
    private String RentDate;
    private String ProductName;
    private double Price;
    private String Duration;

    public Photo() {}

    public Photo(String Name, String PhoneNumber, String RentDate,
                 String ProductName, double Price, String Duration) {
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.RentDate = RentDate;
        this.ProductName = ProductName;
        this.Price = Price;
        this.Duration = Duration;
    }

    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }
    public String getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(String PhoneNumber) { this.PhoneNumber = PhoneNumber; }
    public String getRentDate() { return RentDate; }
    public void setRentDate(String RentDate) { this.RentDate = RentDate; }
    public String getProductName() { return ProductName; }
    public void setProductName(String ProductName) { this.ProductName = ProductName; }
    public double getPrice() { return Price; }
    public void setPrice(double Price) { this.Price = Price; }
    public String getDuration() { return Duration; }
    public void setDuration(String Duration) { this.Duration = Duration; }
}