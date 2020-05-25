package com.hwig.admin.reply;

public class MacroVO {
	private int macro_id;
	private int macro_c_id;
	private String macro_head;
	private String macro_content;
	private String macro_tail;
	private String macro_link;
	private String qna_category;

	public int getMacro_id() {
		return macro_id;
	}

	public void setMacro_id(int macro_id) {
		this.macro_id = macro_id;
	}

	public String getMacro_head() {
		return macro_head;
	}

	public void setMacro_head(String macro_head) {
		this.macro_head = macro_head;
	}

	public String getMacro_content() {
		return macro_content;
	}

	public void setMacro_content(String macro_content) {
		this.macro_content = macro_content;
	}

	public String getMacro_tail() {
		return macro_tail;
	}

	public void setMacro_tail(String macro_tail) {
		this.macro_tail = macro_tail;
	}

	public int getMacro_c_id() {
		return macro_c_id;
	}

	public void setMacro_c_id(int macro_c_id) {
		this.macro_c_id = macro_c_id;
	}

	public String getMacro_link() {
		return macro_link;
	}

	public void setMacro_link(String macro_link) {
		this.macro_link = macro_link;
	}

	public String getQna_category() {
		return qna_category;
	}

	public void setQna_category(String qna_category) {
		this.qna_category = qna_category;
	}
	
}
