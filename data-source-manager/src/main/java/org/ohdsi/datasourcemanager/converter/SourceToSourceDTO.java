package org.ohdsi.datasourcemanager.converter;

import org.ohdsi.datasourcemanager.dto.SourceDTO;
import org.ohdsi.datasourcemanager.model.Source;
import org.springframework.stereotype.Component;

@Component
public class SourceToSourceDTO extends BaseConversionServiceAwareConverter<Source, SourceDTO> {

    @Override
    protected void processFields(Source from, SourceDTO to) {
        to.setId(from.getSourceId());
        to.setName(from.getName());
    }
}
