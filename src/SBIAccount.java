import java.util.UUID;

public class SBIAccount implements BankaccountInterface {
    private String name;
    private String password;
    private String accountno;//UUID
    private double balance;
    final String IFSCcode = "SBI1234";
    final double rateofinterest = 8.0;

    public SBIAccount() {
    }

    public SBIAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountno = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIFSCcode() {
        return IFSCcode;
    }

    public double getRateofinterest() {
        return rateofinterest;
    }

    @Override
    public String fetchbalance(String password) {
        if(this.password.equals(password)){
            return "The balance of SBI account is"+this.balance;
        }
        return "Incorrect Password";
    }

    @Override
    public String addmoney(double amount) {
        this.balance +=amount;
        return "The balance of SBI account is " +this.balance;
    }

    @Override
    public String withdrawmoney(double amount, String password) {
        if(this.password.equals(password)){
            if(this.balance < amount){
                return "Insufficient balance";
            }
            this.balance -= amount;
            return "The current balance is :" +this.balance;
        }
        return "Incorrect Password";
    }

    @Override
    public String changepassword(String oldpassword, String newpassword) {
        if(this.password.equals(oldpassword)){
            this.password = newpassword;
            return "Password changed successfully";
        }

        return "Incorrect Password";
    }

    @Override
    public double calculateinterest(int year) {
        return (this.balance*year*rateofinterest)/100.0;
    }

    @Override
    public String toString() {
        return "SBIAccount{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", accountno='" + accountno + '\'' +
                ", balance=" + balance +
                ", IFSCcode='" + IFSCcode + '\'' +
                ", rateofinterest=" + rateofinterest +
                '}';
    }
}
