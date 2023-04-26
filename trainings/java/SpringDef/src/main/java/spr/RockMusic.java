package spr;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Scope("prototype")
public class RockMusic implements Music {
    ArrayList<String> musicList = new ArrayList<>();
    RockMusic(){
        musicList.add("Highway to hell...");
        musicList.add("Legion of monsters...");
        musicList.add("Immortalized...");
    }
    public void playSong(){
        Random rand = new Random();
        int num = rand.nextInt(2)+1;
        System.out.println(musicList.get(num));
    }
}
