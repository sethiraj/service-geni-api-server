/**
 * 
 */
package com.mahelinc.servicegenie.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.mahelinc.servicegenie.entity.GarageServiceDetails;
import com.mahelinc.servicegenie.model.SearchCriteria;

/**
 * The Class GarageServiceSpecification.
 *
 * @author surendrane
 */
public class GarageServiceSpecification implements Specification<GarageServiceDetails> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The search criteria. */
	private SearchCriteria searchCriteria;

	/**
	 * Instantiates a new garage service specification.
	 *
	 * @param searchCriteria the search criteria
	 */
	public GarageServiceSpecification(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * To predicate.
	 *
	 * @param root the root
	 * @param query the query
	 * @param criteriaBuilder the criteria builder
	 * @return the predicate
	 */
	@Override
	public Predicate toPredicate(Root<GarageServiceDetails> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.isValue());
	}

}
