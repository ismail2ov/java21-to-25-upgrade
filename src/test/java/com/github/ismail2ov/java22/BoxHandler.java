package com.github.ismail2ov.java22;

class BoxHandler {

    void handleBox(Box box) {
        switch (box) {
            case Box(RedBall _)   -> processBox(box);
            case Box(BlueBall _)  -> processBox(box);
            case Box(GreenBall _) -> stopProcessing();
            case Box(var _)       -> pickAnotherBox();
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

