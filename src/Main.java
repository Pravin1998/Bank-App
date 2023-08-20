public class Main {
    public static void main(String[] args) {
        HDFCAccount pravinacc = new HDFCAccount("Pravin","Pravin22",20000);
        System.out.println(pravinacc);

        //fetchbalance
        System.out.println(pravinacc.fetchbalance("random")); //wrong password
        System.out.println(pravinacc.fetchbalance("Pravin22"));

        System.out.println(pravinacc.addmoney(5000));

        System.out.println(pravinacc.withdrawmoney(26000,"Pravin22"));
        System.out.println(pravinacc.withdrawmoney(2400,"Pravin22"));

        System.out.println(pravinacc.changepassword("Pravin22","Pravin"));
        System.out.println(pravinacc.fetchbalance("Pravin"));

        System.out.println(pravinacc.calculateinterest(6));

    }
}