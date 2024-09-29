package card.cost.api.utils;

import card.cost.api.model.BinResponseDTO;
import card.cost.api.model.CardInfoDTO;
import org.springframework.util.ObjectUtils;

import java.math.BigInteger;

import static card.cost.api.utils.CountryDataEnum.getCountryByIsoCode;

/**
 * Collection of static method
 */
public class StaticContent {

    public static final String GREECE_ISO2_CODE = "300";
    public static final String USA_ISO2_CODE = "840";
    private static final String BIN_LIST_SEARCH_URL = "https://lookup.binlist.net/";


    /**
     * Delegates binlist API  Response and converts it to  CardInfoDTO accordingly
     * @param dto
     * @return CardInfoDTO
     */
    public static CardInfoDTO getCardInfoResponseDTO(BinResponseDTO dto) {

        if (!ObjectUtils.isEmpty(dto) && !ObjectUtils.isEmpty(dto.getCountry())) {
            CountryDataEnum country = getCountryByIsoCode(dto.getCountry().getNumeric());
            switch (country) {
                case USA:
                    return new CardInfoDTO.Builder().country(CountryDataEnum.USA.getIsoCode()).cost(CountryDataEnum.USA.getCost()).build();
                case GREECE:
                    return new CardInfoDTO.Builder().country(CountryDataEnum.GREECE.getIsoCode()).cost(CountryDataEnum.GREECE.getCost()).build();
                default:
                    return new CardInfoDTO.Builder().country(dto.getCountry().getNumeric()).cost(CountryDataEnum.OTHER.getCost()).build();
            }
        }
        return null;
    }

    public static String getIIN(String pan) {
        return pan.substring(0,6);
    }

    public static String getBinListSearchURL(BigInteger pan) {
        return BIN_LIST_SEARCH_URL +  getIIN(pan.toString());
    }
}
