package com.sample.project.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * A utility class for mapping objects into and from json.
 */
public class JSONConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(JSONConverter.class);
	private static ObjectMapper MAPPER = new ObjectMapper();

	private JSONConverter() {
		MAPPER.setDateFormat(new SimpleDateFormat("YYYY-MM-DD"));
	}

	public static String toJSON(Object source) {
		try {
			return MAPPER.writeValueAsString(source);
		} catch (JsonProcessingException e) {
			LOGGER.error("Failed to serialize object into json.", e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJSON(InputStream json, Class<T> clazz) {
		try {
			return MAPPER.readValue(json, clazz);
		} catch (IOException e) {
			LOGGER.error("Failed to deserialize json into object.", e);
			throw new RuntimeException(e);
		}
	}
}
