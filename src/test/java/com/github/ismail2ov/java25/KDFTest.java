package com.github.ismail2ov.java25;

import javax.crypto.KDF;
import javax.crypto.spec.HKDFParameterSpec;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.crypto.SecretKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class KDFTest {

    @Test
    void testHkdfSha256DeriveAesKey() throws Exception {
        byte[] initialKeyMaterial = "test key material".getBytes();
        byte[] salt = "the salt".getBytes();
        byte[] info = "test info".getBytes();

        KDF hkdf = KDF.getInstance("HKDF-SHA256");

        AlgorithmParameterSpec params =
            HKDFParameterSpec.ofExtract()
                .addIKM(initialKeyMaterial)
                .addSalt(salt)
                .thenExpand(info, 32);

        SecretKey key = hkdf.deriveKey("AES", params);

        assertThat(key).isNotNull();
        assertThat(key.getAlgorithm()).isEqualTo("AES");
        assertThat(key.getEncoded()).hasSize(32);
    }
}
