package command_pattern;

public class Warrior implements Attacker  {
    private String id;
    private double dmg;
    private Target target;
    private int xp;

    public Warrior(String id, double dmg) {
        this.id = id;
        this.dmg = dmg;
        this.xp = 0;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public double getDmg() {
        return this.dmg;
    }

    @Override
    public void setTarget(Target target) {
        this.target = target;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    @Override
    public Target getTarget() {
        return this.target;
    }

    @Override
    public void addXp(int xp) {
         this.xp += xp;
    }

    public int getXp() {
        return this.xp;
    }
}
