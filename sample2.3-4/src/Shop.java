import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.List;

public class Shop implements petShop {
    private List<Animal> sellAnimals;   // 在售动物
    private List<Animal> fosterageAnimals;    // 寄养动物
    private double balance;   //余额

    // 每天寄养成本
    private final double birdPrice = 5;
    private final double catPrice = 20;
    private final double dogPrice = 30;

    // 默认寄养价格为寄养成本的1.3倍
    private final double multiple = 1.3;

    public Shop() {
        this.sellAnimals = new ArrayList<Animal>();
        this.fosterageAnimals = new ArrayList<Animal>();
        this.balance = 10000;
    }

    public void Vaccinate(setMeal meal, String function, String functinoName) {
        boolean isFind = false;
        for (var vaccine : meal.getVaccines()) {
            if (vaccine.getFunction().equals(function)) {
                isFind = true;
                vaccine.ReduceCnt();

                if (vaccine.getCnt() == 0)
                    meal.getAnimal().addHistory("打疫苗", "[" + functinoName + "]疫苗已打完");
                else if (vaccine.getCnt() == -1) {
                    vaccine.setCnt(0);
                    throw new DoneVaccineException(functinoName);
                } else
                    meal.getAnimal().addHistory("打疫苗", "[" + functinoName + "]疫苗剩余" + vaccine.getCnt() + "针");

                break;
            }
        }
        if(!isFind)
            throw new NoVaccineException(functinoName);
    }

    public List<Animal> getSellAnimals() {
        return sellAnimals;
    }

    public List<Animal> getFosterageAnimals() {
        return fosterageAnimals;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void Purchase(List<Animal> purchaseList) {
        for (var animal : purchaseList) {
            balance -= animal.getInPrice();
            if(balance<0){
                balance+=animal.getInPrice();
                throw new NoBalanceException();
            }
            sellAnimals.add(animal);
            animal.addHistory("进货", "进价："+animal.getInPrice());
        }
    }

    @Override
    public void SellMeal(setMeal meal) {
        double sellPrice=meal.getAnimal().getOutPrice();
        for (var vaccine : meal.getVaccines()) {
            balance -= vaccine.getInPrice();
            balance += vaccine.getOutPrice();
            sellPrice+=vaccine.getOutPrice();
        }

        balance += meal.getAnimal().getOutPrice();
        meal.getAnimal().addHistory("出售", "套餐售价："+sellPrice);
    }

    @Override
    public void addFosterage(Animal animal, int days) {
        double cost = 0;
        String animalType = animal.getClass().getSimpleName();
        if (animalType.equals("Cat"))
            cost = catPrice;
        else if (animalType.equals("Dog"))
            cost = dogPrice;
        else if (animalType.equals("Bird"))
            cost = birdPrice;

        balance -= cost * days;
        balance += cost * days * multiple;

        fosterageAnimals.add(animal);
        animal.addHistory("寄养", days + "天 " + cost * days * multiple + "元");
    }
}
