package com.sample.project.controller;

import com.sample.project.exception.ServiceException;
import com.sample.project.model.JsonVatResult;
import com.sample.project.service.JsonVatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The json-vat controller.
 *
 * Since the requirement is to write out to console the three EU countries with the highest and lowest vats,
 * there will be only one method, which when invoked (via api), will write said countries and their respective vats.
 */
@RestController
@RequestMapping(value = "json-vat")
public class JsonVatController extends AbstractController<JsonVatService> {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonVatController.class);

	@RequestMapping(value = "print")
	public void printVats() throws ServiceException {
		JsonVatResult vatResult = service.fetchVats();

		LOGGER.info("Top three EU countries with highest vat are:");
		vatResult.getHighestVats().forEach((key, value) -> LOGGER.info(key + " -> " + value + ";"));

		LOGGER.info("Top three EU countries with lowest vat are:");
		vatResult.getLowestVats().forEach((key, value) -> LOGGER.info(key + " -> " + value + ";"));
	}
}
