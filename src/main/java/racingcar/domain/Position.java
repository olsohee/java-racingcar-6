package racingcar.domain;

public class Position implements Comparable<Position> {

    private int position;

    public Position() {
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position other) {
        return this.position - other.position;
    }
}
