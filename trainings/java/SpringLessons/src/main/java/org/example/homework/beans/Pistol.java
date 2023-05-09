package org.example.homework.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
@Component
@Qualifier("Pistol")
@Primary
public class Pistol implements Gun{
    @Override
    public void shot() {
        System.out.println("Piu piu");
    }
}
