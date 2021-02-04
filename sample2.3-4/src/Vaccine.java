public class Vaccine {
    private String animalType;   // 给什么种类的动物使用
    private String function;  // 该疫苗的作用
    private int cnt;   // 需要打几针
    private double inPrice;  // 疫苗进价
    private double outPrice; // 疫苗售价

    // 功能参数
    public static final String COLD="Prevent from getting cold";
    public static final String FIP="Prevent from getting FIP";
    public static final String VERMIFUGE="Expelling parasite";

    private Vaccine(String animalType, String function, int cnt, double inPrice) {
        this.animalType = animalType;
        this.function = function;
        this.cnt = cnt;
        this.inPrice = inPrice;
        this.outPrice = inPrice * (1.2);
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public double getInPrice() {
        return inPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public String getFunction() {
        return function;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void ReduceCnt(){
        cnt--;
    }


    // 预防感冒
    public static Vaccine getColdVaccine(String animalType) {
        int cnt = 0, inPrice = 0;
        if (animalType.equals("Cat")) {
            cnt = 3;
            inPrice = 200;
        } else if (animalType.equals("Dog")) {
            cnt = 5;
            inPrice = 300;
        } else if (animalType.equals("Bird")) {
            cnt = 1;
            inPrice = 50;
        }
        return new Vaccine(animalType, COLD, cnt, inPrice);
    }

    // 猫传腹FIP
    public static Vaccine getFIPVaccine() {
        return new Vaccine("Cat", FIP, 5, 500);
    }

    // 驱虫
    public static Vaccine getVermifugeVaccine(String animalType) {
        int cnt = 0, inPrice = 0;
        if (animalType.equals("Cat")) {
            cnt = 5;
            inPrice = 100;
        } else if (animalType.equals("Dog")) {
            cnt = 7;
            inPrice = 150;
        } else if (animalType.equals("Bird")) {
            cnt = 3;
            inPrice = 50;
        }
        return new Vaccine(animalType, VERMIFUGE, cnt, inPrice);
    }

    @Override
    public String toString() {
        return "animalType='" + animalType + '\'' +
                " function='" + function + '\'' +
                " cnt=" + cnt +
                " inPrice=" + inPrice +
                " outPrice=" + outPrice;
    }
}
