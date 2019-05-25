package com.vitusatest.numberformat.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vitusatest.numberformat.exceptionHandler.LimitCrossedException;

import junit.framework.Assert;

public class NumberToWordConvertOperationServiceImplTest {

	NumberToWordConvertOperationServiceImpl  numberToWordConvertOperationServiceImpl ;
	@Before
	public void setUp() throws Exception {
		numberToWordConvertOperationServiceImpl = new NumberToWordConvertOperationServiceImpl(); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertLessThanOneThousand() throws LimitCrossedException {
		Assert.assertEquals(" five hundred", numberToWordConvertOperationServiceImpl.convertLessThanOneThousand(500));
	}

	@Test
	public void testConvertNumberToWord() throws LimitCrossedException {
		Assert.assertEquals(" five hundred", numberToWordConvertOperationServiceImpl.convertLessThanOneThousand(500));
		Assert.assertEquals("one thousand", numberToWordConvertOperationServiceImpl.convertNumberToWord(1000));
	}

}
