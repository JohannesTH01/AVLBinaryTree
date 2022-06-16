package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.HashTable;
import uebung03.HashTable.Probing;

public class LinearProbing implements Probing {
    private int counter;
    private int distance = 1;   //default = 1
    private int alternierend;
    boolean sign = true;    //true positive

    public LinearProbing() {
        this(1, -1); // default declaration
    }

    public LinearProbing(int distance, int alternierend) { // constructor overload to init distance and alternierend
        this.alternierend = alternierend;
        this.distance = distance;
    }
    @Override
    public int nextNum(HashTable t){
        t.numberOfCollisions++;
        return this.nextNum();
    }
    @Override
    public int nextNum() {  //returns an offset
        counter = counter + distance; // adds to the distance to the counter
        if (alternierend < 0) {  // go here when alternierend is -1
            if (sign) { // switch always between counter and counter *(-1)
                sign = !sign;
                return counter;
            } else {
                sign = !sign;
                return ((-1) * counter);
            }

        } else {
            return counter; // if not alternierend return counter
        }
    }

    @Override
    public void startProbing() { // starts probing
        sign = true;
        counter = 0;
    }


}
