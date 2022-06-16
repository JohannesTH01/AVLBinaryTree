package uebung03.HashTable;

import scala.util.parsing.combinator.testing.Str;

import java.util.ArrayList;

import static gdi.MakeItSimple.*;

public class SongParser {

    //Hilfsklasse
    public static SongImplementation[] parseSongs(String filename) {
        //the function parses all songs contained in the file into a song-array

        ArrayList<SongImplementation> songs = new ArrayList<>();
        Object file = openInputFile(filename);
        while (!isEndOfInputFile(file)) {   //loop over the file
            String line = readLine(file);
            String content[] = line.split(";"); //split at ";"

            int numberOfArtists = content.length - 2;   //withdraw 2, for song and album name
            String artists[] = new String[numberOfArtists];
            for (int i = 0; i < numberOfArtists; i++)
                artists[i] = content[i + 2];
            songs.add(new SongImplementation(content[0], content[1], artists));
        }
        closeInputFile(file);

        return (songs.toArray(new SongImplementation[songs.size()]));
    }
}
