package flab.resellPlatform.common.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

class JWTTest {


    static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void create() throws NoSuchAlgorithmException, IOException, InvalidKeyException {

        // given
        String signature = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Im1pbnN1ayJ9.tULWUFvbhAopsH63VrU_NlaGhPXrMU2j2U54zHqeRsc";

        // when
        JWT jwtFactory = new JWT();
        jwtFactory.addHeader("alg", "HS256");
        jwtFactory.addHeader("typ", "JWT");
        jwtFactory.addPayload("id", "minsuk");
        jwtFactory.setAlgorithm("HmacSHA256");
        jwtFactory.setKey("123");

        String jwtToken = jwtFactory.create();

        // then
        Assertions.assertThat(jwtToken).isEqualTo(signature);
    }
}