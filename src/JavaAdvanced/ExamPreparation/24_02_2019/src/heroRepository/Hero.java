package heroRepository;

public class Hero {

    String name;
    int level;
    Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        //"Hero: {Name} – {Level}"
        //"  *  Strength: {Strength Value}"
        //"  *  Agility: {Agility Value}"
        //"  *  Intelligence: {Intelligence Value}"

        sb
                .append(String.format("Hero: %s – %s", this.name, this.level)).append(System.lineSeparator())
                .append(String.format("  *  Strength: %s", this.item.getStrength())).append(System.lineSeparator())
                .append(String.format("  *  Agility: %s", this.item.getAgility())).append(System.lineSeparator())
                .append(String.format("  *  Intelligence: %s", this.item.getInteligence())).append(System.lineSeparator());

        return sb.toString();
    }
}
