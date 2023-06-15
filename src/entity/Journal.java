package entity;

public class Journal {
    private final String data;
    private final String time;
    private final String operator;
    private final String action;

    public String getData() {
        return data;
    }

    public String getTime() {
        return time;
    }

    public String getOperator() {
        return operator;
    }

    public String getAction() {
        return action;
    }

    public Journal(String data, String time, String operator, String action) {
        this.data = data;
        this.time = time;
        this.operator = operator;
        this.action = action;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "data='" + data + '\'' +
                ", time='" + time + '\'' +
                ", operator='" + operator + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
