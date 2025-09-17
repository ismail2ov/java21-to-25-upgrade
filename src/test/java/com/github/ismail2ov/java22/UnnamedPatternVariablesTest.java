package com.github.ismail2ov.java22;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UnnamedPatternVariablesTest {

    @Test
    void testRedBallCallsProcessBox() {
        TestBoxHandler handler = new TestBoxHandler();
        Box redBox = new Box(new RedBall("R1"));

        handler.handleBox(redBox);

        assertTrue(handler.processCalled, "processBox should be called");
        assertEquals(redBox, handler.lastBox, "Box passed should match");
        assertFalse(handler.stopCalled, "stopProcessing should not be called");
        assertFalse(handler.pickCalled, "pickAnotherBox should not be called");
    }

    @Test
    void testBlueBallCallsProcessBox() {
        TestBoxHandler handler = new TestBoxHandler();
        Box blueBox = new Box(new BlueBall("B1"));

        handler.handleBox(blueBox);

        assertTrue(handler.processCalled, "processBox should be called");
        assertEquals(blueBox, handler.lastBox, "Box passed should match");
        assertFalse(handler.stopCalled);
        assertFalse(handler.pickCalled);
    }

    @Test
    void testGreenBallCallsStopProcessing() {
        TestBoxHandler handler = new TestBoxHandler();
        Box greenBox = new Box(new GreenBall("G1"));

        handler.handleBox(greenBox);

        assertTrue(handler.stopCalled, "stopProcessing should be called");
        assertFalse(handler.processCalled);
        assertFalse(handler.pickCalled);
    }

    @Test
    void testOtherBallCallsPickAnotherBox() {
        TestBoxHandler handler = new TestBoxHandler();
        Box otherBox = new Box("SomeOtherContent");

        handler.handleBox(otherBox);

        assertTrue(handler.pickCalled, "pickAnotherBox should be called");
        assertFalse(handler.processCalled);
        assertFalse(handler.stopCalled);
    }

    private static class TestBoxHandler extends BoxHandler {

            boolean processCalled = false;
            boolean stopCalled = false;
            boolean pickCalled = false;
            Box lastBox = null;

            @Override
            void processBox(Box box) {
                processCalled = true;
                lastBox = box;
            }

            @Override
            void stopProcessing() {
                stopCalled = true;
            }

            @Override
            void pickAnotherBox() {
                pickCalled = true;
            }
    }
}
