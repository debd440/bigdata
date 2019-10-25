package com.codebasket.SpringGraphql.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="BOOK")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String id;
    private String isn;
    private String title;
    private String publisher;
    private String publishedDate;
    private String author;
}
