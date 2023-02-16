package com.example.expenseconsultantapp.main_logic;

//import java.util.ArrayList;
//import java.util.ListIterator;

import com.example.expenseconsultantapp.entities.Transaction;
import com.example.expenseconsultantapp.entities.TransactionList;
import com.example.expenseconsultantapp.parsers.OFXParser;

import java.io.File;
import java.util.ListIterator;

import static com.example.expenseconsultantapp.main_logic.Result.Code.*;
import static com.example.expenseconsultantapp.parsers.OFXParser.ofxParser;

public class PEC {

	private TransactionList tList;

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

	private ListIterator<Result> parseOFX(Request request) {
		File file = null;
		boolean exception = false;
		Result result = new Result();
		ListIterator<Transaction> it = tList.listIterator();
		ListIterator<Result> rList = null;
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
		while (it.hasNext()) {
			result.setTFields(it.next());
			rList.add(result);
		}
		return rList;
	}

	public static void main(String[] args) {

	}
}
