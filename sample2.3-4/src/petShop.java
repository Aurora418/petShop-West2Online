import java.util.List;

public interface petShop {
    // TODO: 批量进货
    void Purchase(List<Animal> animals);

    // TODO: 出售套餐，同时计算余额
    void SellMeal(setMeal meal);

    // TODO: 寄养宠物，同时计算余额
    void addFosterage(Animal animal, int days);
}
