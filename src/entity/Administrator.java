package entity;

public class Administrator extends User{
    private String account;
    private String password;

    public Administrator(String account, String password) {
        super(account, password);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
