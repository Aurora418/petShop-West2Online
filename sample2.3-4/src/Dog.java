public class Dog extends Animal{

    public Dog(String sex, double weight, int age, double inPrice) {
        super(sex, weight, age, inPrice);
    }

    @Override
    public String toString() {
        return "[Dog] "+super.toString();
    }
}
