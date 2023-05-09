package org.example.homework.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Human {
    @Autowired
    private Gun gun;
    public void use(){
        gun.shot();
    }
}
