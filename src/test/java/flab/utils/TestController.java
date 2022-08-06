package flab.utils;

import flab.resellPlatform.common.response.StandardResponse;
import flab.resellPlatform.domain.user.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    @GetMapping("/test")
    @PreAuthorize(Role.USER)
    public StandardResponse doAuthorizationTest() {

        StandardResponse standardResponse = StandardResponse.builder()
                .message("Test succeeded")
                .data(Map.of())
                .build();

        return standardResponse;
    }
}
