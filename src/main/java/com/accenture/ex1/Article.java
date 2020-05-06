package com.accenture.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	private String firstName;
	private String subtitle;
	private String postDate;
	private String id;
	private String title;
	private String body;
}