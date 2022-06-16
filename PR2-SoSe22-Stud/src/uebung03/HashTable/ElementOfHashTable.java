package uebung03.HashTable;

public class ElementOfHashTable {
    Object value; // init value
    Object key;// init key
    boolean overwrite = false; // flag if the element can be overwritten

    public ElementOfHashTable(Object value, Object key) {
        this.value = value; // sets value
        this.key = key;// sets key
    }

    public Object getValue() {
        return value;
    } // gets the Value

}
