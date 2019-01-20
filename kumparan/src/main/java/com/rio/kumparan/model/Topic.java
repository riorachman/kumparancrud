package com.rio.kumparan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
public class Topic extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3921578645845888429L;
	
	@NotNull
	@Size(max=100)
	@NaturalId
	private String name;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "topics")
	private Set<News> news = new HashSet<News>();

	public Topic() {}

	/**
	 * @param name
	 * @param news
	 */
	public Topic(@NotNull @Size(max = 100) String name, Set<News> news) {
		super();
		this.name = name;
		this.news = news;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the news
	 */
	public Set<News> getNews() {
		return news;
	}

	/**
	 * @param news the news to set
	 */
	public void setNews(Set<News> news) {
		this.news = news;
	}

	
}
