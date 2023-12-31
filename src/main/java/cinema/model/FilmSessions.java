package cinema.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class FilmSessions {

    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "film_id", "filmId",
            "halls_id", "hallsId",
            "start_time", "startTime",
            "end_time", "endTime",
            "price", "price");

    private int id;

    private int filmId;

    private int hallsId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int price;


    public FilmSessions(int id, int filmId, int hallsId, LocalDateTime startTime, LocalDateTime endTime, int price) {
        this.id = id;
        this.filmId = filmId;
        this.hallsId = hallsId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }


    @Override
    public String toString() {
        return "FilmSessions{" + "id=" + id
                + ", filmId=" + filmId
                + ", hallsId=" + hallsId
                + ", startTime=" + startTime
                + ", endTime=" + endTime
                + ", price=" + price
                + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FilmSessions that)) {
            return false;
        }
        return id == that.id && filmId == that.filmId && hallsId == that.hallsId
                && price == that.price && Objects.equals(startTime, that.startTime)
                && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filmId, hallsId, startTime, endTime, price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getHallsId() {
        return hallsId;
    }

    public void setHallsId(int hallsId) {
        this.hallsId = hallsId;
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
}
