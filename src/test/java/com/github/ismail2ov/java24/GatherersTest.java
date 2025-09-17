package com.github.ismail2ov.java24;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;
import org.junit.jupiter.api.Test;

public class GatherersTest {

    private static final List<Integer> intStream = Arrays.asList(10, 8, 6, 3, 2, 40, 9, 1);

    @Test
    void testGatherersFoldConcatenation() {
        // The fold operation accumulates results
        String expected = "Paragraph 1;Paragraph 2;Paragraph 3;Paragraph 4;Paragraph 5;Paragraph 6";

        List<String> stringStream = Arrays.asList(
            "Paragraph 1", "Paragraph 2", "Paragraph 3",
            "Paragraph 4", "Paragraph 5", "Paragraph 6"
        );

        Optional<String> actual = stringStream
            .stream()
            .gather(Gatherers.fold(() -> "", (a, b) -> {
                if (a.isEmpty()) {
                    return b;
                }
                return a + ";" + b;
            }))
            .findFirst();

        assertThat(actual).contains(expected);
    }


    @Test
    void testWindowFixedToMap() {
        // A fixed window gatherer processes elements in non-overlapping groups of a fixed size

        Map<Integer, Integer> map = intStream
            .stream()
            .gather(Gatherers.windowFixed(2))
            .collect(Collectors.toMap(
                integers -> integers.get(0),
                integers -> integers.get(1)
            ));

        assertThat(map).hasSize(4);

        assertThat(map).containsExactlyInAnyOrderEntriesOf(
            Map.of(
                10, 8,
                6, 3,
                2, 40,
                9, 1
            )
        );
    }

    @Test
    void testWindowSliding2() {
        // A sliding window moves through the elements one at a time
        List<List<Integer>> sliding2 = intStream
            .stream()
            .gather(Gatherers.windowSliding(2))
            .toList();

        assertThat(sliding2).containsExactly(
            Arrays.asList(10, 8),
            Arrays.asList(8, 6),
            Arrays.asList(6, 3),
            Arrays.asList(3, 2),
            Arrays.asList(2, 40),
            Arrays.asList(40, 9),
            Arrays.asList(9, 1)
        );
    }

    @Test
    void testWindowSliding3() {
        // A sliding window moves through the elements one at a time
        List<List<Integer>> sliding3 = intStream
            .stream()
            .gather(Gatherers.windowSliding(3))
            .toList();

        assertThat(sliding3).containsExactly(
            Arrays.asList(10, 8, 6),
            Arrays.asList(8, 6, 3),
            Arrays.asList(6, 3, 2),
            Arrays.asList(3, 2, 40),
            Arrays.asList(2, 40, 9),
            Arrays.asList(40, 9, 1)
        );
    }

    @Test
    void testScanOperation() {
        // The scan operation is similar to fold but emits intermediate results
        List<Integer> scannedList = intStream.stream()
            .gather(Gatherers.scan(() -> 100, Integer::sum))
            .collect(Collectors.toList());

        assertThat(scannedList).containsExactly(110, 118, 124, 127, 129, 169, 178, 179);
    }

}
