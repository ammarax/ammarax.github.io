package it.ennova.example.bean;

public class Response {

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Response(String result) {
		super();
		this.result = result;
	}

	public Response() {
		super();
		this.result = "KO";
	}
	
}
