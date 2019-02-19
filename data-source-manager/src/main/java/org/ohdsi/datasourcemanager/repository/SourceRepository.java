package org.ohdsi.datasourcemanager.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import org.ohdsi.datasourcemanager.model.Source;

public interface SourceRepository extends EntityGraphJpaRepository<Source, Integer> {
}
