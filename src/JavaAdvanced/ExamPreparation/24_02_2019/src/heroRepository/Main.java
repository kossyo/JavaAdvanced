package heroRepository;

public class Main {
    public static void main(String[] args) {

        //Initialize the repository
        HeroRepository repository = new HeroRepository();
//Initialize entity
        Item item = new Item(23, 35, 48);
//Print Item
       // System.out.println(item);

        //Initialize entity
        Hero hero = new Hero("Hero Name", 24, item);
//Print Hero
        //System.out.println(hero);

        //Add Hero
        repository.add(hero);
//Remove Hero
        repository.remove("Hero Name");

        Item secondItem = new Item(100, 20, 13);
        Hero secondHero = new Hero("Second Hero Name", 125, secondItem);

//Add Heroes
        repository.add(hero);
        repository.add(secondHero);

        Hero heroStrength = repository.getHeroWithHighestStrength(); //returns secondHero
        Hero heroAbility = repository.getHeroWithHighestAgility(); //returns hero
        Hero heroIntelligence = repository.getHeroWithHighestIntelligence(); //returns hero

        System.out.print(repository);



    }
}
