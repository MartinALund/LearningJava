package dk.lundudvikling.streams;

public class Animal {

    public String name;
    public int maxAge;

    public Animal(String name, int maxAge) {
        this.name = name;
        this.maxAge = maxAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", maxAge=" + maxAge +
                '}';
    }
}
