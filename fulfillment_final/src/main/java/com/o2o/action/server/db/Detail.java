package com.o2o.action.server.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Detail {
	@OneToOne
	@MapsId
	@JsonIgnore
	Category category;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	Type itemType;
	String subTitle;
	String linkURL;
	Long cost = 0l;
	String relatedKeyword;
	String videoUrl;
	String backImgPath;

	@Id
	private Long id;

	public Detail() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Type getItemType() {
		return itemType;
	}

	public void setItemType(Type itemType) {
		this.itemType = itemType;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getLinkURL() {
		return linkURL;
	}

	public void setLinkURL(String linkURL) {
		this.linkURL = linkURL;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public String getRelatedKeyword() {
		return relatedKeyword;
	}

	public void setRelatedKeyword(String relatedKeyword) {
		this.relatedKeyword = relatedKeyword;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getBackImgPath() {
		return backImgPath;
	}

	public void setBackImgPath(String backImgPath) {
		this.backImgPath = backImgPath;
	}

	public enum Type {
		CUSTOMER_INFO, PRODUCT
	}
}
