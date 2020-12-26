/**
 * 
 */
package com.mahelinc.servicegenie.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.mahelinc.servicegenie.entity.GarageService;
import com.mahelinc.servicegenie.model.SearchCriteria;

/**
 * @author surendrane
 *
 */
public class GarageServiceSpecification implements Specification<GarageService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchCriteria searchCriteria;

	public GarageServiceSpecification(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<GarageService> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.isValue());
	}

}
