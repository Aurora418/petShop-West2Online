import java.util.ArrayList;
import java.util.List;

public class setMeal {
    private Animal animal;
    private List<Vaccine> vaccines;

    // 定制搭配疫苗组
    public setMeal(Animal animal, List<Vaccine> vaccines) {
        this.animal = animal;
        this.vaccines = vaccines;
    }

    // 默认疫苗组
    public setMeal(Animal animal) {
        this.animal = animal;

        vaccines = new ArrayList<Vaccine>();
        String animalType = animal.getClass().getSimpleName();

        vaccines.add(Vaccine.getColdVaccine(animalType));
        if (animalType.equals("Cat"))
            vaccines.add(Vaccine.getFIPVaccine());
        vaccines.add(Vaccine.getVermifugeVaccine(animalType));
    }

    public Animal getAnimal() {
        return animal;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    @Override
    public String toString() {
        return "[套餐信息] " +
                "animal=" + animal +
                "\nvaccines=" + vaccines;
    }
}
