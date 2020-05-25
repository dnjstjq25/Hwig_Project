package com.hwig.admin.product;

import java.util.List;
import java.util.Map;

import com.hwig.admin.common.SearchCriteria;

public interface ProductService {

	//상품 등록
	public int add(ProductVO vo) throws Exception;
	
	//리스트 갯수 세기(등록예정)
	public int listAllCountb(SearchCriteria cri);
	
	//리스트 갯수 세기(등록완료)
	public int listAllCount(SearchCriteria cri);
	
	//판매자용 리스트 갯수 세기(등록예정)
	public int listAllSelCountb(ProductCriteria cri);
	
	//판매자용 리스트 갯수 세기(등록완료)
	public int listAllSelCount(ProductCriteria cri);
	
	//상품 승인 예정 목록 조회
	public List<ProductDTO> waitList(SearchCriteria cri) throws Exception;
	
	//판매자용 상품 승인 예정 목록 조회
	public List<ProductDTO> waitSelList(ProductCriteria cri) throws Exception;
	
	//등록 완료 목록 조회
	public List<ProductDTO> list(SearchCriteria cri) throws Exception;
	
	//판매자용 등록 완료 목록 조회
	public List<ProductDTO> sellist(ProductCriteria cri) throws Exception;
	
	//승인 예정 상품 삭제
	public int delete(int prd_id) throws Exception;
	
	//승인 완료 상품 삭제
	public int deletelist(int prd_id) throws Exception;
	
	//등록 예정 상품을 등록 완료 리스트로 넘김
	public int addList(int prd_id) throws Exception;
	
	//상품 조회
	public ProductVO read(int prd_id) throws Exception;
	
	//카테고리명 조회
	public String readCategory(int prd_id) throws Exception;
	
	//카테고리명 조회1
	public List<Map<Integer,String>> readCategories1() throws Exception;
	
	//카테고리명 조회2
	public List<Map<Integer,String>> readCategories2() throws Exception;
	
	//상품 수정
	public int update(ProductVO vo) throws Exception;
	

	//front와 통신
	
	//카테고리 목록 보내기
	public List<CategoryDTO> category() throws Exception;
	
	//카테고리 선택하여 보내기
	public List<CategoryDTO> cateselect(int category_id) throws Exception;
	
	//등록 완료 목록 조회
	public List<ProductListDTO> mainlist(int category_p_id) throws Exception;
	
	//카테고리별 상품 조회
	public List<ProductListDTO> catelist(int category_id) throws Exception;
	
	//상품 검색
	public List<ProductListDTO> prosearch(String keyword) throws Exception;
	
	//베스트 목록
	public List<ProductListDTO> bestlist() throws Exception;
	
	//신상품 순서대로 나열된 목록
	public List<ProductListDTO> newlist() throws Exception;
	
	//알뜰상품 목록
	public List<ProductListDTO> salelist() throws Exception;
	
	//top4
	//재고많은 순서대로 나열된 목록
	public List<ProductWhatDTO> wprolist() throws Exception;
	
	//알뜰상품 순서대로 나열된 목록
	public List<ProductSaleDTO> sprolist() throws Exception;
	
	//신상품 순서대로 나열된 목록
	public List<ProductNewDTO> nprolist() throws Exception;
	
	//랜덤 순서대로 나열된 목록1
	public List<ProductRandDTO> rprolist(int category_p_id) throws Exception;
	
	public int changeStock(ProductStockVO productStockVo);
	
	//랜덤 순서대로 나열된 목록2
	public List<ProductRandDTO2> rprolist2(int category_p_id) throws Exception;
	
}
