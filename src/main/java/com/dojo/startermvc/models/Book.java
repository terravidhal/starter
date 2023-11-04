package com.dojo.startermvc.models;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


//Nb
/*
    @Entity: représente un modèle d'entité pour notre application
    @Table: définit cela comme une table dans la base de données
    @Id: définit ceci comme clé primaire
    @GeneratedValue : définit ceci comme une valeur auto-incrémentée
    @Size : ajoute une validation selon laquelle la colonne doit être dans la plage spécifiée
    @Min :  ajoute une validation selon laquelle la colonne doit être au moins la valeur spécifiée
    @NotNull : ajoute une validation selon laquelle la colonne ne doit pas être nulle
    @PrePersistexécute :  la méthode juste avant la création de l'objet
    @PreUpdateexécute :  une méthode lorsque l'objet est modifié 
 * 
 */



@Entity
@Table(name="books")
public class Book {
	@Id  // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200)
    private String title;
    @NotNull
    @Size(min = 5, max = 200)
    private String description;
    @NotNull
    @Size(min = 3, max = 40)
    private String language;
    @NotNull
    @Min(100)
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // 02 constructeurs , tjrs en avoir 02
    public Book() {
    }
    public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }
    
    // other getters and setters removed for brevity
    @PrePersist // extrait la date actuelle avant de l'enregistrer dns la database
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate // enregistr chaq fois q l'on fera une mise à jour
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    // Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}
