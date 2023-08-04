package br.com.arthur.controllers;

import br.com.arthur.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.arthur.converters.NumberConverter.isNumeric;

import static br.com.arthur.converters.NumberConverter.convertToDouble;

@RestController
public class MathController {

    private static final String UNSUPORTABLE_OPERATION = "Please set a numeric value";

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum( //
                       @PathVariable(value = "numberOne") String numberOne, //
                       @PathVariable(value = "numberTwo") String numberTwo //
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException(UNSUPORTABLE_OPERATION);
        }
        return math.sum(convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub( //
                       @PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException(UNSUPORTABLE_OPERATION);
        }
        return math.sub(convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double mult( //
                       @PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException(UNSUPORTABLE_OPERATION);
        }
        return math.mult(convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double div( //
                        @PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException(UNSUPORTABLE_OPERATION);
        }
        return math.div(convertToDouble(numberOne) , convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media( //
                        @PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException(UNSUPORTABLE_OPERATION);
        }
        return math.media(convertToDouble(numberOne) , convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
    public Double raiz( //
                         @PathVariable(value = "numberOne") String numberOne
    ) {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedOperationException(UNSUPORTABLE_OPERATION);
        }
        return math.raiz(convertToDouble(numberOne));
    }

}
