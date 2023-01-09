package api.restful.raquelwinkeler.controller;

import api.restful.raquelwinkeler.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/math")
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    private Double sumValues(@PathVariable(value = "numberOne") String numberOne,
                             @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

       if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
           throw new UnsupportedMathOperationException("Please, set a numeric value!");
       }

       return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {

        if (strNumber != null) {
            String number = strNumber.replaceAll(",", ".");

            if (isNumeric(strNumber)) {
                return Double.parseDouble(number);
            }
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {

        if (strNumber != null) {
            String number = strNumber.replaceAll(",", ".");
            return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        }
        return false;
    }
}
