package com.github.ismail2ov.java22;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class UnnamedVariablesSideEffectTest {

    static int count(Iterable<Order> orders) {
        int total = 0;
        for (Order unused : orders) {
            total++;
        }
        return total;
    }

    public record Order() {

    }

    @Test
    void testForLoopWithSideEffect() {
        List<Order> orders = List.of(new Order(), new Order(), new Order());

        int actual = count(orders);

        assertThat(actual).isEqualTo(3);
    }

}