package com.hwig.admin.product;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class ProductDAOImpl implements ProductDAO{

	//mybatis
	@Inject
	private SqlSession sql;
	
	//mapper
	@Inject
	private static String namespace = "com.hwig.admin.mappers.productMapper";
	
	//상품 등록
	@Override
	public int add(ProductVO vo) throws Exception {
		return sql.insert(namespace + ".add", vo);
	}
	
	//리스트 갯수 세기(등록예정)
	@Override
	public int selectAllCountb(SearchCriteria cri) {
		return sql.selectOne(namespace + ".allCountb", cri);
	}
	
	//리스트 갯수 세기(등록완료)
	@Override
	public int selectAllCount(SearchCriteria cri) {
		return sql.selectOne(namespace + ".allCount", cri);
	}
	
	//판매자용 리스트 갯수 세기(등록예정)
	@Override
	public int selectAllSelCountb(ProductCriteria cri) {
		return sql.selectOne(namespace + ".allSelCountb", cri);
	}
	
	//판매자용 리스트 갯수 세기(등록완료)
	@Override
	public int selectAllSelCount(ProductCriteria cri) {
		return sql.selectOne(namespace + ".allSelCount", cri);
	}
	
	
	//상품 승인 예정 목록 조회
	@Override
	public List<ProductDTO> waitList(SearchCriteria cri) throws Exception {
		return sql.selectList(namespace + ".waitList", cri);
	}
	
	//상품 승인 예정 목록 조회
	@Override
	public List<ProductDTO> waitSelList(ProductCriteria cri) throws Exception {
		return sql.selectList(namespace + ".waitSelList", cri);
	}
	
	//등록 완료 목록 조회
	@Override
	public List<ProductDTO> list(SearchCriteria cri) throws Exception {
		return sql.selectList(namespace + ".list", cri);
	}
	
	//판매자용등록 완료 목록 조회
	@Override
	public List<ProductDTO> sellist(ProductCriteria cri) throws Exception {
		return sql.selectList(namespace + ".sellist", cri);
	}

	@Override
	public int delete(int prd_id) throws Exception {
		return sql.delete(namespace + ".delete", prd_id);
	}

	@Override
	public int addList(int prd_id) throws Exception {
		return sql.insert(namespace + ".addList", prd_id);
	}

	//등록 완료 상품 삭제
	@Override
	public int deletelist(int prd_id) throws Exception {
		return sql.delete(namespace + ".deletelist", prd_id);
	}

	//상품 조회
	@Override
	public ProductVO read(int prd_id) throws Exception {
		return sql.selectOne(namespace + ".read", prd_id);
	}

	//카테고리명 조회
	@Override
	public String readCategory(int prd_id) throws Exception {
		return sql.selectOne(namespace + ".readcategory", prd_id);
	}
	
	//카테고리명 조회1
	@Override
	public  List<Map<Integer,String>> readCategories1() throws Exception {
		return sql.selectList(namespace + ".readcategories1");
	}
	
	//카테고리명 조회2
	@Override
	public  List<Map<Integer,String>> readCategories2() throws Exception {
		return sql.selectList(namespace + ".readcategories2");
	}
	
	@Override
	public int update(ProductVO vo) throws Exception {
		return sql.update(namespace + ".update", vo);
	}
	
	
	//front와 통신
	
	//카테고리 목록 보내기
	@Override
	public List<CategoryDTO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}
	
	//카테고리 선택하여 보내기
	@Override
	public List<CategoryDTO> cateselect(int category_id) throws Exception{
		return sql.selectList(namespace + ".cateselect", category_id);
	}
	
	//메인 상품 목록 조회
	@Override
	public List<ProductListDTO> mainlist(int category_p_id) throws Exception {
		return sql.selectList(namespace + ".mainlist", category_p_id);
	}
	
	//카테고리별 상품 조회
	@Override
	public List<ProductListDTO> catelist(int category_id) throws Exception {
		return sql.selectList(namespace + ".catelist", category_id);
	}
	
	//상품 검색
	@Override
	public List<ProductListDTO> prosearch(String keyword) throws Exception {
		return sql.selectList(namespace + ".prosearch", keyword);
	}
	
	//베스트 목록
	@Override
	public List<ProductListDTO> bestlist() throws Exception {
		return sql.selectList(namespace + ".bestlist");
	}
	
	//신상품 순서대로 나열된 목록
	@Override
	public List<ProductListDTO> newlist() throws Exception {
		return sql.selectList(namespace + ".newlist");
	}
	
	//알뜰상품 목록
	@Override
	public List<ProductListDTO> salelist() throws Exception {
		return sql.selectList(namespace + ".salelist");
	}
	
	//top4
	//재고많은 순서대로 나열된 목록
	@Override
	public List<ProductWhatDTO> wprolist() throws Exception{
		return sql.selectList(namespace + ".mainwhatlist");
	}
	
	//알뜰상품 순서대로 나열된 목록
	@Override
	public List<ProductSaleDTO> sprolist() throws Exception{
		return sql.selectList(namespace + ".mainsalelist");
	}
	
	//신상품 순서대로 나열된 목록
	@Override
	public List<ProductNewDTO> nprolist() throws Exception{
		return sql.selectList(namespace + ".mainnewlist");
	}
	
	//랜덤 순서대로 나열된 목록1
	@Override
	public List<ProductRandDTO> rprolist(int category_p_id) throws Exception{
		return sql.selectList(namespace + ".mainrandlist", category_p_id);
	}

	@Override
	public int changeStock(ProductStockVO productStockVo) {
		return sql.update(namespace + ".changeStock", productStockVo);
	}
	
	//랜덤 순서대로 나열된 목록2
	@Override
	public List<ProductRandDTO2> rprolist2(int category_p_id) throws Exception{
		return sql.selectList(namespace + ".mainrandlist", category_p_id);
	}
	
}
