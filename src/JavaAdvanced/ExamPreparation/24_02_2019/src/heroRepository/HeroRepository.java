package heroRepository;

import java.util.*;
import java.util.stream.Collectors;

public class HeroRepository {

    private Map<String, Hero> heroes;

    public HeroRepository() {
        this.heroes = new LinkedHashMap<>();
    }

    public void add(Hero hero) {

        this.heroes.put(hero.getName(), hero);
    }

    public void remove(String heroName) {

        this.heroes.remove(heroName);
    }

    public Hero getHeroWithHighestStrength() {

        return this.heroes.values().stream()
                .sorted((h1, h2) -> h2.getItem().getStrength() - h1.getItem().getStrength())
                .limit(1)
//                .collect(Collectors.toCollection(HashMap::new))
//                .
                .collect(Collectors.toList()).get(0);
    }

    public Hero getHeroWithHighestAgility() {

        return this.heroes.values().stream()
                .sorted((h1, h2) -> h2.getItem().getAgility() - h1.getItem().getAgility())
                .limit(1)
                .collect(Collectors.toList()).get(0);
    }

    public Hero getHeroWithHighestIntelligence() {

        return this.heroes.values().stream()
                .sorted((h1, h2) -> h2.getItem().getInteligence() - h1.getItem().getInteligence())
                .limit(1)
                .collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return this.heroes.size();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        this.heroes.values().forEach(sb::append);

        return sb.toString();
    }
}
