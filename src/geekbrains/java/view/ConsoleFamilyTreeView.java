package geekbrains.java.view;

import geekbrains.java.model.Gender;
import geekbrains.java.model.HumanInfo;
import geekbrains.java.presenter.FamilyTreePresenter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private FamilyTreePresenter presenter;

    @Override
    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить человека");
            System.out.println("2. Показать всех людей");
            System.out.println("3. Сортировать по имени");
            System.out.println("4. Сортировать по дате рождения");
            System.out.println("5. Удалить человека");
            System.out.println("6. Добавить родителя");
            System.out.println("7. Выход");
            System.out.print("Выберите пункт меню: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> addHuman();
                case 2 -> showAllHumans();
                case 3 -> sortByName();
                case 4 -> sortByDateOfBirth();
                case 5 -> deleteHuman();
                case 6 -> addParent();
                case 7 -> System.exit(0);
                default -> System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void addHuman() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (yyyy-mm-dd): ");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите дату смерти (или оставьте пустым): ");
        String DateOfDeathStr = scanner.nextLine();
        LocalDate DateOfDeath = DateOfDeathStr.isEmpty() ? null : LocalDate.parse(DateOfDeathStr);
        System.out.print("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        presenter.addHuman(name, DateOfBirth, DateOfDeath, gender);
    }

    private void showAllHumans() {
        List<HumanInfo> humans = presenter.getAllHumans();
        for (HumanInfo human : humans) {
            System.out.println(human);
        }
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void sortByDateOfBirth() {
        presenter.sortByDateOfBirth();
    }

    private void deleteHuman() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя человека для удаления: ");
        String name = scanner.nextLine();
        presenter.deleteHuman(name);
    }

    private void addParent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя ребенка: ");
        String childName = scanner.nextLine();
        System.out.print("Введите имя родителя: ");
        String parentName = scanner.nextLine();
        presenter.addParent(childName, parentName);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}