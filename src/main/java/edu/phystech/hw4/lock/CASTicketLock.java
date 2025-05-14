package edu.phystech.hw4.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kzlv4natoly
 */

public class CASTicketLock {
	private final AtomicInteger nextTicket = new AtomicInteger();
	private final AtomicInteger currentTicket = new AtomicInteger();

	public void lock() {
		int thisTicket = nextTicket.getAndIncrement();
		while (thisTicket != currentTicket.get()) {
			Thread.yield(); // Пустой while может нагружать CPU (проверено на моем проекте по физике)
			// А еще компилятор ругается
		}
	}

	public void unlock() {
		currentTicket.getAndIncrement();
	}
}