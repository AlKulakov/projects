package org.example.old.beans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    String name = "Coco";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
