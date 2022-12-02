import java.util.ArrayList;
import java.util.List;

public class Agency {

    static List<CheckingAccount> checkingAccounts = new ArrayList<>();

    public Agency() {

    }

    public static void addAccountInList(CheckingAccount createAccount) {
        checkingAccounts.add(createAccount);
    }

    public static List<CheckingAccount> getCheckingAccounts() {
        return checkingAccounts;
    }

    public static void setCheckingAccounts(List<CheckingAccount> checkingAccounts) {
        Agency.checkingAccounts = checkingAccounts;
    }
}
