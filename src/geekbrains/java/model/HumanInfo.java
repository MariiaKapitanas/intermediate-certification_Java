package geekbrains.java.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class HumanInfo implements Serializable {
    private String name;
    private LocalDate DateOfBirth;
    private LocalDate DateOfDeath;
    private Gender gender;
    private List<HumanInfo> parents;
    private List<HumanInfo> children;

    public HumanInfo(String name, LocalDate DateOfBirth, LocalDate DateOfDeath, Gender gender) {
        this.name = name;
        this.DateOfBirth = DateOfBirth;
        this.DateOfDeath = DateOfDeath;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return DateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public List<HumanInfo> getParents() {
        return parents;
    }

    public void addParent(HumanInfo parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            parent.addChild(this);
        }
    }

    public void addChild(HumanInfo child) {
        if (!children.contains(child)) {
            children.add(child);
            child.addParent(this);
        }
    }

    public List<HumanInfo> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "HumanInfo{" +
                "name='" + name + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", DateOfDeath=" + DateOfDeath +
                ", gender=" + gender +
                '}';
    }
}