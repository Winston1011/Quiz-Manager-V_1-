package fr.epita.dz.quiz;

public class Question {
	private String question = ""; 
	private String[] topics;
	private Integer diffidculty;
	
	private String standardkey = "";
	private String selectkey = "";
	
	public Question(String question, String standardkey) {
		super();
		this.question = question;
		this.standardkey = standardkey;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getStandardkey() {
		return standardkey;
	}
	
	public void setStandardkey(String standardkey) {
		this.standardkey = standardkey;
	}
	
	public String getSelectkey() {
		return selectkey;
	}
	
	public void setSelectkey(String selectkey) {
		this.selectkey = selectkey;
	}
	
	public boolean Check() {
		if(this.selectkey.equals(standardkey)) {
			return true;
		}else 
			return false;
	}

	
	
}
