package org.example.spring_with_primary.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "org.example.spring_with_primary.proxies",
        "org.example.spring_with_primary.service",
        "org.example.spring_with_primary.repository"
})
public class ProjectConfiguration {

}
