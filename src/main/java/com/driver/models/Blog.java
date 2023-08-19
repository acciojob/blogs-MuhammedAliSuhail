package com.driver.models;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
 public class Blog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer BlogId;


 private String title;
 private String contant;
 private Date publishedDate;

    public Blog(Integer blogId, String title, String contant, Date publishedDate) {
        BlogId = blogId;
        this.title = title;
        this.contant = contant;
        this.publishedDate = publishedDate;
    }

    public Integer getBlogId() {
        return BlogId;
    }

    public Blog() {
    }

    public void setBlogId(Integer blogId) {
        BlogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImgList() {
        return imgList;
    }

    public void setImgList(List<Image> imgList) {
        this.imgList = imgList;
    }

    @ManyToOne
  @JoinColumn
  @JsonIgnore
  private User user;
  @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
  private List<Image> imgList=new ArrayList<>();
}