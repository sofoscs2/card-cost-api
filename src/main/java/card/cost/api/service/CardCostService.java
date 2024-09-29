package card.cost.api.service;

import card.cost.api.model.CardInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

import static card.cost.api.utils.StaticContent.getCardInfoResponseDTO;

/**
 * Handles the logic to convert BinResponseDTO to appropriate CardInfoDTO
 *
 **/
@Service
public class CardCostService {

    @Autowired
    IINSearchAdapter iinSearchAdapter;


    public CardInfoDTO getCardInfo(BigInteger pan) {
        return getCardInfoResponseDTO(iinSearchAdapter.getBinResponse(pan));
    }



}
