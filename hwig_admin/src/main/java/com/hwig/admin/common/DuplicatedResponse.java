package com.hwig.admin.common;

public class DuplicatedResponse {

	private boolean isDuplicated = false;

	public boolean isDuplicated() {
		return isDuplicated;
	}

	public void setDuplicated(boolean isDuplicated) {
		this.isDuplicated = isDuplicated;
	}

	@Override
	public String toString() {
		return "DuplicatedResponse [isDuplicated=" + isDuplicated + "]";
	}

}
