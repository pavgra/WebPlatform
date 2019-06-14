package org.ohdsi.zuulsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {

        // TODO:
        // make faster registration of services for development profile
        // https://github.com/spring-cloud/spring-cloud-netflix/issues/373#issuecomment-110331739

        // TODO:
        // when laptop goes into sleep and then wakes up - services do not work

        SpringApplication.run(Application.class, args);
    }
}
