package racinggame;

import nextstep.utils.Console;

public class Application {

    private String getProgressBar(int count) {
        if (count > 0) {
            return String.format("%" + count + "s", "").replace(' ', '-');
        }
        return "";
    }

    private void printOneRound(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + " : " + getProgressBar(car.getCountOfMoves()));
        }
        System.out.println();
    }

    private void printWinner(Cars cars) {
        System.out.println("최종 우승자는 " + cars.pickWinner() + " 입니다.");
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int inputNumberOfRounds() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int numberOfRounds = Integer.parseInt(Console.readLine());
        System.out.println();
        return numberOfRounds;
    }

    private void playRacingCar() {
        Cars cars = new Cars(inputCarNames());
        int numberOfRounds = inputNumberOfRounds();
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            cars.executeOneRound();
            printOneRound(cars);
        }
        printWinner(cars);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.playRacingCar();
    }

}
