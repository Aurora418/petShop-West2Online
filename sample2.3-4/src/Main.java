import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger("Main");
    public static void main(String[] args) {
        // 宠物批发市场
        Animal bird1=new Bird("male",2.3,1,900);
        Animal bird2=new Bird("female",1.8,1,1500);
        Animal cat1=new Cat("male",2,0,2500);
        Animal cat2=new Cat("female",5,1,1500);
        Animal cat3=new Cat("male",4,1,2000);
        Animal dog=new Dog("male",7,2,1500);
        // 抛出余额不足异常
        // Animal dog=new Dog("male",7,2,5500);

        // 宠物店
        Shop petShop=new Shop();

        System.out.println("\n--初始余额--"+petShop.getBalance()+"\n");

        // TODO: 宠物店进货
        // 进货单
        List<Animal> purchaseList=new ArrayList<Animal>();
        purchaseList.add(bird1);
        purchaseList.add(cat1);
        purchaseList.add(cat2);
        purchaseList.add(dog);
        // 批量进货
        try{
            petShop.Purchase(purchaseList);
        }catch (NoBalanceException ne){
            ne.printNoBalance();
        }

        System.out.println("\n--进货后余额--"+petShop.getBalance()+"\n");

        // TODO: 宠物店根据已进货的动物设计出售套餐
        // 鸟套餐（搭配默认疫苗组）
        setMeal birdMealDefault=null;
        if(petShop.getSellAnimals().contains(bird1))
            birdMealDefault=new setMeal(bird1);

        // 猫1套餐（默认疫苗组）
        setMeal cat1MealDefault=null;
        if(petShop.getSellAnimals().contains(cat1))
            cat1MealDefault=new setMeal(cat1);

        // 猫2套餐（定制疫苗组：防感冒+猫传腹）
        List<Vaccine> vaccines=new ArrayList<Vaccine>();
        vaccines.add(Vaccine.getColdVaccine("Cat"));
        vaccines.add(Vaccine.getFIPVaccine());
        setMeal cat2MealSpecial=null;
        if(petShop.getSellAnimals().contains(cat2))
            cat2MealSpecial=new setMeal(cat2,vaccines);

        // 狗套餐1（默认疫苗组）
        setMeal dogMealDefault=null;
        if(petShop.getSellAnimals().contains(dog))
            dogMealDefault=new setMeal(dog);

        // 狗套餐2（定制疫苗组：驱虫）
        List<Vaccine> vaccines1=new ArrayList<Vaccine>();
        vaccines1.clear();
        vaccines1.add(Vaccine.getVermifugeVaccine("Dog"));
        setMeal dogMealSpecial=null;
        if(petShop.getSellAnimals().contains(dog))
            dogMealSpecial =new setMeal(dog,vaccines1);

        // TODO: Ricky购买猫2套餐
        if(cat2MealSpecial==null)
            logger.severe("[Error] 无该套餐\n");
        else{
            // 填写宠物主人资料
            cat2MealSpecial.getAnimal().setOwnerName("Ricky");
            cat2MealSpecial.getAnimal().setOwnerPhone("1111111111");
            // 主人给宠物命名
            cat2MealSpecial.getAnimal().setName("Luna");
            // 宠物店卖出宠物
            petShop.SellMeal(cat2MealSpecial);

            System.out.println("\n--卖出猫2套餐后余额--"+petShop.getBalance()+"\n");
        }

        // TODO: Valise购买狗套餐1
        if(dogMealDefault==null)
            logger.severe("[Error] 无该套餐\n");
        else {
            dogMealDefault.getAnimal().setOwnerName("Valise");
            petShop.SellMeal(dogMealDefault);

            System.out.println("\n--卖出狗套餐1后余额--"+petShop.getBalance()+"\n");
        }

        // TODO: Diana在宠物市场购买cat3后，送到宠物店寄养3天
        cat3.setOwnerName("Diana");
        cat3.setName("Lily");
        petShop.addFosterage(cat3,3);

        System.out.println("\n--寄养cat3后余额--"+petShop.getBalance()+"\n");

        try {
            // TODO: Ricky第1次带猫2来打感冒疫苗
            // 宠物店根据Ricky购买的猫2套餐打疫苗，打疫苗不花钱
            petShop.Vaccinate(cat2MealSpecial,Vaccine.COLD,"COLD");

            // TODO: Ricky第2次带猫2来打感冒疫苗
            petShop.Vaccinate(cat2MealSpecial,Vaccine.COLD,"COLD");

            // TODO: Ricky第3次带猫2来打感冒疫苗，感冒疫苗打完
            petShop.Vaccinate(cat2MealSpecial,Vaccine.COLD,"COLD");
        }catch (DoneVaccineException de){
            de.printNoRemain();
        }catch (NoVaccineException ne){
            ne.printNoSuchVaccine();
        }

        try {
            // TODO: Ricky带猫2来打驱虫疫苗，抛出异常
            petShop.Vaccinate(cat2MealSpecial,Vaccine.VERMIFUGE,"VERMIFUGE");
        }catch (DoneVaccineException de){
            de.printNoRemain();
        }catch (NoVaccineException ne) {
            ne.printNoSuchVaccine();
        }

        try {
            // TODO: Ricky第4次带猫2来打感冒疫苗，抛出异常
            petShop.Vaccinate(cat2MealSpecial,Vaccine.COLD,"COLD");
        }catch (DoneVaccineException de){
            de.printNoRemain();
        }catch (NoVaccineException ne) {
            ne.printNoSuchVaccine();
        }

        // TODO: 打印宠物店经手的宠物的基本信息与相关操作
        System.out.println("\n所有经手宠物信息：");
        for (var animal:petShop.getSellAnimals()) {
            System.out.println(animal);
            animal.printHistory();
            System.out.println();
        }

        for (var animal:petShop.getFosterageAnimals()) {
            System.out.println(animal);
            animal.printHistory();
            System.out.println();
        }

        // TODO: 打印宠物店余额
        System.out.println("--宠物店余额--"+petShop.getBalance()+"\n");

    }
    public static String getCurrentTime(){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss] ");
        return dateFormat.format(date);
    }
}
