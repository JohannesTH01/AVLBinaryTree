package uebung03;

import uebung03.HashTable.UI2;

import static pr.MakeItSimple.*;


public class Main {

    public static void main(String[] args) {
        println(" What do you want to do? \n [1] Sorts \n [2] Hash table \n Type in here:");
        int input = readInt();
        switch (input) {
            case 1:
                UI ui = new UI();
                ui.menu();
                break;
            case 2:
                UI2 ui2 = new UI2();
                ui2.ui();
                break;

        }

    }
}
