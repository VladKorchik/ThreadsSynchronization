package ru.netology;

public class Seller {
    private AutoShop autoShop;
    final int deliveryTime = 1000;
    final int clientWaitingTime = 500;

    public Seller(AutoShop autoShop) {
        this.autoShop = autoShop;
    }

    public void recieveCar() {
        try {
            Thread.sleep(deliveryTime);
            synchronized (this) {
                System.out.println("Выполняется поставка...");
                autoShop.getCars().add(new Car());
                notify();
            }
            System.out.println("С завода приехал новенький авто.");

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public Car sellCar() {
        System.out.println(Thread.currentThread().getName() + " зашёл в салон, хочет купить Солярис...");
        synchronized (this) {
            try {
                if (autoShop.getCars().isEmpty()) {
                    System.out.println("Автомобилей пока нет в наличии. Ждём поставку.");
                    wait();
                }
                //Thread.sleep(clientWaitingTime);
                System.out.println("Поздравляем с покупкой, " + Thread.currentThread().getName() + " ! Хотите защиту радиатора " +
                        "за 15 тысяч рублей и каско за 90 тысяч рублей?");
            } catch (InterruptedException exception) {
                exception.printStackTrace();

                return autoShop.getCars().remove(0);
            }
        }
        return autoShop.getCars().remove(0);
    }
}