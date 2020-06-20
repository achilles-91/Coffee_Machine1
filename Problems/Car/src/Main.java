import java.util.Date;

class Car {


    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(Car.lastCreated);

        Car car1 = new Car();
        System.out.println(Car.lastCreated);


        Car car2 = new Car();
        System.out.println(Car.lastCreated);

        Car car3 = new Car();
        System.out.println(Car.lastCreated);
    }


    int yearModel;
    String make;
    int speed;
    static Date lastCreated;

    public Car() {
        this.lastCreated = new Date();
    }

    public void accelerate() {
        this.speed += 5;
    }

    public void brake() {
        this.speed -= 5;
        if (speed < 0) {
            speed = 0;
        }
    }
}