package geekbrains.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileFamilyTreeRepository extends FamilyTreeRepository {
    private String filePath;

    public FileFamilyTreeRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void addHuman(HumanInfo human) {
        super.addHuman(human);
        saveToFile();
    }

    @Override
    public void deleteHuman(HumanInfo human) {
        super.deleteHuman(human);
        saveToFile();
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(super.getAllHumans());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<HumanInfo> humans = (List<HumanInfo>) ois.readObject();
            super.clear();
            for (HumanInfo human : humans) {
                super.addHuman(human);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
