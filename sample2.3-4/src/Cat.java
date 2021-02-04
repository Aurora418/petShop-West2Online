public class Cat extends Animal{

    public Cat(String sex, double weight, int age, double inPrice) {
        super(sex, weight, age, inPrice);
    }

    @Override
    public String toString() {
        return "[Cat] "+super.toString();
    }
}
