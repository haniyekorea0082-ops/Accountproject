package single;

import dto.AccountDto;
import java.util.ArrayList;

public class Singleton {
    private static Singleton instance;
    public ArrayList<AccountDto> list = new ArrayList<>();

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}