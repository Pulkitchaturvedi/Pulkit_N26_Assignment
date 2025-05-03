package model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {
    private long id;
    private String name;
    private List<String> photoUrls;
    private String status;

    // Constructors
    public Pet() {}

    public Pet(long id, String name, List<String> photoUrls, String status) {
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrls;
        this.status = status;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", status='" + status + '\'' +
                '}';
    }
}
