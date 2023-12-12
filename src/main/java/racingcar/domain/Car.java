package racingcar.domain;

public class Car implements Comparable<Car> {

    private CarName carName;
    private Position position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position.move();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }
}
