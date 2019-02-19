package org.ohdsi.datasourcemanager.service;

import org.ohdsi.datasourcemanager.model.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SourceService {

    Page<Source> findAll(Pageable pageable);
}
