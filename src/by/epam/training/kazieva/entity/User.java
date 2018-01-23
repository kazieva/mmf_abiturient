package by.epam.training.kazieva.entity;

public class User {
    private String login;
    private String password;
    private String key;
    private String role;
    private String fname;
    private String sname;

    public User() {
    }

    public User(String login, String password, String key, String role, String fname, String sname) {
        this.login = login;
        this.password = password;
        this.key = key;
        this.role = role;
        this.fname = fname;
        this.sname = sname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                ", role='" + role + '\'' +
                ", fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!key.equals(user.key)) return false;
        if (!role.equals(user.role)) return false;
        if (!fname.equals(user.fname)) return false;
        return sname.equals(user.sname);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + key.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + fname.hashCode();
        result = 31 * result + sname.hashCode();
        return result;
    }
}
