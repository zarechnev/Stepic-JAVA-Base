package P54_Stream;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Animal[] animalM1 = {
                new Animal("Cat"),
                new Animal("Dog"),
                new Animal("Elephant"),
                new Animal("Worm")};

        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);

        oos.writeInt(animalM1.length);

        for (Animal animal : animalM1) {
            oos.writeObject(animal);
        }

        oos.close();

        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            int count = objectInputStream.readInt();
            animals = new Animal[count];
            for (int i=0; i<count; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
        } catch (Exception e) {
            throw (new IllegalArgumentException(e));
        }

        return animals;
    }
}
