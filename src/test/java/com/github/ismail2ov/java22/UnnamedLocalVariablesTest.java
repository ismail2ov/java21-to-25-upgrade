package com.github.ismail2ov.java22;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class UnnamedLocalVariablesTest {

    static List<Caller> everyFifthCaller(Queue<Caller> q, int prizes) {
        var winners = new ArrayList<Caller>();
        try {
            while (prizes > 0) {
                Caller _ = q.remove();
                Caller _ = q.remove();
                Caller _ = q.remove();
                Caller _ = q.remove();
                Caller winner = q.remove();
                winners.add(winner);
                prizes--;
            }
        } catch (NoSuchElementException _) {
            // Do nothing
        }
        return winners;
    }

    record Caller(String phoneNumber) {

    }

    @Test
    void testEveryFifthCaller() {
        Queue<Caller> queue = new LinkedList<>();
        for (int i = 1; i <= 12; i++) {
            queue.add(new Caller("555-%04d".formatted(i)));
        }

        List<Caller> winners = everyFifthCaller(queue, 2);

        assertThat(winners)
            .hasSize(2)
            .containsExactlyInAnyOrder(new Caller("555-0005"), new Caller("555-0010"));

        List<String> remainingNumbers = queue.stream()
            .map(Caller::phoneNumber)
            .toList();

        assertThat(remainingNumbers).containsExactlyInAnyOrder("555-0011", "555-0012");
    }

}