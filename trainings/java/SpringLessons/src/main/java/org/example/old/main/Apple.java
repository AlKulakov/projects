package org.example.old.main;

import org.springframework.stereotype.Component;

@Component
public class Apple {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
