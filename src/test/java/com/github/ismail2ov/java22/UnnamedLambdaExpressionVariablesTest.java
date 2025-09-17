package com.github.ismail2ov.java22;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class UnnamedLambdaExpressionVariablesTest {

    static Map<String, String> getIds(List<UniqueRectangle> rectangles) {
        return rectangles.stream()
            .collect(
                Collectors.toMap(
                    UniqueRectangle::id,
                    r -> "NODATA"));
    }

    record Point(double x, double y) { }

    record UniqueRectangle(String id, Point upperLeft, Point lowerRight) { }

    @Test
    void testGetIDsNormalList() {
        List<UniqueRectangle> rectangles = List.of(
            new UniqueRectangle("R1", new Point(0, 0), new Point(1, 1)),
            new UniqueRectangle("R2", new Point(1, 1), new Point(2, 2)),
            new UniqueRectangle("R3", new Point(2, 2), new Point(3, 3))
        );

        Map<String, String> result = getIds(rectangles);

        assertThat(result)
            .hasSize(3)
            .containsKeys("R1", "R2", "R3");

        assertThat(result.values()).allMatch(v -> v.equals("NODATA"));
    }

    @Test
    void testGetIDsEmptyList() {
        List<UniqueRectangle> rectangles = List.of();

        Map<String, String> result = getIds(rectangles);

        assertThat(result).isEmpty();
    }

}