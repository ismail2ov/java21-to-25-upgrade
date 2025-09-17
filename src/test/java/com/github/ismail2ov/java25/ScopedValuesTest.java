package com.github.ismail2ov.java25;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ScopedValuesTest {

    private final Framework framework = new Framework();

    @Test
    void serveShouldPopulateResponse() {
        Request request = new Request("REQ-1");
        Response response = new Response();

        framework.serve(request, response);

        assertThat(response.getContent())
            .isEqualTo("Handled request REQ-1");
    }

    @Test
    void readKeyShouldReturnPersistedObject() {
        FrameworkContext testContext = new FrameworkContext("CTX-TEST");

        ScopedValue.where(
            Framework.contextScopedValue(), testContext
        ).run(() -> {
            PersistedObject result = framework.readKey("myKey");

            assertThat(result).isNotNull();
            assertThat(result.key()).isEqualTo("VALUE_FOR_myKey");
        });
    }
}

