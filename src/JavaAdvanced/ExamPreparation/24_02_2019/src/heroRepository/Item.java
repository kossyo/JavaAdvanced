package heroRepository;

public class Item {

    private int strength;
    private int agility;
    private int inteligence;

    public Item(int strength, int agility, int inteligence) {
        this.strength = strength;
        this.agility = agility;
        this.inteligence = inteligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getInteligence() {
        return inteligence;
    }

    @Override
    public String toString() {

        //"Item:"
        //"  *  Strength: {Strength Value}"
        //"  *  Agility: {Agility Value}"
        //"  *  Intelligence: {Intelligence Value}"

        StringBuilder sb = new StringBuilder();

        sb
                .append("Item:").append(System.lineSeparator())
                .append("  *  Strength: ").append(this.getStrength()).append(System.lineSeparator())
                .append("  *  Agility: ").append(this.getAgility()).append(System.lineSeparator())
                .append("  *  Intelligence: ").append(this.getInteligence()).append(System.lineSeparator());

        return sb.toString();
    }
}
