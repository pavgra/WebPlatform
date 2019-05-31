package com.odysseusinc.arachne.executionenginecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.odysseusinc.arachne.executionenginecloud",
                "com.odysseusinc.arachne.executionengine"
        }
)
public class Application {

    public static void main(String[] args) {

        System.setProperty("server.port", "0");
        System.setProperty("server.ssl.enabled", "false");

        SpringApplication.run(Application.class, args);
    }
}
