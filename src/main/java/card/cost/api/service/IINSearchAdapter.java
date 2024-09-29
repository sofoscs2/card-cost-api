package card.cost.api.service;

import card.cost.api.model.BinResponseDTO;
import card.cost.api.utils.StaticContent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;


/**
 * Take care of https://binlist.net/ search IIN API calls
 *
 */
@Service
public class IINSearchAdapter {

    private final RestTemplate restTemplate;

    public IINSearchAdapter(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     *  does POST call to binlist.net with response data to BinResponseDTO
     */
    public BinResponseDTO getBinResponse(BigInteger pan) {
        String requestURL = StaticContent.getBinListSearchURL(pan);
        try {
            return restTemplate.getForObject(requestURL, BinResponseDTO.class);
        } catch (RestClientException e) {
            return null;
        }
    }
}
