package dk.lundudvikling.Reflection;

public class UFOEnemyShip extends EnemyShip{

    private String idCode = "100";
    private String getPrivate(){return "How did you get this?"; }
    private String getOtherPrivate(int thisInt, String thatString){
        return "How did you get here " + thisInt + " " + thatString;
    }

    public UFOEnemyShip(int number, String randString){
        System.out.println("you sent: " + number + randString);
    }
}
