package com.example.mycrud.Model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "story2")
public class Story2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storyId;

    @Column(name = "story_name")
    private String storyName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book2_id", referencedColumnName = "bookId")
    @JsonIgnoreProperties("storyList")
    private Book2 book;

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public Book2 getBook() {
        return book;
    }

    public void setBook(Book2 book) {
        this.book = book;
    }

}
