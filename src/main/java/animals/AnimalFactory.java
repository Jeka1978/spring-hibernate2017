package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class AnimalFactory {
    public List<Animal> createZoo(int x) {
        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            animals.add(createRandomAnimal());
        }
        return animals;
    }

    private Animal createRandomAnimal() {
        Random random = new Random();
       /* int i = random.nextInt(3);

        }*/
        return null;

    }
}





