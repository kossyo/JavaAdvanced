package command_pattern;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {

        if (this.attacker.getTarget() == null){
            throw new IllegalArgumentException("No target for attacker");
        }

        Target target = this.attacker.getTarget();
        double newHealth = target.getHealth() - this.attacker.getDmg();
        target.setHealth(newHealth);

        if (newHealth <= 0 ){
            this.attacker.addXp(target.getReward());
        }
    }
}
