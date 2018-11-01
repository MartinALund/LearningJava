package dk.lundudvikling;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phoneNumber;
    private final String address;


    public static class Builder{
        // Required
        private String firstName;
        private String lastName;

        // Optional
        private int age = 0;
        private String phoneNumber = "Telefon ikke angivet";
        private String address = "Adresse ikke angivet";

        public Builder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder age(int val){
            age = val;
            return this;
        }

        public Builder phoneNumber(String val){
            phoneNumber = val;
            return this;
        }
        public Builder address(String val){
            address = val;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    private Person(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
    }
}
