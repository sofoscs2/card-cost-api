package card.cost.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * supports CountryDTO json contents
 * numeric
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDTO {

    @JsonProperty("numeric")
    private String numeric;
    public String getNumeric() {
        return numeric;
    }

    public void setNumeric(String numeric) {
        this.numeric = numeric;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CountryDTO that = (CountryDTO) o;
        return Objects.equals(numeric, that.numeric)  ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(numeric);
    }
}
