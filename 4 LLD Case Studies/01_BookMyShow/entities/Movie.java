package entities;

import java.time.LocalDate;

public class Movie {
    // Private because of encapsulation
    private Long id;
    private String name;
    private String description;
    private Double duration;
    private LocalDate realiseDate;
    private String cast;
    private Language language;

    // initializing the attributes
    public Movie(Long id, String name, String description, Double duration, LocalDate realiseDate, String cast, Language language) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.realiseDate = realiseDate;
        this.cast = cast;
        this.language = language;
    }

    //getters and setters for access control (encapsulation)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public LocalDate getRealiseDate() {
        return realiseDate;
    }

    public void setRealiseDate(LocalDate realiseDate) {
        this.realiseDate = realiseDate;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
