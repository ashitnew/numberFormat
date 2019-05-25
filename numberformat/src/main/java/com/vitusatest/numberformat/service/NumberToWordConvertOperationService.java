package com.vitusatest.numberformat.service;

import com.vitusatest.numberformat.exceptionHandler.LimitCrossedException;

public interface NumberToWordConvertOperationService {
	String convertLessThanOneThousand(int number) throws LimitCrossedException;
	String convertNumberToWord(int number) throws LimitCrossedException;
}
