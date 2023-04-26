package spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class MusicPlayer {


    private Music rockMusic;
    private Music classicMusic;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music rockMusic,
                       @Qualifier("classicMusic") Music classicMusic){
        this.rockMusic = rockMusic;
        this.classicMusic = classicMusic;
    }

    public Music getClassicMusic(){
        return classicMusic;
    }
    public Music getRockMusic(){
        return rockMusic;
    }

    public void playMusic(MusicType type){
        switch (type){
            case ROCK:
                rockMusic.playSong();
                break;
            case CLASSICAL:
                classicMusic.playSong();
                break;
        }
    }
    public void printName(){
        System.out.println(name);
    }
    public void printVolume(){
        System.out.println(volume);
    }
}
