package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class CarTest {

    @Test
    void 자동차_1대_1번_전진() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7);
            Car car = new Car("pobi");
            car.executeMoveOrNot();
            assertThat(car.getCountOfMoves()).isEqualTo(1);
        }
    }

    @Test
    void 자동차_여러대_1번_전진() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(9, 1, 3);
            Cars cars = new Cars("john,kim,lisa");
            cars.executeOneRound();
            assertThat(cars.getCars().get(0).getCountOfMoves()).isEqualTo(1);
            assertThat(cars.getCars().get(2).getCountOfMoves()).isEqualTo(0);
        }
    }

}
