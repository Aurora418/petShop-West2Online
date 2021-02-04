import java.util.logging.Logger;

public class NoVaccineException extends RuntimeException{
    String functionName;
    public NoVaccineException(String functionName){
        super();
        this.functionName=functionName;
    }
    public void printNoSuchVaccine(){
        Main.logger.warning("[Warning] 套餐中没有["+functionName+"]疫苗！\n");
    }
}
