package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String CAR_SEPARATOR = ",";

    private List<Car> cars;

    public Cars(String carNames) {
        cars = new ArrayList<>();
        makeCarArray(carNames);
    }

    private void makeCarArray(String carNames) {
        String[] carNameArray = carNames.split(CAR_SEPARATOR);
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    public void executeOneRound() {
        for (Car car : cars) {
            car.executeMoveOrNot();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
