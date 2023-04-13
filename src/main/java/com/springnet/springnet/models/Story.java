package com.springnet.springnet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "stories")
@Data
public class Story {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    private Follow relation;

    @Column(name = "media_url")
    private String media;

    // @Column(name = "duration")
    // private int duration;

    // @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
    // private List<StoryView> views;
}
