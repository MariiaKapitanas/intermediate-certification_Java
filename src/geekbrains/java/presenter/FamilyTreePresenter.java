package geekbrains.java.presenter;

import geekbrains.java.model.FamilyTreeRepository;
import geekbrains.java.model.HumanInfo;
import geekbrains.java.model.Gender;
import geekbrains.java.view.FamilyTreeView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTreeRepository repository;

    public FamilyTreePresenter(FamilyTreeView view, FamilyTreeRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void start() {
        view.displayMenu();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender) {
        HumanInfo human = new HumanInfo(name, dob, dod, gender);
        repository.addHuman(human);
        view.displayMessage("Человек добавлен: " + human);
    }

    public List<HumanInfo> getAllHumans() {
        return repository.getAllHumans();
    }

    public void sortByName() {
        repository.sortByName();
        view.displayMessage("Люди отсортированы по имени.");
    }

    public void sortByDateOfBirth() {
        repository.sortByDateOfBirth();
        view.displayMessage("Люди отсортированы по дате рождения.");
    }

    public void deleteHuman(String name) {
        Optional<HumanInfo> human = repository.findByName(name);
        if (human.isPresent()) {
            repository.deleteHuman(human.get());
            view.displayMessage("Человек удален: " + human.get());
        } else {
            view.displayMessage("Человек с именем " + name + " не найден.");
        }
    }

    public void addParent(String childName, String parentName) {
        Optional<HumanInfo> child = repository.findByName(childName);
        Optional<HumanInfo> parent = repository.findByName(parentName);
        if (child.isPresent() && parent.isPresent()) {
            child.get().addParent(parent.get());
            view.displayMessage("Родитель добавлен: " + parentName + " для ребенка " + childName);
        } else {
            view.displayMessage("Человек не найден.");
        }
    }
}