package org.ohdsi.datasourcemanager.controller;

import org.ohdsi.datasourcemanager.dto.SourceDTO;
import org.ohdsi.datasourcemanager.service.SourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/sources")
public class SourceController {

    private static final Logger logger = LoggerFactory.getLogger(SourceController.class);

    private final ConversionService conversionService;
    private final SourceService sourceService;


    public SourceController(ConversionService conversionService, SourceService sourceService) {

        this.conversionService = conversionService;
        this.sourceService = sourceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<SourceDTO> listSources(Pageable pageable) {

        return sourceService.findAll(pageable).map(s -> conversionService.convert(s, SourceDTO.class));
    }
}
