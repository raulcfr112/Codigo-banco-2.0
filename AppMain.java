public class AppMain {
    public static void main(String[] args) {
        CheckingAccount.addCheckingAccount("Raul", "50370274890", 50);
        CheckingAccount.deposit("50370274890", 10);
        try {
            CheckingAccount.withdraw("50370274890", 10);
        } catch (Exception e) {
            System.out.println("Valor de saque maior que o saldo em conta!");
        }
    }
}
