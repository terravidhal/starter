package com.dojo.startermvc.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.startermvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	// fonctionnalité suppléméntaire, pas besoin de preciser ls fonctionnalités 
	// CRUD (Create, Read(lecture et recuperation), Update, Delete) de base
	
	//  cette méthode récupère tous les livres de la base de données 
    List<Book> findAll();
    // cette méthode recherche des livres avec des descriptions contenant la chaîne de recherche 
    List<Book> findByDescriptionContaining(String search);
    // cette méthode compte combien de titres contiennent une certaine chaîne
    Long countByTitleContaining(String search);
    // cette méthode supprime un livre qui commence par un titre spécifique 
    Long deleteByTitleStartingWith(String search);
}
