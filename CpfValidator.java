public class CpfValidator {
    public static boolean validate(String cpf) {
        String ValidatedCpf = cleanCpf(cpf).substring(0, 9) + digitCalculation(10, cleanCpf(cpf).substring(0, 9)) + digitCalculation(11, cleanCpf(cpf).substring(0, 10));
        return cleanCpf(cpf).equals(ValidatedCpf);
    }

    public static String cleanCpf(String cpf) {
        return cpf.replace(".", "").replace("-", "");
    }

    public static int digitCalculation(int weight, String cpf) {

        int sum = 0;

        for (int i = 0; i < cpf.length(); i++) {
            sum += Integer.parseInt(String.valueOf(cpf.charAt(i))) * weight;
            weight--;
        }
        int digit = (sum * 10) % 11;
        if (digit == 10) {
            digit = 0;
            return digit;
        } else {
            return digit;
        }
    }
}