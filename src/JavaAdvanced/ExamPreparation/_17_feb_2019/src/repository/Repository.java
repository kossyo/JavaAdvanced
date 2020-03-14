package repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {

    //private static int counter = 0;
    private Map<Integer, Person> data;

    public Repository() {
        this.data = new LinkedHashMap<>();
    }

    public void add(Person person) {

        this.data.put(this.getCount(), person);
    }

    public Person get(int id) {
        //reutrn null?
        return this.data.get(id);
    }


    public boolean update(int id, Person newPerson) {

        if (!this.data.containsKey(id)) {
            return false;
        } else {
            this.data.put(id, newPerson);
            return true;
        }
    }

    public boolean delete(int id) {
        if (!this.data.containsKey(id)) {
            return false;
        } else {
            this.data.remove(id);
            return true;
        }

    }

    public int getCount() {
        return this.data.size();
    }

    public Map<Integer, Person> getData() {
        return this.data;
    }
}
