package Models;

public class Command {
    private String type; // e.g., new, resolve, display, history
    private String customer;
    private String name;
    private String issue;

    public Command(String type, String customer, String name, String issue) {
        this.type = type;
        this.customer = customer;
        this.name = name;
        this.issue = issue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
