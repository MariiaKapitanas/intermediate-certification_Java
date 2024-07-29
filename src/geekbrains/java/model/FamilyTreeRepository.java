package geekbrains.java.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class FamilyTreeRepository {
    private List<HumanInfo> humans = new ArrayList<>();

    public void addHuman(HumanInfo human) {
        humans.add(human);
    }

    public List<HumanInfo> getAllHumans() {
        return new ArrayList<>(humans);
    }

    public void sortByName() {
        humans.sort(Comparator.comparing(HumanInfo::getName));
    }

    public void sortByDateOfBirth() {
        humans.sort(Comparator.comparing(HumanInfo::getDateOfBirth));
    }

    public Optional<HumanInfo> findByName(String name) {
        return humans.stream().filter(h -> h.getName().equals(name)).findFirst();
    }

    public void deleteHuman(HumanInfo human) {
        humans.remove(human);
    }

    public void clear() {
        humans.clear();
    }
}