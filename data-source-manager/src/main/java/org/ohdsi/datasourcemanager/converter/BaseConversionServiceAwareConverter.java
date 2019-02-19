package org.ohdsi.datasourcemanager.converter;

import lombok.val;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

public abstract class BaseConversionServiceAwareConverter<Source, Result> implements Converter<Source, Result>, InitializingBean {

    protected Result createResultObject() {

        return null;
    }

    protected Result createResultObject(Source from) {

        return createResultObject();
    }

    @Autowired
    protected GenericConversionService conversionService;

    @Override
    public void afterPropertiesSet() throws Exception {

        conversionService.addConverter(this);
    }

    protected abstract void processFields(final Source from, Result to);

    public Result convert(Source from) {

        val to = createResultObject(from);
        processFields(from, to);
        return to;
    }
}