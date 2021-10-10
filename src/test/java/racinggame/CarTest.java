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
            car.decisionToMove();
            assertThat(car.getCountOfMoves()).isEqualTo(1);
        }
    }

}
