package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class AutoShop {

    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>(5);

    public Car sellCar() {
        return seller.sellCar();
    }

    public void recieveCar() {
        seller.recieveCar();
    }

    List<Car> getCars() {
        return cars;
    }

}
