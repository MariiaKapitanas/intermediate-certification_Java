package geekbrains.java.view;

import geekbrains.java.presenter.FamilyTreePresenter;

public interface FamilyTreeView {
    void setPresenter(FamilyTreePresenter presenter);

    void displayMenu();
    void displayMessage(String message);
}