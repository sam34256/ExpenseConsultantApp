package com.example.expenseconsultantapp.main_logic;

import com.example.expenseconsultantapp.entities.Transaction;



public class DataTransfer {

	private String tDate;
	// ... Both GUI programmers and LOGIC programmers are allowed to add fields and
	// corresponding methods to convey functionality back and forth between LOGIC
	// and GUI.

	public DataTransfer() {
		reset();
	}

	/**
	 * Resets all fields to "", null, or zero.
	 */
	public void reset() {
		tDate = "";
		// ...
	}

	public String getTDate() {
		return tDate;
	}

	public void setTDate(String tDate) {
		this.tDate = tDate;
	}

	// getters and setters: ...

	public void setTFields(Transaction transaction) {
		tDate = Transaction.returnMMslashDDFromCalendar(transaction.getPostedDate());
		// ...
	}

}
