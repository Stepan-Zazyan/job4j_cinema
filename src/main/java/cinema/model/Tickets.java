package cinema.model;

import java.util.Map;
import java.util.Objects;

public class Tickets {

    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "session_id", "sessionId",
            "row_number", "rowNumber",
            "place_number", "placeNumber",
            "user_id", "userId"
    );

    private int id;
    private int sessionId;
    private int rowNumber;
    private int placeNumber;
    private int userId;

    public Tickets(int id, int sessionId, int rowNumber, int placeNumber, int userId) {
        this.id = id;
        this.sessionId = sessionId;
        this.rowNumber = rowNumber;
        this.placeNumber = placeNumber;
        this.userId = userId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Tickets{" + "id=" + id
                + ", sessionId=" + sessionId
                + ", rowNumber=" + rowNumber
                + ", placeNumber=" + placeNumber
                + ", userId=" + userId
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tickets tickets)) {
            return false;
        }
        return getId() == tickets.getId() && getSessionId() == tickets.getSessionId()
                && getRowNumber() == tickets.getRowNumber() && getPlaceNumber() == tickets.getPlaceNumber()
                && getUserId() == tickets.getUserId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSessionId(), getRowNumber(), getPlaceNumber(), getUserId());
    }
}
