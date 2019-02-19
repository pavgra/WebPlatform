package org.ohdsi.datasourcemanager;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(
        repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class,
        basePackages = {"org.ohdsi.datasourcemanager.*"}
)
@EnableResourceServer
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
