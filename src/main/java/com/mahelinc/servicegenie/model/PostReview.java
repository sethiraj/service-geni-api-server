/**
 * 
 */
package com.mahelinc.servicegenie.model;

import javax.persistence.Column;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author surendrane
 *
 */
public class PostReview {

	/** The garage name. */
	@Column(name = "GarageName")
	@ApiModelProperty(required = true)
	private String garageName;

	/** The rating. */
	@Column(name = "Rating")
	@ApiModelProperty(required = true)
	private String rating;

	/** The review. */
	@Column(name = "Review")
	@ApiModelProperty(required = true)
	private String review;

	/** The reviewer name. */
	@Column(name = "ReviewerName")
	@ApiModelProperty(required = true)
	private String reviewerName;

	/** The location address. */
	@Column(name = "Location")
	@ApiModelProperty(required = true)
	private String location;

	/**
	 * @return the garageName
	 */
	public String getGarageName() {
		return garageName;
	}

	/**
	 * @param garageName the garageName to set
	 */
	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * @return the reviewerName
	 */
	public String getReviewerName() {
		return reviewerName;
	}

	/**
	 * @param reviewerName the reviewerName to set
	 */
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
