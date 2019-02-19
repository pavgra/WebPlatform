package org.ohdsi.authserver.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import org.ohdsi.authserver.model.User;

public interface UserRepository extends EntityGraphJpaRepository<User, Integer> {

    User findByUsername(String username);
}
