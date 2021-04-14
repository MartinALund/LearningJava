package dk.lundudvikling;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        String longChar = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.";
        String mediumChar = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturi";
        String shortChar = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo l";

        System.out.println("Long: " + longChar.length());
        System.out.println("Med: " + mediumChar.length());
        System.out.println("Short: " + shortChar.length());
        List<String> strings = new ArrayList<>();
        strings.add(longChar);
        strings.add(mediumChar);
        strings.add(shortChar);

        for (String s: strings){
            if (s.length() >= 75){
                int divider = 75;
                int actualLength = s.length();
                int chunks = (actualLength / divider) + 1;

                for (int i = 0; i < chunks; i++){
                    String what = s.substring(divider * i, divider * (i+1) );
                    System.out.println(what);
                }
                System.out.println("Chunks: " + actualLength / divider);

            }
        }
    }
}
