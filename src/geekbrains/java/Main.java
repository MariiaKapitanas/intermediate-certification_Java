package geekbrains.java;

import geekbrains.java.model.FamilyTreeRepository;
import geekbrains.java.presenter.FamilyTreePresenter;
import geekbrains.java.view.ConsoleFamilyTreeView;
import geekbrains.java.view.FamilyTreeView;

public class Main {
    public static void main(String[] args) {
        FamilyTreeRepository repository = new FamilyTreeRepository();
        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view, repository);
        view.setPresenter(presenter);
        presenter.start();
    }
}