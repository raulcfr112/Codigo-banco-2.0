public class CheckingAccount extends Agency {
    private String clientName, clientCpf;
    private float openingBalance;

    public CheckingAccount(String clientName, String clientCpf, float openingBalance) {
        super();
        this.clientName = clientName;
        this.clientCpf = clientCpf;
        this.openingBalance = openingBalance;
    }

    public static boolean checkData(String clientCpf, float openingBalance) {
        return CpfValidator.validate(clientCpf) && !(openingBalance <= 0);
    }

    public static void addCheckingAccount(String clientName, String clientCpf, float openingBalance) {
        if (checkData(clientCpf, openingBalance)) {
            CheckingAccount createAccount = new CheckingAccount(clientName, clientCpf, openingBalance);
            addAccountInList(createAccount);

            System.out.println("Conta criada!");
        } else {
            System.out.println("Erro na validacao dos seus dados, cpf invalido ou saldo inicial menor que 0!");
        }
    }

    public static void deposit(String clientCpf, float depositAmount) {
        for (CheckingAccount checkingAccount : checkingAccounts) {
            if (checkingAccount.clientCpf.equals(clientCpf)) {
                float aux = checkingAccount.getOpeningBalance();
                checkingAccount.setOpeningBalance(depositAmount + aux);
            }
        }
        System.out.println("Deposito realizado!");
    }

    public static void withdraw(String clientCpf, float withdrawAmount) throws Exception {
        for (CheckingAccount checkingAccount : checkingAccounts) {
            if (checkingAccount.clientCpf.equals(clientCpf)) {
                float aux = checkingAccount.getOpeningBalance();
                if ((aux - withdrawAmount) <= 0) {
                    throw new Exception();
                }
                checkingAccount.setOpeningBalance(withdrawAmount - aux);
                System.out.println("Saque realizado!");
            }
        }
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public float getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(float openingBalance) {
        this.openingBalance = openingBalance;
    }
}
