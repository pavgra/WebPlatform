package org.ohdsi.authserver.service;

import org.ohdsi.authserver.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    User get(String username);

    User getOrCreate(String username);
}
