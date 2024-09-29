package card.cost.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * supports BinResponseDTO json contents
 * country
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BinResponseDTO {

    @JsonProperty("country")
    private CountryDTO country;

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BinResponseDTO that = (BinResponseDTO) o;
        return Objects.equals(country, that.country) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }
}
