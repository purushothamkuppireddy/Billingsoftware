package com.capgemini.salesmanagement.userException;

public class QuantityExecption extends Exception {

	public QuantityExecption()
	{
		System.err.println("Please enter the valid quantity");
	}
}
