package card.cost.api.controller;

import card.cost.api.model.CardInfoDTO;
import card.cost.api.model.CardNumberDTO;
import card.cost.api.service.CardCostService;
import card.cost.api.utils.V1;
import card.cost.api.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


/**
 * CardCostController takes care calls of type
 * Method: POST Url: https://{host}/rest/v1/payment-cards-cost
 *
 *  Response body of type CardInfoDTO in JSON format
 *
 */
@RestController
@RequestMapping(V1.URI_BASE)
public class CardCostController {

    @Autowired
    CardCostService cardCostService;

    @PostMapping(V1.PAYMENT_CARDS_COST_END_POINT)
    public DeferredResult<ResponseEntity<CardInfoDTO>>  greeting(@RequestBody CardNumberDTO dto) {
        DeferredResult<ResponseEntity<CardInfoDTO>> deferredResult = new DeferredResult<>();
        CardInfoDTO cardInfoDTO = new CardInfoDTO();

        // PAN length and https://binlist.net/ service response validation
        if (!Validator.hasPanValidLength(dto.getCardNumber()) || (cardInfoDTO = cardCostService.getCardInfo(dto.getCardNumber())) == null) {
                deferredResult.setResult(new ResponseEntity<>(cardInfoDTO, HttpStatus.BAD_REQUEST));
                return deferredResult;
        }

        deferredResult.setResult(new ResponseEntity<>(cardInfoDTO, HttpStatus.OK));
        return deferredResult;
    }
}
