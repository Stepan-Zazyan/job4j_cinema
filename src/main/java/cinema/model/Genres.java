package cinema.model;

import java.util.Objects;

public class Genres {
    private int id;
    private String name;



    public Genres(String name) {
        this.name = name;
    }

    public Genres(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genres{" + "id=" + id
                + ", name='" + name
                + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Genres genres)) {
            return false;
        }
        return getId() == genres.getId() && Objects.equals(getName(), genres.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
