package cinema.model;

import java.util.Map;
import java.util.Objects;

public class Users {

    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "full_name", "fullName",
            "email", "email",
            "password", "password"
            );

    private int id;

    private String fullName;

    private String email;

    private String password;

    public Users(int id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id
                + ", fullName='" + fullName
                + '\'' + ", email='" + email
                + '\'' + ", password='" + password
                + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Users users)) {
            return false;
        }
        return getId() == users.getId() && Objects.equals(getFullName(), users.getFullName())
                && Objects.equals(getEmail(), users.getEmail()) && Objects.equals(getPassword(), users.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getEmail(), getPassword());
    }

}
