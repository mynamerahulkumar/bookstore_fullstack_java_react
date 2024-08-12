package com.book.bookstoreonline.utils;

public class Vehicle {
    int wheels;
    int doors;
    int seats;
    public  void setNumberOFwheels(int wheels){
        this.wheels=wheels;
    }
    public void setNumberOFdoors(int doors){
        this.doors=doors;
    }
    public static void main(String[] args) {
        Vehicle car=new Vehicle();
        car.setNumberOFwheels(4);
        car.setNumberOFdoors(4);
        Vehicle truck=new Vehicle();
        truck.setNumberOFdoors(2);
        truck.setNumberOFwheels(12);
        System.out.println(car.wheels);
        System.out.println(car.doors);
        System.out.println(truck.wheels);
        System.out.println(truck.doors);
    }
}
