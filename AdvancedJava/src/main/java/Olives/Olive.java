package main.java.Olives;

public class Olive implements Comparable<Olive>{

    public OliveName oliveName;
    public OliveColor oliveColor;

    public Olive() {
    }

    public Olive(OliveName oliveName) {
        this.oliveName = oliveName;
    }

    public Olive(OliveName oliveName, OliveColor color) {
        this(oliveName);
        this.oliveColor = color;
    }

    public String toString() {
        return "name: " + this.oliveName + ": " + "color: " +  this.oliveColor;
    }


    //Treeset comparable
    @Override
    public int compareTo(Olive o) {

        String s1 = this.oliveName.toString();
        String s2 = o.oliveName.toString();
        return s1.compareTo(s2);
    }
}
