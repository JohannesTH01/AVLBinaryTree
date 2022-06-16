package uebung03.Elements;

public interface Element extends Comparable{
    static final int DESCENDING = 0;
    static final int ASCENDING = 1;
    static int order = ASCENDING;

    public Object clone();
    public Object getKey();

}
