package com.sample.project.controller;

import com.sample.project.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Represents the abstract controller, and contains common properties and methods for all controllers.
 */
public class AbstractController<S extends AbstractService> {

	protected S service;

	@Autowired
	public void setService(final S service) {
		this.service = service;
	}
}
