public interface BankaccountInterface {
    String fetchbalance(String password);

    String addmoney(double amount);

    String withdrawmoney(double amount,String password);

    String changepassword(String oldpassword, String newpassword);

    double calculateinterest(int year);
}
