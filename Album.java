/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlist;

import java.util.ArrayList;

/**
 *
 * @author jaime
 */
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    
    public boolean addSong(String title, double duration){
        if(findSong(title)==null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }
    
    private Song findSong(String title){
        for(Song checkedsong: this.songs){
            if(checkedsong.getTitle().equals(title)){
                return checkedsong;
            }
        }
        return null;
    }
    
    private  boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1;
        if((index>=0) && (index < this.songs.size())){
        playList.add(this.songs.get(index));
        return true;
    }
        System.out.println("This album doesn't have a track" + trackNumber);
        return false;
    }
    
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkedsong = findSong(title);
        if (checkedsong == null){
            playList.add(checkedsong);
            return true;
            
        }
        System.out.println("This song" + title + "is not in the album");
        return false;
    }
    
}
