package com.hwig.admin.member;

public class MemberPageMaker {

	private int prdTotalCount;
	private int prdStartPage;
	private int prdEndPage;
	private boolean prdPrev;
	private boolean prdNext;

	private int prdDisplayPageNum = 10;

	private MemberCriteria cri;

	public void setCri(MemberCriteria cri) {
		this.cri = cri;
	}

	public void setPrdTotalCount(int prdTotalCount) {
		this.prdTotalCount = prdTotalCount;

		calcData();
	}

	public void calcData() {
		prdEndPage = (int) (Math.ceil(cri.getPrdPage() / (double) prdDisplayPageNum) * prdDisplayPageNum);

		prdStartPage = (prdEndPage - prdDisplayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(prdTotalCount / (double) cri.getPrdPerPageNum()));

		if (prdEndPage > tempEndPage) {
			prdEndPage = tempEndPage;
		}

		prdPrev = prdStartPage == 1 ? false : true;

		prdNext = prdEndPage * cri.getPrdPerPageNum() >= prdTotalCount ? false : true;
	}

//	public String makeQuery(int page) {
//		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
//				.queryParam("perPageNum", cri.getPerPageNum()).build();
//
//		return uriComponents.toUriString();
//	}

//	public String makeSearch(int page) {
//		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
//				.queryParam("perPageNum", cri.getPerPageNum())
//				.queryParam("searchType", ((SearchCriteria) cri).getSearchType())
//				.queryParam("keyword", encoding(((SearchCriteria) cri).getKeyword())).build();
//
//		return uriComponents.toString();
//	}

//	private String encoding(String keyword) {
//		if (keyword == null || keyword.trim().length() == 0) {
//			return "";
//		}
//		try {
//			return URLEncoder.encode(keyword, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			return "";
//		}
//	}

	public int getPrdStartPage() {
		return prdStartPage;
	}

	public void setPrdStartPage(int prdStartPage) {
		this.prdStartPage = prdStartPage;
	}

	public int getPrdEndPage() {
		return prdEndPage;
	}

	public void setPrdEndPage(int prdEndPage) {
		this.prdEndPage = prdEndPage;
	}

	public boolean isPrdPrev() {
		return prdPrev;
	}

	public void setOrdPrev(boolean prdPrev) {
		this.prdPrev = prdPrev;
	}

	public boolean isPrdNext() {
		return prdNext;
	}

	public void setPrdNext(boolean prdNext) {
		this.prdNext = prdNext;
	}

	public int getPrdDisplayPageNum() {
		return prdDisplayPageNum;
	}

	public void setPrdDisplayPageNum(int prdDisplayPageNum) {
		this.prdDisplayPageNum = prdDisplayPageNum;
	}

	public int getPrdTotalCount() {
		return prdTotalCount;
	}

	public MemberCriteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageMaker [prdTotalCount=" + prdTotalCount + ", prdStartPage=" + prdStartPage + ", prdEndPage="
				+ prdEndPage + ", prdPrev=" + prdPrev + ", prdNext=" + prdNext + ", prdDisplayPageNum="
				+ prdDisplayPageNum + ", cri=" + cri + "]";
	}

}
