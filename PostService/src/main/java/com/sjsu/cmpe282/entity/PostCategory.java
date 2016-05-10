/**
 * 
 */
package com.sjsu.cmpe282.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * @author ruchira
 *
 */
@Table("post_category")
public class PostCategory {

	@PrimaryKey("id")
	private UUID id;

	@Column("name")
	private String categoryName;

	@Column("created")
	private Date createDate;

	/**
	 * @param id
	 * @param categoryName
	 * @param createDate
	 */
	public PostCategory(UUID id, String categoryName, Date createDate) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.createDate = createDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostCategory [id=" + id + ", categoryName=" + categoryName
				+ ", createDate=" + createDate + "]";
	}

	/**
	 * 
	 */
	public PostCategory() {
		super();
	}

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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

}
