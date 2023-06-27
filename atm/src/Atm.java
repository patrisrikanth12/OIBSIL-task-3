
public class Atm {
    private String names[];
    private double balances[];
    private int n;

    public Atm() {
        this(0);
    }

    public Atm(int size) {
        n = 0;
        balances = new double[size];
        names = new String[size];

    }
    public int Fibn(String name) {
        for(int i = 0; i < n; i++)
        {
            if(names[i].equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }
    public boolean addClient(String name , double balance) {

        if(n < names.length && n < balances.length) {
            int index = Fibn(name);
            if(index == -1){
                names[n] = name;
                balances[n]=balance;
                n++;
                return true;
            }

            return false;
        }
        return false;

    }

    public boolean delClient(String name) {
        int index = Fibn(name);
        if(index == -1) {
            return false;
        }
        else {
            names[index] = names[n];
            balances[index ]= balances[n];
            n--;
            return true;
        }
    }
    public boolean deposit(String name , double amount) {
        int index = Fibn(name);
        if (index == -1)
            return false;
        double temp= balances[index];
        balances[index] += amount ;
        System.out.println(names[index] + "was " + temp + "now " + balances[index] );
        return true;
    }
    public boolean withdraw(String name , double amount) {
        int index=Fibn(name);
        if (index==-1 && balances[index]<amount)
            return false;
        else{
            double temp= balances[index];
            balances[index]-=amount;
            System.out.println(names[index]+" was"+ temp+", "+balances[index]);
            return  true;
        }
    }
    public boolean transfer(String fName , String tName , double amount) {
        int index1=Fibn(fName);
        int index2=Fibn(tName);
        if (index1 ==-1 || index2==-1 ||balances[index1]<amount){
            return false;
        }else {
            withdraw(fName,amount);
            deposit(tName,amount);
            return true;
        }
    }
    public void display(String name) {
        int index = Fibn(name);
        if(index == -1)
            System.out.println("Not found");
        else
        {
            System.out.println(names[index]+" "+ balances[index] + " SR");
        }
    }
    public String findmax() {//wrong
        if (n == 0)
            return null;
        double max = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (max < balances[i]) {
                max = balances[i];
                counter = i;
            }
        }
        return names[counter];
    }
}