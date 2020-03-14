package command_pattern;

public interface Target {

    double getHealth();
    int getReward();

    void setHealth(double newHealth);
}
