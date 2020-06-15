package com.epam.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Objects;

/**
 * @author ArtSCactus
 * @version 1.2
 */
@Entity
@Table(name = "notes", schema = "newsmanager")
public class NewsNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "title", length = 100)
    @Pattern(regexp = "[^<>]")
    @Size(min=1, max=100)
    private String title;
    @Column(name="date", length = 10)
    private Date date;
    @Column(name="brief", length = 500)
    @Pattern(regexp = "[^<>]")
    @Size(min=1, max=500)
    private String brief;
    @Column(name="content", length = 2048)
    @Pattern(regexp = "[^<>]")
    @Size(min=1, max=2048)
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
