package uebung03;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uebung03.HashTable.HashTable;
import uebung03.HashTable.ProbingAlgorithms.LinearProbing;
import uebung03.HashTable.ProbingAlgorithms.QuadraticProbing;
import uebung03.HashTable.Song;
import uebung03.HashTable.SongImplementation;
import uebung03.HashTable.SongsHashTable;

public class HashingSongs1stTestsNew {

    String s11 = "Song1";
    String s12 = "Song2";
    String s13 = "Song3";
    String s14 = "Song4";
    String s15 = "Song5";
    String s16 = "Song6";
    String s17 = "Song7";
    String s18 = "Song6";
    String s19 = "Song9";
    String s10 = "Song0";

    String s21 = "Album1";
    String s22 = "Album2";
    String s23 = "Album3";
    String s24 = "Album4";
    String s25 = "Album5";
    String s26 = "Album6";
    String s27 = "Album7";
    String s28 = "Album8";
    String s29 = "Album9";
    String s20 = "Album0";

    String[] s31 = {"Interpret1"};
    String[] s32 = {"Interpret2"};
    String[] s33 = {"Interpret3"};
    String[] s34 = {"Interpret4"};
    String[] s35 = {"Interpret5"};
    String[] s36 = {"Interpret6"};
    String[] s37 = {"Interpret7"};
    String[] s38 = {"Interpret8"};
    String[] s39 = {"Interpret9"};
    String[] s30 = {"Interpret0"};

    Song song1 = new SongImplementation(s11, s21, s31);
    Song song2 = new SongImplementation(s12, s22, s32);
    Song song3 = new SongImplementation(s13, s23, s33);
    Song song4 = new SongImplementation(s14, s24, s34);
    Song song5 = new SongImplementation(s15, s25, s35);
    Song song6 = new SongImplementation(s16, s26, s36);
    Song song7 = new SongImplementation(s17, s27, s37);
    Song song8 = new SongImplementation(s18, s28, s38);
    Song song9 = new SongImplementation(s19, s29, s39);
    Song song0 = new SongImplementation(s10, s20, s30);


    @Test
    public void test11() { // just one entry in hash table
        HashTable ht = new HashTable(2, new QuadraticProbing());
        assertEquals(null, ht.put(s11, song1));
        assertEquals(song1, ht.put(s11, song1));
        assertEquals(1, ht.size());
        assertEquals(song1, ht.get(s11));
        assertTrue(ht.containsKey(s11));
        assertTrue(ht.contains(song1));
        assertTrue(ht.remove(s11));
        assertFalse(ht.remove(s11));
    }

    @Test
    public void test12() { // two entries in hash table
        HashTable ht = new HashTable(2, new QuadraticProbing());
        assertEquals(null, ht.put(s11, song1));
        assertEquals(song1, ht.put(s11, song1));
        assertEquals(null, ht.put(s12, song2));
        assertEquals(song2, ht.put(s12, song2));
        assertEquals(2, ht.size());
        assertEquals(song1, ht.get(s11));
        assertTrue(ht.containsKey(s11));
        assertTrue(ht.contains(song1));
        assertEquals(song2, ht.get(s12));
        assertTrue(ht.containsKey(s12));
        assertTrue(ht.contains(song2));
        assertTrue(ht.remove(s12));
        assertEquals(1, ht.size());
        assertEquals(null, ht.put(s12, song2));
        assertEquals(2, ht.size());
    }

    @Test
    public void test21() { // just one entry in hash table
        HashTable ht = new HashTable(2, new LinearProbing());
        assertEquals(null, ht.put(s11, song1));
        assertEquals(song1, ht.put(s11, song1));
        assertEquals(1, ht.size());
        assertEquals(song1, ht.get(s11));
        assertTrue(ht.containsKey(s11));
        assertTrue(ht.contains(song1));
        assertTrue(ht.remove(s11));
        assertFalse(ht.remove(s11));
    }

    @Test
    public void test22() { // two entries in hash table
        HashTable ht = new HashTable(2, new LinearProbing());
        assertEquals(null, ht.put(s11, song1));
        assertEquals(song1, ht.put(s11, song1));
        assertEquals(null, ht.put(s12, song2));
        assertEquals(song2, ht.put(s12, song2));
        assertEquals(2, ht.size());
        assertEquals(song1, ht.get(s11));
        assertTrue(ht.containsKey(s11));
        assertTrue(ht.contains(song1));
        assertEquals(song2, ht.get(s12));
        assertTrue(ht.containsKey(s12));
        assertTrue(ht.contains(song2));
        assertTrue(ht.remove(s12));
        assertEquals(1, ht.size());
        assertEquals(null, ht.put(s12, song2));
        assertEquals(2, ht.size());
    }

    @Test
    public void test31() { // just one entry in hash table
        HashTable ht = new HashTable(2, new LinearProbing(3, -1));  // 3 = distance, -1 = sign is altering
        assertEquals(null, ht.put(s11, song1));
        assertEquals(song1, ht.put(s11, song1));
        assertEquals(1, ht.size());
        assertEquals(song1, ht.get(s11));
        assertTrue(ht.containsKey(s11));
        assertTrue(ht.contains(song1));
        assertTrue(ht.remove(s11));
        assertFalse(ht.remove(s11));
    }

    @Test
    public void test32() { // 7 entries in hash table
        HashTable ht = new HashTable(2, new LinearProbing(2, 1)); // 2 = distance, 1 = sign is not altering
        assertEquals(null, ht.put(s11, song1));
        assertEquals(song1, ht.put(s11, song1));
        assertEquals(null, ht.put(s12, song2));
        assertEquals(song2, ht.put(s12, song2));
        assertEquals(2, ht.size());
        assertEquals(song1, ht.get(s11));
        assertTrue(ht.containsKey(s11));
        assertTrue(ht.contains(song1));
        assertEquals(song2, ht.get(s12));
        assertTrue(ht.containsKey(s12));
        assertTrue(ht.contains(song2));
        assertTrue(ht.remove(s12));
        assertEquals(1, ht.size());
        assertEquals(null, ht.put(s12, song2));
        assertEquals(2, ht.size());
        assertEquals(0, ht.getStat());

        assertEquals(null, ht.put(s13, song3));
        assertEquals(8, ht.sizeOfHashTable());
        assertEquals(0, ht.getStat());

        assertEquals(null, ht.put(s14, song4));
        assertEquals(null, ht.put(s15, song5));
        assertEquals(8, ht.sizeOfHashTable());
        assertEquals(0, ht.getStat());

        assertEquals(null, ht.put(s16, song6));
        assertEquals(null, ht.put(s17, song7));
        assertEquals(0, ht.getStat());
        assertEquals(16, ht.sizeOfHashTable());
    }

    @Test
    public void testAllSongs() { // all Songs from file in hash table

        HashTable ht = new HashTable(3, new QuadraticProbing());

        String[] songs = SongsHashTable.getAllSongsFromFile("E:\\Team-03\\PR2-SoSe22-Stud\\src\\uebung03\\HashTable\\songs.txt");

        for (String songString : songs) {
            String[] parts = SongsHashTable.split(songString, ';');
            String[] artists = new String[parts.length - 2];
            for (int i = 2; i < parts.length; i++)
                artists[i - 2] = parts[i];

            Song song = new SongImplementation(parts[0], parts[1], artists);

            ht.put(parts[0], song);
        }

        assertEquals(2810, ht.size());
        assertEquals(6144, ht.sizeOfHashTable());
        assertEquals(4625, ht.getStat());


    }
}
