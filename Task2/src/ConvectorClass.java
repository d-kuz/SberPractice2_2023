import java.lang.reflect.Field;
import java.util.ArrayList;

import static java.nio.file.Files.size;

public class ConvectorClass {
    public static Animal mapToProductDto(Pet pet) throws NoSuchFieldException, IllegalAccessException {
        Animal animal = new Animal();
        Class p = pet.getClass();
        Class a = animal.getClass();

        Field name = p.getDeclaredField("name");
        Field nameA = a.getDeclaredField("title");
        name.setAccessible(true);
        nameA.setAccessible(true);
        nameA.set(animal, name.get(pet));

        Field status = p.getDeclaredField("status");
        status.setAccessible(true);
        Field availaible = a.getDeclaredField("isAvailaible");
        availaible.setAccessible(true);
        Field sold = a.getDeclaredField("isSolid");
        sold.setAccessible(true);

        if (status.get(pet).equals(Status.AVAILABLE)){
            availaible.set(animal, true);
            sold.set(animal, false);
        }else {
            availaible.set(animal, false);
            sold.set(animal, true);
        }

        Field photoList = p.getDeclaredField("photoList");
        photoList.setAccessible(true);
        Field photosMap = a.getDeclaredField("photosMap");
        photosMap.setAccessible(true);
        /***int i =0;
        while (photoList.get(pet)[i] ){

        }***/

        return animal;
    }
}
