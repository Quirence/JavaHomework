package edu.phystech.hw2.analyzer;

import java.util.List;

public abstract class KeywordAnalyzer implements TextAnalyzer {

	private final List<String> keywords;
	private final Label tag;

	public KeywordAnalyzer(List<String> keywords, Label tag) {
		if (keywords == null || keywords.isEmpty()) {
			throw new IllegalArgumentException("Illegal argument: null or empty");
		}
		this.keywords = keywords;
		this.tag = tag;
	}

	public List<String> getKeywords() {
		return this.keywords;
	}
}