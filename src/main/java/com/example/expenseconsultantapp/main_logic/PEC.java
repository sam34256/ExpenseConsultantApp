package com.example.expenseconsultantapp.main_logic;

//import java.util.ArrayList;
//import java.util.ListIterator;

import com.example.expenseconsultantapp.entities.Transaction;
import com.example.expenseconsultantapp.entities.TransactionList;
import com.example.expenseconsultantapp.parsers.OFXParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.ListIterator;

import static com.example.expenseconsultantapp.main_logic.Request.Button.DATE;
import static com.example.expenseconsultantapp.main_logic.Result.Code.*;
import static com.example.expenseconsultantapp.parsers.OFXParser.ofxParser;

public class PEC {

	private static double THREE_MONTHS_IN_SECS = 7889238.0;

	// private main structure housing active Transaction data
	// (no more than 3 months worth)
	private TransactionList tList;
	// array of booleans to remember if a particular column is sorted
	// in a descending (or ascending) direction
	private boolean[] descColumn = { true, true, true, true, true, true };
	// sortedColumn indicates which column is active and sorted on screen
	private int sortedColumn = Transaction.POSTED_DATE;

	private static PEC singleton = null;

	/**
	 * Private constructor.
	 */
	private PEC() {
		tList = new TransactionList();
	}

	/**
	 * Instance creator.
	 * 
	 * @return an instance of PEC
	 */
	public static PEC instance() {
		if (singleton == null) {
			singleton = new PEC();
		}
		return singleton;
	}

//	an example of "loading" any logic bearing method with Request parameter
//	and returning a Result or a ListIterator to a list of Results.
//	
//	public Result XXX(Request request) {
//		Result result = new Result();
//		return result;
//	}
//	
//	public ListIterator<Result> YYY(Request request) {
//		ArrayList<Result> list = new ArrayList<Result>();
//		// ... code ...
//		for (... for loop ...) {
//			Result result = new Result();
//			result = ...;
//			list.add(result);
//		}
//		return list.listIterator();
//	}
// ...

	private void resetView() {
		for (int i = 0; i < descColumn.length; i++) {
			descColumn[i] = true;
		}
		sortedColumn = Transaction.POSTED_DATE;
	}

	/**
	 * Gets the name + abs. path from the Request object, checks the file for
	 * readability, and parses it.
	 * @param request - Request object
	 * @return - list of Result objects with Transaction fields filled out
	 */
	private ListIterator<Result> parseOFX(Request request) {
		File file = null;
		boolean exception = false;
		Result result = new Result();
		ListIterator<Transaction> it = tList.listIterator();
		ListIterator<Result> rList = new ArrayList<Result>().listIterator();
		try {
			file = new File(request.getFileWithPath());
			tList = OFXParser.ofxParser(file);
		} catch (Exception e) {
			exception = true;
		}
		if (exception) {
			result.setCode(IO_ERROR);
			rList.add(result);
			return rList;
		}
		result.setCode(SUCCESS);
		resetView();
		while (it.hasNext()) {
			result.setTFields(it.next());
			rList.add(result);
		}
		return rList;
	}

	private ListIterator<Result> getNewView() {
		ListIterator<Transaction> it = tList.sort(sortedColumn);
		ListIterator<Result> resIt = new ArrayList<Result>().listIterator();
		if (descColumn[sortedColumn]) {
			while (it.hasNext()) {
				Result result = new Result();
				result.setTFields(it.next());
				resIt.add(result);
			}
		} else {
			while (it.hasNext()) { it.next(); }
			while (it.hasPrevious()) {
				Result result = new Result();
				result.setTFields(it.previous());
				resIt.add(result);
			}
		}
		return resIt;
	}

	private ListIterator<Result> sortingOrientationSwitched() {
		descColumn[sortedColumn] = !descColumn[sortedColumn];
		return getNewView();
	}

	private ListIterator<Result> sortedColumnSwitched(Request request) {
		switch (request.getButton()) {
			case DATE:
				sortedColumn = Transaction.POSTED_DATE;
				break;
			case REF:
				sortedColumn = Transaction.REF_NUMBER;
				break;
			case NAME:
				sortedColumn = Transaction.DESCRIPTION;
				break;
			case MEMO:
				sortedColumn = Transaction.MEMO;
				break;
			case AMOUNT:
				sortedColumn = Transaction.AMOUNT;
				break;
			case CAT:
				sortedColumn = Transaction.CATEGORY;
				break;
			default: ;
		}
		return getNewView();
	}

	public static void main(String[] args) {

	}
}
