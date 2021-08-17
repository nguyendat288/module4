package service;

import moduls.Music;

import java.util.ArrayList;

public class MusicService {
    public ArrayList<Music> list=new ArrayList<>();
    public MusicService(){
        list.add(new Music("lac troi","mtp","vpop","abc.mp3"));
        list.add(new Music("anh se de em di","abc","rap","abc1.mp3"));
    }
    public void add(Music music){
        list.add(music);
    }
    public void remove(int index){
        list.remove(index);
    }
}
