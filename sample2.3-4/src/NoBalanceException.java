import java.util.logging.Logger;

public class NoBalanceException extends RuntimeException{
    public void printNoBalance(){
        Main.logger.warning("[Warning] 余额不足！\n");
    }
}
