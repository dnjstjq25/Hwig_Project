package com.hwig.admin.reply;

import java.sql.Date;

import com.hwig.admin.qna.QnaVO;

public class ReplyVO {
	private int qna_id;
	private int reply_id;
	private String reply_content;
	private Date reply_regdate;
	private String qna_category;
	
	private QnaVO qna;
	
	
	public QnaVO getQna() {
		return qna;
	}

	public void setQna(QnaVO qna) {
		this.qna = qna;
	}

	public int getQna_id() {
		return qna_id;
	}

	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_regdate() {
		return reply_regdate;
	}

	public void setReply_regdate(Date reply_regdate) {
		this.reply_regdate = reply_regdate;
	}

	public String getQna_category() {
		return qna_category;
	}

	public void setQna_category(String qna_category) {
		this.qna_category = qna_category;
	}
	
	
}
