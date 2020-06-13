package com.epam.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author ArtSCactus
 * @version 1.1
 */
@Entity
@Table(name = "notes", schema = "newsmanager")
public class NewsNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name="date")
    private Date date;
    @Column(name="brief")
    private String brief;
    @Column(name="content")
    private String content;

    public NewsNote() {
    }

    public NewsNote(String title, Date date, String brief, String content) {
        this.title = title;
        this.date = date;
        this.brief = brief;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsNote)) return false;
        NewsNote newsNote = (NewsNote) o;
        return Objects.equals(getTitle(), newsNote.getTitle()) &&
                Objects.equals(getDate(), newsNote.getDate()) &&
                Objects.equals(getBrief(), newsNote.getBrief()) &&
                Objects.equals(getContent(), newsNote.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDate(), getBrief(), getContent());
    }
}
