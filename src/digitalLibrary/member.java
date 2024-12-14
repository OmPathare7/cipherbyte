package digitalLibrary;

public class member {
    private String name;
    private String email;

    public member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
