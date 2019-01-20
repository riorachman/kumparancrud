package com.rio.kumparan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "NEWS")
public class News extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -493279229535954563L;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String title;
	
	@NotNull
	@Lob
	private String content;
	
	@NotNull
	@Column(name = "STATUS")
	private String status;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "news_topics",
            joinColumns = { @JoinColumn(name = "news_id") },
            inverseJoinColumns = { @JoinColumn(name = "topic_id") })
	private Set<Topic> topics = new HashSet<Topic>();

	public News() {}

	public News(@NotNull @Size(max = 100) String title, @NotNull String content, @NotNull String status,
			Set<Topic> topics) {
		super();
		this.title = title;
		this.content = content;
		this.status = status;
		this.topics = topics;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	
}
