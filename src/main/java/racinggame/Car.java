package racinggame;

import nextstep.utils.Randoms;

public class Car {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int NUMBER_TO_MOVE = 4;

    private String carName;
    private int countOfMoves;

    public Car(String carName) {
        this.carName = carName;
        this.countOfMoves = 0;
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
