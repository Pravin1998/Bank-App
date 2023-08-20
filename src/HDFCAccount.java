import java.util.UUID;

public class HDFCAccount implements BankaccountInterface {

    private String name;

    private String accountno; //unique UUID

    private String password;

    private double  balance;

    final double rateofinterest = 7.1;

    final String IFSCcode = "HDFC1234";

    public HDFCAccount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateofinterest() {
        return rateofinterest;
    }

    public String getIFSCcode() {
        return IFSCcode;
    }

    @Override
    public String fetchbalance(String password) {
        if(this.password.equals(password)){
            return "Your balance is : " + this.balance;
        }
        return "Incorrect password";
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", accountno='" + accountno + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateofinterest=" + rateofinterest +
                ", IFSCcode='" + IFSCcode + '\'' +
                '}';
    }

    public HDFCAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountno = String.valueOf(UUID.randomUUID());
    }

    @Override
    public String addmoney(double amount) {
        this.balance += amount;
        return "Amount added succesfully, New Balance is: " + this.balance;

    }

    @Override
    public String withdrawmoney(double amount, String password) {
       if(this.password.equals(password)){
        if(this.balance < amount) {
            return "Insufficient balance";
        }
        this.balance -= amount;
        return "your balance is "+this.balance;
        }
       return "Incorrect Password";
    }

    @Override
    public String changepassword(String oldpassword, String newpassword) {
        if(this.password.equals(oldpassword)){
            this.password = newpassword;
            return "Password changed successfully";
        }
        return "Incorrect original password";
    }

    @Override
    public double calculateinterest(int year) {
        return (this.balance*year*rateofinterest)/100.0;
    }
}
