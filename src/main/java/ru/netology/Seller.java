package ru.netology;

public class Seller {
    private AutoShop autoShop;
    final int deliveryTime = 1000;
    final int clientWaitingTime = 500;

    public Seller(AutoShop autoShop) {
        this.autoShop = autoShop;
    }

    public synchronized void recieveCar() {
        try {
            System.out.println("Солярисов нет, ждём поставки.");
            autoShop.getCars().add(new Car());
            Thread.sleep(deliveryTime);
            System.out.println("С завода приехал новенький авто.");
            notify();
        }   catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public synchronized Car sellCar(){
        try {
            System.out.println( Thread.currentThread().getName() + " зашёл в салон, хочет купить Солярис...");
            while (autoShop.getCars().size() == 0) {
                System.out.println("Не могу продать Солярис, ждём поставки...");
                wait();
            }
            Thread.sleep(clientWaitingTime);
            System.out.println("Поздравляем с покупкой, " + Thread.currentThread().getName() +  " ! Хотите защиту радиатора " +
                    "за 15 тысяч рублей и каско за 90 тысяч рублей?");
        }   catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return autoShop.getCars().remove(0);
    }
}
