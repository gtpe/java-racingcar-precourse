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

    public List<Car> getCars() {
        return cars;
    }

    public void executeOneRound() {
        for (Car car : cars) {
            car.executeMoveOrNot();
        }
    }

    public String pickWinner() {
        return getMaxCountCarNames(getMaxCountOfMoves());
    }

    private String getMaxCountCarNames(int maxCountOfMoves) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCountOfMoves() == maxCountOfMoves) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(cars.get(i).getCarName());
            }
        }
        return sb.toString();
    }

    private int getMaxCountOfMoves() {
        int maxCountOfMoves = 0;
        for (Car car : cars) {
            if(car.getCountOfMoves() > maxCountOfMoves) {
                maxCountOfMoves = car.getCountOfMoves();
            }
        }
        return maxCountOfMoves;
    }

}
