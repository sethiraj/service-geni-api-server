/**
 * Entity Model class for Garage Rating 
 */
package com.mahelinc.servicegenie.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Lob;

/**
 * The Class GarageRating.
 *
 * @author surendrane
 */
@Entity
@Table(name = "GarageRating")
public class GarageRating implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	/** The garage name. */
	@Column(name = "GarageName")
	private String garageName;

	/** The rating. */
	@Column(name = "Rating")
	private double rating;

	/** The review. */
	@Lob
	@Column(name = "Review")
	private String review;

	/** The reviewer name. */
	@Column(name = "ReviewerName")
	private String reviewerName;

	/** The review date. */
	@Column(name = "ReviewDate")
	private Timestamp reviewDate = new Timestamp(System.currentTimeMillis());
	
	/** The location address. */
	@Column(name = "Location")
	private String location;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the garage name.
	 *
	 * @return the garage name
	 */
	public String getGarageName() {
		return garageName;
	}

	/**
	 * Sets the garage name.
	 *
	 * @param garageName the new garage name
	 */
	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Gets the review.
	 *
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * Sets the review.
	 *
	 * @param review the new review
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * Gets the reviewer name.
	 *
	 * @return the reviewer name
	 */
	public String getReviewerName() {
		return reviewerName;
	}

	/**
	 * Sets the reviewer name.
	 *
	 * @param reviewerName the new reviewer name
	 */
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	/**
	 * Gets the review date.
	 *
	 * @return the review date
	 */
	public Timestamp getReviewDate() {
		return reviewDate;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "GarageRating [id=" + id + ", garageName=" + garageName + ", rating=" + rating + ", review=" + review
				+ ", reviewerName=" + reviewerName + ", reviewDate=" + reviewDate + ", location=" + location + "]";
	}

}
