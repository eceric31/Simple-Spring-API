package com.sample.project.service;

import com.sample.project.exception.ServiceException;
import com.sample.project.model.configuration.ApplicationConfiguration;
import com.sample.project.util.JSONConverter;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * An abstract class that contains common properties and methods for all services.
 */
@Component
public abstract class AbstractService<R> {

	@Autowired
	private ApplicationConfiguration configuration;

	private final HttpClient httpClient = HttpClientBuilder.create().build();

	protected ApplicationConfiguration getConfiguration() {
		return configuration;
	}

	protected R get(final String url, final Class<R> clazz) throws ServiceException {
		try {
			HttpResponse response = httpClient.execute(new HttpGet(url));

			switch (response.getStatusLine().getStatusCode()) {
				case HttpStatus.SC_OK:
					return JSONConverter.fromJSON(response.getEntity().getContent(), clazz);
				case HttpStatus.SC_NOT_FOUND:
					throw new ServiceException("No resource found for the given URL.");
				default:
					// Nothing to do here
			}

			throw new ServiceException("Return status code doesn't match any handled status codes");
		} catch (IOException e) {
			throw new ServiceException("Failed to fetch resource.", e);
		}
	}
}
