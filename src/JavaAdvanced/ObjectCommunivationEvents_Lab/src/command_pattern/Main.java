package command_pattern;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("asd", 10);
        Dragon dragon = new Dragon(5, 10, "asd");

        Command targetCommand = new TargetCommand(warrior, dragon);
        Command attackCommand = new AttackCommand(warrior);

        targetCommand.execute();
        attackCommand.execute();

        System.out.println(warrior.getXp());
    }
}
