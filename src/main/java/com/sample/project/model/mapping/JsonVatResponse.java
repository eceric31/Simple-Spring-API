package com.sample.project.model.mapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Maps the response of the call to the json-vat url.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonVatResponse {

	@JsonProperty("rates")
	private List<Rate> rates;

	/**
	 * Gets rates.
	 *
	 * @return the rates
	 */
	public List<Rate> getRates() {
		return rates;
	}

	/**
	 * Sets rates.
	 *
	 * @param rates the rates
	 */
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	/**
	 * Maps the parent array of rates.
	 */
	public static class Rate {
		@JsonProperty("name")
		private String name;

		@JsonProperty("code")
		private String code;

		@JsonProperty("country_code")
		private String countryCode;

		@JsonProperty("periods")
		private List<Period> periods;

		/**
		 * Gets name.
		 *
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets name.
		 *
		 * @param name the name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Gets code.
		 *
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * Sets code.
		 *
		 * @param code the code
		 */
		public void setCode(String code) {
			this.code = code;
		}

		/**
		 * Gets country code.
		 *
		 * @return the country code
		 */
		public String getCountryCode() {
			return countryCode;
		}

		/**
		 * Sets country code.
		 *
		 * @param countryCode the country code
		 */
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}

		/**
		 * Gets periods.
		 *
		 * @return the periods
		 */
		public List<Period> getPeriods() {
			return periods;
		}

		/**
		 * Sets periods.
		 *
		 * @param periods the periods
		 */
		public void setPeriods(List<Period> periods) {
			this.periods = periods;
		}
	}

	/**
	 * Maps to an object which contains an effectiveness date, and a list of actual vat rates.
	 */
	public static class Period {

		@JsonProperty("effective_from")
		private Date effectiveFrom;

		@JsonProperty("rates")
		private VatRate vatRates;

		/**
		 * Gets vat rates.
		 *
		 * @return the vat rates
		 */
		public VatRate getVatRates() {
			return vatRates;
		}

		/**
		 * Sets vat rates.
		 *
		 * @param vatRates the vat rates
		 */
		public void setVatRates(VatRate vatRates) {
			this.vatRates = vatRates;
		}

		/**
		 * Gets effective from.
		 *
		 * @return the effective from
		 */
		public Date getEffectiveFrom() {
			return effectiveFrom;
		}

		/**
		 * Sets effective from.
		 *
		 * @param effectiveFrom the effective from
		 */
		public void setEffectiveFrom(Date effectiveFrom) {
			this.effectiveFrom = effectiveFrom;
		}
	}

	/**
	 * Maps the most internal object which contains the actual rates.
	 */
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class VatRate {

		@JsonProperty("standard")
		private Double standard;

		/**
		 * Gets standard.
		 *
		 * @return the standard
		 */
		public Double getStandard() {
			return standard;
		}

		/**
		 * Sets standard.
		 *
		 * @param standard the standard
		 */
		public void setStandard(Double standard) {
			this.standard = standard;
		}
	}
}
