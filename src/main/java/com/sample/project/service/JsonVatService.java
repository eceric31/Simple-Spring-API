package com.sample.project.service;

import com.sample.project.exception.ServiceException;
import com.sample.project.model.JsonVatResult;
import com.sample.project.model.mapping.JsonVatResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Interacts with the json-vat api.
 */
@Component
public class JsonVatService extends AbstractService<JsonVatResponse> {

	public JsonVatResult fetchVats() throws ServiceException {
		JsonVatResponse vats = get(this.getConfiguration().getJsonVatUrl(), JsonVatResponse.class);
		return new JsonVatResult(resolveHighestVats(vats), resolveLowestVats(vats));
	}

	private Map<String, Double> resolveHighestVats(final JsonVatResponse vats) {
		Map<String, Double> result = new HashMap<>();
		for (JsonVatResponse.Rate rate : vats.getRates()) {
			result.put(
					rate.getName(),
					resolveVat(rate, Comparator.comparing(JsonVatResponse.Period::getEffectiveFrom))
			);
		}

		result = result
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.limit(3)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		return result;
	}

	private Map<String, Double> resolveLowestVats(final JsonVatResponse vats) {
		Map<String, Double> result = new HashMap<>();
		for (JsonVatResponse.Rate rate : vats.getRates()) {
			result.put(
					rate.getName(),
					resolveVat(rate, Comparator.comparing(JsonVatResponse.Period::getEffectiveFrom))
			);
		}

		result = result
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.limit(3)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		return result;
	}

	@SuppressWarnings("unchecked")
	private Double resolveVat(final JsonVatResponse.Rate rate, final Comparator comparator) {
		Optional<JsonVatResponse.Period> maxPeriod = rate
				.getPeriods()
				.stream()
				.max(comparator);

		return maxPeriod
				.map(period -> period.getVatRates().getStandard())
				.orElse(-1D);

	}
}
