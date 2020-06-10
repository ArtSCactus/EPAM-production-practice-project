package com.epam.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Entity
@Table(name = "notes", schema = "newsmanager")
public class NewsNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="date")
    private Date date;
    @Column(name="brief")
    private String brief;
    @Column(name="content")
    private String content;

    public NewsNote() {
    }

    public NewsNote(String name, Date date, String brief, String content) {
        this.name = name;
        this.date = date;
        this.brief = brief;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(getName(), newsNote.getName()) &&
                Objects.equals(getDate(), newsNote.getDate()) &&
                Objects.equals(getBrief(), newsNote.getBrief()) &&
                Objects.equals(getContent(), newsNote.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDate(), getBrief(), getContent());
    }
}
