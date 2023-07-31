package com.example.mycrud.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tutorials")
public class Tutorial {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String title;

  private String description;

  private boolean published;
  
  /*
  
  @ManyToMany(fetch = FetchType.LAZY,
  cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
@JoinTable(name = "tutorial_tags",
    joinColumns = { @JoinColumn(name = "tutorial_id") },
    inverseJoinColumns = { @JoinColumn(name = "tag_id") })
  @JsonBackReference
private Set<Tag> tags = new HashSet<>();
  
  */

  

  public Tutorial() {

  }

  public Tutorial(String title, String description, boolean published) {
    this.title = title;
    this.description = description;
    this.published = published;
  }

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public boolean isPublished() {
	return published;
}

public void setPublished(boolean published) {
	this.published = published;
}


/*

public void addTag(Tag tag) {
    this.tags.add(tag);
    tag.getTutorials().add(this);
  }
  
  public void removeTag(long tagId) {
    Tag tag = this.tags.stream().filter(t -> t.getId() == tagId).findFirst().orElse(null);
    if (tag != null) {
      this.tags.remove(tag);
      tag.getTutorials().remove(this);
    }
  }
  
  */

  
}
