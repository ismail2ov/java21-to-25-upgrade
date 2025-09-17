package com.github.ismail2ov.java22;

class BoxHandler {

    void handleBox(Box box) {
        switch (box) {
            case Box(RedBall ball)   -> processBox(box);
            case Box(BlueBall ball)  -> processBox(box);
            case Box(GreenBall ball) -> stopProcessing();
            case Box(var other)      -> pickAnotherBox();
        }
    }

    void processBox(Box box) {
        System.out.println("Processing: " + box);
    }

    void stopProcessing() {
        System.out.println("Stopping processing");
    }

    void pickAnotherBox() {
        System.out.println("Picking another box");
    }
}

record RedBall(String name) {}
record BlueBall(String name) {}
record GreenBall(String name) {}
record Box(Object content) {}

