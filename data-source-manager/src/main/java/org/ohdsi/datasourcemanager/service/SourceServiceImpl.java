package org.ohdsi.datasourcemanager.service;

import org.ohdsi.datasourcemanager.model.Source;
import org.ohdsi.datasourcemanager.repository.SourceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl implements SourceService {

    private final SourceRepository sourceRepository;

    public SourceServiceImpl(SourceRepository sourceRepository) {

        this.sourceRepository = sourceRepository;
    }

    @Override
    public Page<Source> findAll(Pageable pageable) {

        return sourceRepository.findAll(pageable);
    }
}
