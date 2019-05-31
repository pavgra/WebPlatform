package org.ohdsi.webapicloud;

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "org.ohdsi.webapicloud",
                "org.ohdsi.webapi"
        },
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = org.ohdsi.webapi.WebApi.class)
        }
)
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {

        TomcatURLStreamHandlerFactory.disable();
        new Application().configure(new SpringApplicationBuilder(Application.class)).run(args);
    }
}
