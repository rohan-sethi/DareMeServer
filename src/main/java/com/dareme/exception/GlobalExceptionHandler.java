package com.dareme.exception;

import com.dareme.dto.ResponseDto;
import com.dareme.enums.ErrorResponse;
import com.dareme.util.response.PrepareResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import tv.videoready.logger.LoggerFactory;

/**
 * The {@link GlobalExceptionHandler} handles exceptions globally for all exception subtypes.
 *
 * @author Vikram Jakhar
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

  //  private static final Logger log = LoggerFactory.make();
    @Autowired
    private PrepareResponseUtil responseUtil;


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ResponseDto exception(Exception e) {
  //      log.error(e.getMessage(), e);
        return responseUtil.exception(e, ErrorResponse.BAD_REQUEST);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = GenericException.class)
    public ResponseDto handleGenericException(GenericException e) {
   //     log.debug(e.getMessage());
        return responseUtil.exception(e);
    }

}
