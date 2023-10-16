package cinema.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class FilmSessionsDto {
    private int id;

    private String filmName;

    private String hallsName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int price;

    public FilmSessionsDto(int id, String filmName, String hallsName, LocalDateTime startTime, LocalDateTime endTime, int price) {
        this.id = id;
        this.filmName = filmName;
        this.hallsName = hallsName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getHallsName() {
        return hallsName;
    }

    public void setHallsName(String hallsName) {
        this.hallsName = hallsName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FilmSessionsDto that)) {
            return false;
        }
        return getId() == that.getId() && Objects.equals(getHallsName(), that.getHallsName())
                && getPrice() == that.getPrice() && Objects.equals(getFilmName(), that.getFilmName())
                && Objects.equals(getStartTime(), that.getStartTime())
                && Objects.equals(getEndTime(), that.getEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFilmName(), getHallsName(),
                getStartTime(), getEndTime(), getPrice());
    }

    @Override
    public String toString() {
        return "FilmSessionsDto{" + "id=" + id
                + ", filmName='" + filmName
                + '\'' + ", hallsName=" + hallsName
                + ", startTime=" + startTime
                + ", endTime=" + endTime
                + ", price=" + price + '}';
    }
}
