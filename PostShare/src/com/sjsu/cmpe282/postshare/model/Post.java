package com.sjsu.cmpe282.postshare.model;

import java.util.Date;
import java.util.UUID;

/**
 * @author ruchira
 *
 */
public class Post {

	private UUID id;

	private String category;

	private String headline;

	private String content;

	private Date createDate;

	private Date updateDate;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * @param headline
	 *            the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @param id
	 * @param category
	 * @param headline
	 * @param content
	 * @param rating
	 * @param createDate
	 * @param updateDate
	 */
	public Post(UUID id, String category, String headline, String content,
			Date createDate, Date updateDate) {
		super();
		this.id = id;
		this.category = category;
		this.headline = headline;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", category=" + category + ", headline="
				+ headline + ", content=" + content + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}

	/**
	 * @param category
	 * @param headline
	 * @param content
	 */
	public Post(String category, String headline, String content) {
		super();
		this.category = category;
		this.headline = headline;
		this.content = content;
	}

	/**
	 * 
	 */
	public Post() {
		super();
	}

}
