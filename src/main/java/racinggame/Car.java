package racinggame;

import nextstep.utils.Randoms;

public class Car {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int NUMBER_TO_MOVE = 4;

    private CarName carName;
    private int countOfMoves;

    public Car(String carNameStr) {
        this.carName = new CarName(carNameStr);
        this.countOfMoves = 0;
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getCountOfMoves() {
        return countOfMoves;
    }

    public void executeMoveOrNot() {
        if (this.isTurnToMove()) {
            this.moveForward();
        }
    }

    private boolean isTurnToMove() {
        if (Randoms.pickNumberInRange(RANDOM_START, RANDOM_END) >= NUMBER_TO_MOVE) {
            return true;
        }
        return false;
    }

    private void moveForward() {
        this.countOfMoves++;
    }

}
