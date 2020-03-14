package command_pattern;

public interface Attacker {

    double getDmg();
    void setTarget(Target target);

    Target getTarget();
    void addXp(int xp);
}
