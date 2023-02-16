package com.example.expenseconsultantapp.main_logic;

public class Request extends DataTransfer {

	private static Request request;
	private String from;
	private String to;

	private Request() {
		reset();
	}

	public static Request instance() {
		if (request == null) {
			request = new Request();
		}
		return request;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public void reset() {
		super.reset();
		from = "";
		to = "";
	}

}
