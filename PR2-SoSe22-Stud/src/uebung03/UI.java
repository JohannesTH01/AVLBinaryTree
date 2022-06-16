package uebung03;


import uebung03.Elements.Element;
import uebung03.Elements.IntElement;
import uebung03.Elements.StringElement;

import static gdi.MakeItSimple.*;
import static pr.MakeItSimple.readIntegerArray;
import static pr.MakeItSimple.readStringArray;


public class UI {

    Comparable<?>[] cArray;
    SortInterface sortAlgorithm;

    public void menu() {


        print("Welches Sortierverfahren wollen Sie verwinden? \nq-QickSortV3 \ni-InterSort \nPlease type in here: ");
        String sortCase = readLine();
        if (sortCase.equalsIgnoreCase("q")) {
            this.sortAlgorithm = new QuickSortV3();
        }
        if (sortCase.equalsIgnoreCase("i")) {
            this.sortAlgorithm = new InsertionSort();
        }
        print("What kind of element do you want to read in? int/str ");
        String type = readLine();


        String check;
        int cnt = 0;
        print("Do you want to read from a file ? y/n ");
        String answerFileRead = readLine();
        if (answerFileRead.equals("y")) {
            print("Please enter the file Path: ");
            String filepath = readLine();
            cArray = readFromFile(filepath, type);
        } else {
            cArray = new Comparable[1];
            do {
                dynamic(cnt);
                if (type.equals("str")) {
                    print("Please type your word here: ");
                    cArray[cnt] = new StringElement(readLine());


                } else if (type.equals("int")) {
                    print("Please type your Number here: ");
                    cArray[cnt] = new IntElement(readInt());
                    for (Comparable<?> t : cArray)
                        println(((IntElement) t).getKey() + " ");
                }
                println("Do you want to add another items? y/n");
                do {
                    check = readLine();
                } while (check.isBlank() || check.isEmpty());
                cnt++;
            } while (check.equals("y"));
        }
        println("Array to sort: ");
        printArray(cArray);
        println();

        print("In which direction should the go? \n1-normal(left to right\n-1-reverse(right to left)\nPlease type in here: ");
        int direction = readInt();
        if(this.sortAlgorithm instanceof QuickSortV3)
            ((QuickSortV3)this.sortAlgorithm).sortArray(cArray, this.sortAlgorithm, direction);
        if(this.sortAlgorithm instanceof InsertionSort)
            ((InsertionSort)this.sortAlgorithm).sortArray(cArray, this.sortAlgorithm, direction);
        println("Sorted Array: ");
        printArray(cArray);
    }

    private void dynamic(int index) {
        if (index >= cArray.length) {
            Comparable<?>[] newArray = new Comparable[index + 1];
            System.arraycopy(cArray, 0, newArray, 0, cArray.length); // copies cArray to newArray
            cArray = newArray;
        }
    }

    private void printArray(Comparable<?>[] array) {
        for (Comparable<?> i : array) {
            if (i instanceof IntElement) {
                print(((Element) i).getKey() + " ");
            }
            if (i instanceof StringElement)
                print(((Element) i).getKey() + " ");
        }

    }

    public Comparable<?>[] readFromFile(String filename, String type) {

        if (!isFilePresent(filename)) {
            return new Comparable[]{};
        }
        if (type.equals("int")) {
            int[] tempArray = readIntegerArray(filename);// reads the file into an array (elements)
            Comparable<?>[] comp = new Comparable[tempArray.length];
            for (int i = 0; i < tempArray.length; i++) {
                comp[i] = new IntElement(tempArray[i]);
            }
            return comp;
        }
        if (type.equals("str")) {
            if (!isFilePresent(filename)) {
                println(" File not found. Returned a new Comparable-Array.");
                return new Comparable[]{new StringElement("Empty")};
            }

            StringBuilder readString = new StringBuilder();
            Object inputFile = openInputFile(filename);
            while (!isEndOfInputFile(inputFile))
                readString.append(readLine(inputFile));
            closeInputFile(inputFile);

            String[] elements = readString.toString().split(" +"); // one or more spaces --> new string
            Comparable[] stringElements = new Comparable[elements.length];
            for (int i = 0; i < stringElements.length; i++)
                stringElements[i] = new StringElement(elements[i]);
            return stringElements;

        } else
            println(" File not found."); // if the file is not present / wrong path

        return new Comparable[0];
    }

}
