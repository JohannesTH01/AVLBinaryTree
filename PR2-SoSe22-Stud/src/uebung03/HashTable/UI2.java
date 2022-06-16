package uebung03.HashTable;

import uebung03.HashTable.ProbingAlgorithms.LinearProbing;
import uebung03.HashTable.ProbingAlgorithms.QuadraticProbing;

import static gdi.MakeItSimple.*;

public class UI2 {
    private HashTable hashTable;

    public void ui() {
        println("Willcome to your HashTable");
        hashTable = initHashTable();
        if (hashTable != null)
            activities(hashTable);

    }

    public HashTable initHashTable() {
        print("Please enter the size here: ");
        int size = readInt();
        print("Do you want to add a special probing? y/n");
        String answer = readLine();
        switch (answer) {
            case "y":
                print(" Which probing do you want to use? \n [1] linear \n [2] squared\n");
                switch (readInt()) {
                    // init Hashtables
                    case 1:
                        print("distance: ");
                        int distance = readInt();
                        print("alternierend (-1 alternierend / 1 linear)");
                        int alt = Integer.parseInt(readLine());

                        return new HashTable(size, new LinearProbing(distance, alt));
                    case 2:
                        return new HashTable(size, new QuadraticProbing());
                }
            case "n":
        }
        return new HashTable(size);
    }

    public void activities(HashTable hs) {
        boolean runFlag = true;
        do{
        print(" What do you want to do? " + // options to choose
                "\n [1] clear HashTable " +
                "\n [2] check if empty " +
                "\n [3] getStat " +
                "\n [4] print " +
                "\n [5] get the size " +
                "\n [6] reHash " +
                "\n [7] put an Object " +
                "\n [8] remove an Element " +
                "\n [9] get an Element " +
                "\n [10] check if contains key " +
                "\n [11] check if contains the Object " +
                "\n [12] exit" +
                "\n Please enter here: ");

            switch (readInt()) { // switch for options
                case 1:
                    hs.clear();
                    break;
                case 2:
                    println(hs.isEmpty());
                    break;
                case 3:
                    println(hs.getStat());
                    break;
                case 4:
                    hs.printHT();
                    break;
                case 5:
                    println(hs.size());
                    break;
                case 6:
                    hs.reHash();
                    hs.printHT();
                    break;
                case 7:
                    print("Enter key / songname: ");
                    String key = readLine();
                    print("albumName: ");
                    String albumName = readLine();
                    print("artists: ");
                    String artists[] = readLine().split(",");
                    Object returnvalue = hs.put(key, new SongImplementation(key, albumName, artists));
                    if (returnvalue != null)
                        println("The element on this field was:\n" + ((SongImplementation) returnvalue).toString());
                    else
                        println("The previous element on this field was null");
                    break;
                case 8:
                    print("Enter key: ");
                    key = readLine();
                    println(hs.remove(key));
                    break;
                case 9:
                    print("Enter key: ");
                    key = readLine();
                    println(((ElementOfHashTable) (hs.get(key))).key + " : " + ((ElementOfHashTable) (hs.get(key))).value);
                    break;
                case 10:
                    print("Enter key: ");
                    key = readLine();
                    println(hs.containsKey(key));
                    break;
                case 11:
                    print("Enter key / songname: ");
                    key = readLine();
                    print("albumName: ");
                    albumName = readLine();
                    print("artists: ");
                    artists = readLine().split(",");

                    println(hs.contains(new ElementOfHashTable(key, new SongImplementation(key, albumName, artists))));
                    break;
                case 12:
                    print("Bye");
                    runFlag = false;
                    break;
            }

        }while(runFlag);
    }

    private int readInt() {  //method is overwritten to prevent a bug caused by the library
        String input = "";
        do {
            input = readLine();
        } while (input.isEmpty() || input.isBlank());

        return (Integer.parseInt(input));
    }
}
