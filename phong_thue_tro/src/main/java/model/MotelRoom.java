package model;

public class MotelRoom {
    private int id;
    private String name;
    private int phoneNumber;
    private String rentalStartDate;
    private String payments;

    public MotelRoom() {
    }

    public MotelRoom(int id, String name, int phoneNumber, String rentalStartDate, String payments) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rentalStartDate = rentalStartDate;
        this.payments = payments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(String rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }
}