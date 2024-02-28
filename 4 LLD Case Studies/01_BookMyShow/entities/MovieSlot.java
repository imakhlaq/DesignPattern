package entities;

import java.time.LocalTime;

public class MovieSlot {
    private String movieName;
    private LocalTime startTime;
    private LocalTime endTime;

    public MovieSlot(String movieName, LocalTime startTime, LocalTime endTime) {
        this.movieName = movieName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
