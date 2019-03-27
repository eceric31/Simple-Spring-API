package com.sample.project.model.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Maps the properties from the `application.properties` file.
 */
@Component
public class ApplicationConfiguration {

	@Value("${json.vat.resource.url}")
	private String jsonVatUrl;

	/**
	 * Gets json vat url.
	 *
	 * @return the json vat url
	 */
	public String getJsonVatUrl() {
		return jsonVatUrl;
	}
}
