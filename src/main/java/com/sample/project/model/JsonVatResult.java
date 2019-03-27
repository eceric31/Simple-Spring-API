package com.sample.project.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains the countries with the lowest and highest vat.
 */
public class JsonVatResult {

	private final Map<String, Double> highestVats;
	private final Map<String, Double> lowestVats;

	/**
	 * Instantiates a new Json vat result.
	 *
	 * @param highestVats the highest vats
	 * @param lowestVats  the lowest vats
	 */
	public JsonVatResult(
			final Map<String, Double> highestVats,
			final Map<String, Double> lowestVats
	) {
		this.highestVats = highestVats;
		this.lowestVats = lowestVats;
	}

	/**
	 * Gets highest vats.
	 *
	 * @return the highest vats
	 */
	public Map<String, Double> getHighestVats() {
		return new HashMap<>(highestVats);
	}

	/**
	 * Gets lowest vats.
	 *
	 * @return the lowest vats
	 */
	public Map<String, Double> getLowestVats() {
		return new HashMap<>(lowestVats);
	}
}
