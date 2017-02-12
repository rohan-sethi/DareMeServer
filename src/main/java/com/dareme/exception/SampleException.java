package com.dareme.exception;

import com.dareme.util.messages.ErrorMessages;

/**
 * Created by vikram on 18/9/16.
 */
public class SampleException {
    public static class SampleError extends GenericException {
        public SampleError() {
            super(ErrorMessages.SAMPLE_ERROR_MESSAGE);
        }
    }
}
