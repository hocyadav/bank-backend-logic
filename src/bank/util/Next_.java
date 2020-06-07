package bank.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Hariom Yadav | 06-Jun-2020
 *
 */
public class Next_ {

	private static final AtomicInteger accountNumber = new AtomicInteger(0);
	private static final AtomicInteger transactionID = new AtomicInteger(0);
	private static final AtomicInteger branchID = new AtomicInteger(0);

	public static Integer accNu() {
		return accountNumber.incrementAndGet();
	}

	public static Integer txnID() {
		return transactionID.incrementAndGet();
	}

	public static Integer branchID() {
		return branchID.incrementAndGet();
	}
}
