package org.ohdsi.authserver.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SampleAuthService implements AuthService {

    @Override
    public boolean login(String username, String password) {

        return Objects.equals(username, "sampleuser") && Objects.equals(password, "123456");
    }

    @Override
    public String getMethod() {

        return "sample";
    }
}
