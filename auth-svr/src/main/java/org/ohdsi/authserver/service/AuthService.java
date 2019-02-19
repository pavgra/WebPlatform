package org.ohdsi.authserver.service;

public interface AuthService {

    boolean login(String username, String password);

    String getMethod();
}
