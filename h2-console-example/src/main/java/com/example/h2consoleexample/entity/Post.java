package com.example.h2consoleexample.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "post")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
	@Type(type = "uuid-char")
	private UUID id;
	
	private String title;
	private String description;
	private String category;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
}
