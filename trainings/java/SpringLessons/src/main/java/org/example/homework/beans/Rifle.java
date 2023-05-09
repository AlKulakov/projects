package org.example.homework.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Rifle")
public class Rifle implements Gun{
    @Override
    public void shot() {
        System.out.println("Trrrrrrr");
    }
}
