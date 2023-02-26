package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistencee.Id;
//import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "booksinfo")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    // 本のidを保持するフィールド
    private Integer id;

    @Column(name="title")
    // 本のタイトルを保持するフィールド
    private String title;


    @Column(name="price")
    // 本の値段を保持するフィールド
    private Integer price;
}