package models;

/**
 * This class is our model for resources in the people table. It has 4 private fields,
 * a constructor, and public Getters and Setters.
 */
public class People {
    private int people_id;
    private String username;
    private int access_level;
    private String password;

    //constructor
    public People() {
    }

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccess_level() {
        return access_level;
    }

    public void setAccess_level(int access_level) {
        this.access_level = access_level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
