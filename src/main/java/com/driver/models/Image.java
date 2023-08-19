package com.driver.models;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ImageId;

    private String description;
    private String diemnsions;

    public Image(Integer imageId, String description, String diemnsions) {
        ImageId = imageId;
        this.description = description;
        this.diemnsions = diemnsions;
    }

    public Integer getImageId() {
        return ImageId;
    }

    public void setImageId(Integer imageId) {
        ImageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image(String description, String diemnsions, Blog blog) {
        this.description = description;
        this.diemnsions = diemnsions;
        this.blog = blog;
    }

    public String getDiemnsions() {
        return diemnsions;
    }

    public void setDiemnsions(String diemnsions) {
        this.diemnsions = diemnsions;
    }
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Blog blog;
}