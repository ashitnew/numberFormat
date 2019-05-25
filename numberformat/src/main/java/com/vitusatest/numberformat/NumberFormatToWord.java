package com.vitusatest.numberformat;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.vitusatest.numberformat.exceptionHandler.LimitCrossedException;
import com.vitusatest.numberformat.service.NumberToWordConvertOperationService;
import com.vitusatest.numberformat.service.NumberToWordConvertOperationServiceImpl;

/**
 * Hello world!
 *
 */
public class NumberFormatToWord 
{
    public static void main( String[] args )
    {
    	System.out.println("Enter a number to conver in word : ");
    	Scanner sc = new Scanner(System.in);
    	try {
    		BigInteger number  = sc.nextBigInteger();
    		if(number.longValue() > 0 && number.longValue() <= 999999999) {
    			NumberToWordConvertOperationService convert  =  new NumberToWordConvertOperationServiceImpl();
    			//System.out.println(convert.convertLessThanOneThousand(5010));
	        	System.out.println(convert.convertNumberToWord(number.intValue()));
    		}else {
    			System.out.println("wrong input number should be greater than 0 and should be less than 1000000000");
    			main(args);
    		}
    	}catch(LimitCrossedException | InputMismatchException ex) {
    		System.out.println("*****Enter a value in number format***** ");
    		main(args);
    	}
    }
}
