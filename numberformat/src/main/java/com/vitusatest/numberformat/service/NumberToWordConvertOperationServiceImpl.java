package com.vitusatest.numberformat.service;

import com.vitusatest.numberformat.constants.NumberConstants;
import com.vitusatest.numberformat.exceptionHandler.LimitCrossedException;

public class NumberToWordConvertOperationServiceImpl implements NumberToWordConvertOperationService {
	public String convertLessThanOneThousand(int number) throws LimitCrossedException {
		if (number > 999) {
			throw new LimitCrossedException("number should be less than 1000 and greater than 0");
		} else {
			String current;
			if (number % 100 < 20) {
				current = NumberConstants.NUMBER_VALUES[number % 100];
				number /= 100;
			} else {
				current = NumberConstants.NUMBER_VALUES[number % 10];
				number /= 10;

				current = NumberConstants.TENS_VALUES[number % 10] + current;
				number /= 10;
			}
			if (number == 0)
				return current;
			return NumberConstants.NUMBER_VALUES[number] + " hundred" + current;
		}
	}

	public String convertNumberToWord(int number) throws LimitCrossedException {
		String word;
		String current = "";
		String lowerNumberValues;
		int place = 0;
		if (number <= 0 && number > 999999999) {
			throw new LimitCrossedException("number should be less than 999999999 and greater than 0");
		} else {

			do {
				int n = number % 1000;
				if (n != 0) {
					lowerNumberValues = convertLessThanOneThousand(n);
					current = lowerNumberValues + NumberConstants.HIGHER_VALUES[place] + current;
				}
				place++;
				number /= 1000;
				word = current;
			} while (number > 0);
			return word.trim();
		}
	}
}
