package flab.resellPlatform.common.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

@Setter
public class JWT {
    private Map<String, String> header = new LinkedHashMap<>();
    private Map<String, String> payload = new LinkedHashMap<>();

    private ObjectMapper objectMapper = new ObjectMapper();

    String algorithm;
    String key;

    public void addHeader(String key, String value) {
        header.put(key, value);
    }

    public void addPayload(String key, String value) {
        payload.put(key, value);
    }

    public String create() throws NoSuchAlgorithmException, InvalidKeyException, IOException {

        // header, payload 문자로 변환
        String headerString = objectMapper.writeValueAsString(header);
        String payloadString = objectMapper.writeValueAsString(payload);

        // 시그니처 생성
        byte[] signature = sign(headerString, payloadString, algorithm, key);

        // 결과 출력
        String encodedHeaderString = Base64.getUrlEncoder().withoutPadding().encodeToString(headerString.getBytes());
        String encodedPayloadString = Base64.getUrlEncoder().withoutPadding().encodeToString(payloadString.getBytes());
        String encodedSignatureString = Base64.getUrlEncoder().withoutPadding().encodeToString(signature);

        return encodedHeaderString + "." + encodedPayloadString + "." + encodedSignatureString;
    }

    byte[] sign(String payload, String header, String algorithm, String key) throws NoSuchAlgorithmException, InvalidKeyException {

        // 헤더와 페이로드 Base64URL encoding
        String encodedHeaderString = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes());
        String encodedPayloadString = Base64.getUrlEncoder().withoutPadding().encodeToString(header.getBytes());

        String signatureSource = encodedHeaderString + "." + encodedPayloadString;

        // 알고리즘으로 암호화
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key.getBytes(), mac.getAlgorithm()));
        byte[] signature = mac.doFinal(signatureSource.getBytes(StandardCharsets.UTF_8));
        return signature;
    }
}
