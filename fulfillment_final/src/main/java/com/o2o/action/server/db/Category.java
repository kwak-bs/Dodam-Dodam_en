package com.o2o.action.server.db;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(indexes = { @Index(name = "aog_category_keycode_idx", columnList = "keycode") })
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	Category parent;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	Type catType;
	@Column(nullable = true)
	String keycode;
	int dispOrder;
	String speach;
	@Column(nullable = false)
	String title;
	@Column(length = 4096)
	String description;
	String synonyms;
	String imagePath;
	String imageSearchPath;
	String imageAltText;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
	private Detail detail;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
	@OrderBy("dispOrder ASC")
	private List<Category> children;

	public Category() {

	}

	public Category(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public String getKeycode() {
		return keycode;
	}

	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}

	public Type getCatType() {
		return catType;
	}

	public void setCatType(Type catType) {
		this.catType = catType;
	}

	public int getDispOrder() {
		return dispOrder;
	}

	public void setDispOrder(int dispOrder) {
		this.dispOrder = dispOrder;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public String getSpeach() {
		return speach;
	}

	public void setSpeach(String speach) {
		this.speach = speach;
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

	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageSearchPath() {
		return imageSearchPath;
	}

	public void setImageSearchPath(String imageSearchPath) {
		this.imageSearchPath = imageSearchPath;
	}

	public String getImageAltText() {
		return imageAltText;
	}

	public void setImageAltText(String imageAltText) {
		this.imageAltText = imageAltText;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public enum Type {
		CATEGORY, ITEM
	}
}
