package com.hwig.admin.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping(value="/api/product")
public class ProductAPIController {
	
	@Inject
	ProductService service;

	//카테고리 정보 보내기
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public TotalCategoryDTO category() throws Exception {
		System.out.println("category 목록 보내기 실행");
		
		List<CategoryDTO> catelist = service.category(); //DB에서 가져온 카테고리 전체목록
		
		TotalCategoryDTO tcategory = new TotalCategoryDTO();

		List<SCategoryDTO> scategory = new ArrayList<SCategoryDTO>(); //이벤트 등
		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				SCategoryDTO cdto = new SCategoryDTO();
				int num = tcate.getCategory_id();
				if(num == 33 || num == 44 || num == 55) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					scategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				int num2 = tcate.getCategory_id();
				if((num ==0 && num2 ==1) || (num==0 && num2 ==2)) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}

		tcategory.setScategory(scategory);
		tcategory.setPcategory(pcategory);
		tcategory.setCategory(category);
		
		return tcategory;
	}
	
	//메인에 필요한 상품들 보내기
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public TotalProductDTO product() throws Exception {
		System.out.println("main에 필요한 상품 목록 보내기 실행");
		
		List<ProductWhatDTO> wlist = service.wprolist(); //재고
		List<ProductSaleDTO> slist = service.sprolist(); //세일
		List<ProductNewDTO> nlist = service.nprolist(); //신상품
		List<ProductRandDTO> rlist1 = service.rprolist(1); //랜덤1
		List<ProductRandDTO2> rlist2 = service.rprolist2(2); //랜덤2
		
		TotalProductDTO tproduct = new TotalProductDTO();
		
		tproduct.setWproduct(wlist);
		tproduct.setSproduct(slist);
		tproduct.setNproduct(nlist);
		tproduct.setRproduct(rlist1);
		tproduct.setRproduct2(rlist2);
		
		return tproduct;
	}
	
	//상품 메인 상품목록 조회
	@RequestMapping(value="/mainlist", method=RequestMethod.GET)
	public ProductCateDTO productmain(@RequestParam int cate_id) throws Exception {
		System.out.println("category => " + cate_id );
		System.out.println("mainlist 실행");
		
		int cate = 0;
		
		List<CategoryDTO> catelist = service.category(); //DB에서 가져온 카테고리 전체목록
		List<ProductListDTO> prolist = new ArrayList<ProductListDTO>();
		
		//받은 id 판별
		if(cate_id < 99) { //상위 카테고리일때
			cate = cate_id;
			prolist = service.mainlist(cate_id);
		}
		else {
			cate = cate_id/100;
			prolist = service.catelist(cate_id);
		}
		
		ProductCateDTO procate = new ProductCateDTO();

		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				int cnum = tcate.getCategory_id();
				if(num == 0 && cnum == cate) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0 && num == cate) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}
		
		procate.setPcategory(pcategory);
		procate.setCategory(category);
		procate.setProductlist(prolist);
		
		return procate;
	}

	//카테고리별 상품 조회
	/*
	@RequestMapping(value="/catelist", method=RequestMethod.GET)
	public ProductCateDTO product(@RequestParam int category_id) throws Exception {
		System.out.println("category_id => " + category_id);
		List<CategoryDTO> catelist = service.category(); //DB에서 가져온 카테고리 전체목록
		List<ProductListDTO> prolist = service.catelist(category_id); //카테고리별 상품 목록
		
		ProductCateDTO procate = new ProductCateDTO();
		
		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num ==0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}
		
		procate.setPcategory(pcategory);
		procate.setCategory(category);
		procate.setProductlist(prolist);
		
		return procate;
	}
	*/
	//상품 상세보기
	@RequestMapping(value="/productdetail", method=RequestMethod.GET)
	public ProductVO productdetail(@RequestParam int prd_id) throws Exception {
		System.out.println("상품 상세보기");
		ProductVO pdetail = service.read(prd_id);
		
		return pdetail;
	}
	
	//상품 검색
	@RequestMapping(value="/productsearch", method=RequestMethod.GET)
	public List<ProductListDTO> productsearch(@RequestParam String keyword) throws Exception {
		List<ProductListDTO> prolist = service.prosearch(keyword);
		
		return prolist;
	}
	
	//베스트 상품 목록
	@RequestMapping(value="/productbest", method=RequestMethod.GET)
	public ProductCateDTO productbest() throws Exception {
		System.out.println("베스트 상품 실행");
		List<CategoryDTO> catelist = service.cateselect(55);
		List<ProductListDTO> prolist = service.bestlist();
		
		ProductCateDTO procate = new ProductCateDTO();
		
		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num ==0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}
		
		procate.setPcategory(pcategory);
		procate.setCategory(category);
		procate.setProductlist(prolist);
		
		return procate;
	}
	
	//신상품 목록
	@RequestMapping(value="/productnew", method=RequestMethod.GET)
	public ProductCateDTO productnew() throws Exception {
		System.out.println("신상품 실행");
		List<CategoryDTO> catelist = service.cateselect(33);
		List<ProductListDTO> prolist = service.newlist();
		
		ProductCateDTO procate = new ProductCateDTO();
		
		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num ==0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}
		
		procate.setPcategory(pcategory);
		procate.setCategory(category);
		procate.setProductlist(prolist);
		
		return procate;
	}
	
	//알뜰상품 목록
	@RequestMapping(value="/productsale", method=RequestMethod.GET)
	public ProductCateDTO productsale() throws Exception {
		System.out.println("알뜰상품 실행");
		List<CategoryDTO> catelist = service.cateselect(44);
		List<ProductListDTO> prolist = service.salelist();
		
		ProductCateDTO procate = new ProductCateDTO();
		
		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num ==0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}
		
		procate.setPcategory(pcategory);
		procate.setCategory(category);
		procate.setProductlist(prolist);
		
		return procate;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public Map<String, String> test( HttpSession session) {
		System.out.println("실행");
		Map<String, String> m = new HashMap<String, String>();
		m.put("aaa", "aaa");
		
		return m;
	}
}
