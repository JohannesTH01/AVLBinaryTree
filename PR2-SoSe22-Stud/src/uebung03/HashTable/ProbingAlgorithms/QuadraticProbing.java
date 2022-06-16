package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.HashTable;
import uebung03.HashTable.Probing;

public class QuadraticProbing implements Probing {
    private int counter = 1;
    private int offset = 1;
    private final int distance = 1; // default
    private boolean sign = true;

    @Override
    public int nextNum(HashTable t){
        t.numberOfCollisions++;
        return this.nextNum();
    }


    // is always alternating
    @Override
    public int nextNum() { // gets next number
        if (sign) { // switch always between counter and counter *(-1)
            offset = (int) Math.pow(counter++, 2);
            sign = false;
            return offset;
        } else {
            sign = true;
            return ((-1) * offset);
        }
    }

    @Override
    public void startProbing() {// start probing
        sign = true;
        counter = 1; // counter to 0
    }

    private int modulo(int n, int m) {
        int i = n % m;
        if (i < 0) i += m;
        return i;

    }// own modulo operator for the absolut modulo

}
