package com.github.ismail2ov.java25;

public class Framework {

    static final ScopedValue<FrameworkContext> CONTEXT = ScopedValue.newInstance();

    public static ScopedValue<FrameworkContext> contextScopedValue() {
        return CONTEXT;
    }

    void serve(Request request, Response response) {
        var context = createContext(request);
        ScopedValue.where(CONTEXT, context)
            .run(() -> Application.handle(request, response));
    }

    public PersistedObject readKey(String key) {
        var context = CONTEXT.get();
        var db = getDBConnection(context);
        return db.readKey(key);
    }

    protected FrameworkContext createContext(Request request) {
        return new FrameworkContext("CTX-" + request.id());
    }

    protected DBConnection getDBConnection(FrameworkContext context) {
        return new DBConnection();
    }
}

class FrameworkContext {

    private final String id;

    FrameworkContext(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}

class Request {

    private final String id;

    public Request(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}

class Response {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class PersistedObject {

    private final String key;

    PersistedObject(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}

class DBConnection {

    public PersistedObject readKey(String key) {
        return new PersistedObject("VALUE_FOR_" + key);
    }
}

class Application {

    public static void handle(Request request, Response response) {
        response.setContent("Handled request " + request.id());
    }
}

