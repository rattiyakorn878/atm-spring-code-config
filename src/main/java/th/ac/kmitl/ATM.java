package th.ac.kmitl;

public class ATM {
    private Bank bank;
    private Customer loginCustomer;
    public ATM(Bank bank) {
        this.bank = bank;
        this.loginCustomer = null;
    }

    public String validateCustomer(int id, int pin) {
        Customer customer = bank.findCustomer(id);
        if (customer != null && customer.checkPin(pin)) {ฟ
            loginCustomer = customer;
            return loginCustomer.getName();
        }
        return null;
    }

    public void withdraw(double amount) {
        loginCustomer.getAccount().withdraw(amount);
    }

    public void deposit(double amount) {
        loginCustomer.getAccount().depossit(amount);
    }

    public double getBalance() {
        return loginCustomer.getAccount().getBalance();
    }

    public void transfer(int receivingId, double amount) {
        Customer receivingCustomer = bank.findCustomer(receivingId);
        loginCustomer.getAccount().withdraw(amount);
        receivingCustomer.getAccount().depossit(amount);
    }

    public void end() {
        loginCustomer = null;
    }
}
