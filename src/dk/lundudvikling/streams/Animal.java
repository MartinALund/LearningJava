package dk.lundudvikling.streams;

public class Animal implements Comparable<Animal>{

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

    @Override
    public int compareTo(Animal animal) {
        //Det er muligt at lave denne comparable da String allerede implementeret Comparable
        return this.getName().compareTo(animal.getName());
    }
}
