package domain;

public class Developer {
    /* ATTRIBUTES */
    private final String name;
    private String role;
    private boolean isLeadDeveloper;
    private boolean isTester;

    /* CONSTRUCTORS */
    public Developer(String name, String role, boolean isLeadDeveloper, boolean isTester) {
        this.name = name;
        this.role = role;
        this.isLeadDeveloper = isLeadDeveloper;
        this.isTester = isTester;
    }

    /* GETTERS */
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public boolean isLeadDeveloper() {
        return isLeadDeveloper;
    }
    public boolean isTester() {
        return isTester;
    }

    /* SETTERS */
    public void setRole(String role) {
        this.role = role;
    }
    public void setLeadDeveloper(boolean leadDeveloper) {
        isLeadDeveloper = leadDeveloper;
    }
    public void setTester(boolean tester) {
        isTester = tester;
    }

    /* METHODS */
}
