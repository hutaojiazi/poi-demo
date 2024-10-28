package com.poi.demo.service;

import com.poi.demo.dto.Trail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface TrailService
{
	/**
	 * Returns the requested page of trails
	 *
	 * @param pageable the page request criteria.
	 * @return the requested trails page
	 */
	Page<Trail> getAll(Pageable pageable);

	/**
	 * Retrieves an trail with provided id.
	 *
	 * @param id the resource identifier.
	 * @return the requested trail, or {@link Optional#empty()} if the resource is not found.
	 */
	Optional<Trail> get(String id);

	/**
	 * adds a new trail.
	 *
	 * @param trail the trail to add.
	 * @return the id of the trail created.
	 */
	String create(Trail trail);

	/**
	 * imports trails from csv file.
	 *
	 * @param csvFile the csv files to import the trails from.
	 */
	void importFromCsv(String csvFile);
}
