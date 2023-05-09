package org.example.spring_w_qual.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "org.example.spring_w_qual.proxies",
        "org.example.spring_w_qual.service",
        "org.example.spring_w_qual.repository"
})
public class ProjectConfiguration {

}
