package card.cost.api.utils;

import java.math.BigDecimal;

/**
 * Contains only country data required for task
 */
public enum CountryDataEnum {
    USA("840" , new BigDecimal(5) ),
    GREECE("300" , new BigDecimal(15) ),
    OTHER("-" , new BigDecimal(10) );

    private  String isoCode;
    private  BigDecimal cost;

    CountryDataEnum(String isoCode, BigDecimal cost) {
        this.isoCode = isoCode;
        this.cost = cost;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public static CountryDataEnum getCountryByIsoCode(String isoCode) {
        for (CountryDataEnum country : CountryDataEnum.values()) {
            if (country.getIsoCode().equals(isoCode)) {
                return country;
            }
        }
        return CountryDataEnum.OTHER;
    }
}
