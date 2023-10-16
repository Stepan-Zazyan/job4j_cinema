package cinema.dto;

import java.util.Objects;

public class FilmDto {
    private int id;
    private String name;
    private String description;
    private int year;
    private int minimalAge;
    private int durationInMinutes;
    private String genre;

    public FilmDto(int id, String name, String description, int year, int minimalAge, int durationInMinutes, String genre) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.year = year;
        this.minimalAge = minimalAge;
        this.durationInMinutes = durationInMinutes;
        this.genre = genre;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FilmDto filmDto)) {
            return false;
        }
        return getId() == filmDto.getId() && getYear() == filmDto.getYear()
                && getMinimalAge() == filmDto.getMinimalAge()
                && getDurationInMinutes() == filmDto.getDurationInMinutes()
                && Objects.equals(getName(), filmDto.getName())
                && Objects.equals(getDescription(), filmDto.getDescription())
                && Objects.equals(getGenre(), filmDto.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getYear(), getMinimalAge(), getDurationInMinutes(), getGenre());
    }

    @Override
    public String toString() {
        return "FilmDto{" + "id=" + id
                + ", name='" + name
                + '\'' + ", description='" + description
                + '\'' + ", year=" + year
                + ", minimalAge=" + minimalAge
                + ", durationInMinutes=" + durationInMinutes
                + ", genre='" + genre
                + '\'' + '}';
    }
}
