import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private String sex;
    private double weight;
    private int age;
    private String ownerName;
    private String ownerPhone;
    private double inPrice;
    private double outPrice;
    private List<String> history;

    public Animal(String sex, double weight, int age, double inPrice) {
        this.name = "";
        this.sex = sex;
        this.weight = weight;
        this.age = age;
        this.ownerName = "";
        this.ownerPhone = "";
        this.inPrice = inPrice;
        this.outPrice = inPrice * (1.5);  // 默认售价为进价的1.5倍
        this.history=new ArrayList<String>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerPhone(String ownerPhone) {
        if (ownerPhone.length() != 11 || ownerPhone.length() != 8) {
            this.ownerPhone = "";
            Main.logger.info("[Info] 号码必须为11位或8位！\n");
        } else
            this.ownerPhone = ownerPhone;
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

    public void addHistory(String action,String content){
        history.add(Main.getCurrentTime()+action+" "+content);
    }

    public void printHistory(){
        for (var s:history) {
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                " sex='" + sex + '\'' +
                " weight=" + weight +
                " age=" + age +
                " ownerName='" + ownerName + '\'' +
                " ownerPhone='" + ownerPhone + '\'' +
                " inPrice=" + inPrice +
                " outPrice=" + outPrice;
    }
}
