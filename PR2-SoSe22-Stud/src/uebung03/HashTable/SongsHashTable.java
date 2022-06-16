package uebung03.HashTable;

import java.util.ArrayList;

import static gdi.MakeItSimple.*;
import static gdi.MakeItSimple.closeInputFile;

public class SongsHashTable {

    public static String[] getAllSongsFromFile(String filename) {
        ArrayList<String> songs = new ArrayList<>(); // arraylist for collecting the songs
        Object file = openInputFile(filename);
        while (!isEndOfInputFile(file)) {
            String line = readLine(file);
            songs.add(line); // adds a line to the arraylist
        }
        closeInputFile(file);
        return (songs.toArray(new String[songs.size()])); // returns the array of Strings
    }

    public static String[] split(String song, char rj) {
        return song.split(Character.toString(rj));
    } // splits the Strings at rj
}
