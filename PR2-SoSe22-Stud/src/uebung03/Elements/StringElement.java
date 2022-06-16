package uebung03.Elements;


public class StringElement implements Element, Cloneable {

    private String key;

    public StringElement(String key) {
        this.key = key; //set this.key to the param key
    }

    @Override
    public Object clone() {
        return new StringElement(this.key);//clones the object
    }

    @Override
    public Object getKey() {
        return this.key;// return the key
    }

    @Override
    public int compareTo(Object o) {
        String comparisonString = (String) ((StringElement) o).getKey();

        // compare to method with charAt, loops through and compares the elements

        for (int i = 0; (i < this.key.length() && i < comparisonString.length()); i++) {
            if (this.key.charAt(i) == comparisonString.charAt(i))
                continue;
            if (this.key.charAt(i) < comparisonString.charAt(i))
                return 1;
            if (this.key.charAt(i) > comparisonString.charAt(i))
                return -1;
        }
        //at this point both string are equal but one of them is longer
        if (this.key.length() < comparisonString.length())
            return 1;
        if (this.key.length() > comparisonString.length())
            return -1;
        return 0;   //equal strings
    }
}
