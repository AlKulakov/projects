package spr;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Scope("singleton")
public class ClassicMusic implements Music{
    private ArrayList<String> musicList = new ArrayList<>();
    public ClassicMusic (){
        musicList.add("Moonlight sonata...");
        musicList.add("Turlish march");
        musicList.add("13-th symphony");
    }
    public void playSong(){
        Random rand = new Random();
        int num = rand.nextInt(2)+1;
        System.out.println(musicList.get(num));
    }
}
