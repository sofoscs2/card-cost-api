package card.cost.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;


/**
 * supports CardInfoDTO json contents
 * country - cost
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardInfoDTO {

    public CardInfoDTO() {}


    @JsonProperty("country")
    private String country;

    @JsonProperty("cost")
    private BigDecimal cost;


    public BigDecimal getCost() {
        return cost;
    }

    CardInfoDTO (Builder builder) {
        this.country = builder.country;
        this.cost = builder.cost;
    }

    public static class Builder {
        private String country;
        private BigDecimal cost;

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder cost(BigDecimal cost) {
            this.cost = cost;
            return this;
        }

        public CardInfoDTO build() {
            return new CardInfoDTO(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardInfoDTO that = (CardInfoDTO) o;
        return Objects.equals(country, that.country) && Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, cost);
    }
}
