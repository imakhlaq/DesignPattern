package entities;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private Long id;
    private String name;
    private String address;
    //because theater will play list of movies
    private List<MovieSlot> movieSlots;

    Theater(Long id, String name, String address, List<MovieSlot> movieSlot) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.movieSlots = movieSlot;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MovieSlot> getMovieSlots() {
        return movieSlots;
    }

    public void setMovieSlots(List<MovieSlot> movieSlots) {
        this.movieSlots = movieSlots;
    }
}
