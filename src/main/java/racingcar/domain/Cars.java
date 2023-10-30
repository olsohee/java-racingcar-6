package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(String inputNames) {
        String[] splitNames = inputNames.split(",", -1);
        validateBlank(splitNames);

        String[] trimNames = trimNames(splitNames);
        validateDuplicateName(trimNames);

        cars = Arrays.stream(trimNames)
                .map(name -> new Car(name))
                .toList();
    }

    private void validateBlank(String[] names) {
        boolean hasBlank = Arrays.stream(names)
                .filter(name -> StringUtils.isBlank(name))
                .findFirst()
                .isPresent();
        if (hasBlank) {
            throw new IllegalArgumentException();
        }
    }

    private String[] trimNames(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .toArray(String[]::new);
    }

    private void validateDuplicateName(String[] names) {
        Set<String> notDuplicateNames = new HashSet<>();
        Arrays.stream(names)
                .forEach(name -> notDuplicateNames.add(name));

        if (notDuplicateNames.size() != names.length) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        cars.stream()
                .forEach(Car::play);
    }

    public List<String> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findMaxPositionCarList(maxPositionCar);
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private List<String> findMaxPositionCarList(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> maxPositionCar.isSamePosition(car))
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
