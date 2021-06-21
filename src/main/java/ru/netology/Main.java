package ru.netology;

public class Main {

    public static void main(String[] args) {

        final AutoShop shop = new AutoShop();

        for (int i = 0 ; i < 10 ; i++ ) {
            new Thread(null, shop::sellCar, "Покупатель " + i).start();
            new Thread(null, shop::recieveCar, "Поставшик авто").start();
        }
    }
}
