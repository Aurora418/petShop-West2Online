import java.util.logging.Logger;

public class DoneVaccineException extends RuntimeException{
    private String functionName;
    public DoneVaccineException(String functionName){
        super();
        this.functionName=functionName;
    }
    public void printNoRemain(){
        Main.logger.warning("[Warning] ["+functionName+"]疫苗已打完!\n");
    }
}
