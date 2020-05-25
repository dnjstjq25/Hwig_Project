package com.hwig.admin.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.hwig.admin.mappers.memberMapper";

	@Override
	public int insert(MemberVO memberVo) {
		return sqlSession.insert(namespace + ".memberInsert", memberVo);
	}

	@Override
	public List<MemberVO> selectAll(SearchCriteria cri) {
		return sqlSession.selectList(namespace + ".memberAllSelect", cri);
	}

	@Override
	public int selectAllCount(SearchCriteria cri) {
		return sqlSession.selectOne(namespace + ".memberAllCount", cri);
	}

	@Override
	public MemberVO select(MemberVO memberVo) {
		return sqlSession.selectOne(namespace + ".memberSelect", memberVo);
	}

	@Override
	public int emailCheck(EmailCheckVO emailCheckVo) {
		return sqlSession.selectOne(namespace + ".emailCheck", emailCheckVo);
	}

	@Override
	public int idCheck(IdCheckVO idCheckVo) {
		return sqlSession.selectOne(namespace + ".idCheck", idCheckVo);
	}

	@Override
	public int update(UpdateMemberVO updateMemberVo) {
		return sqlSession.update(namespace + ".memberUpdate", updateMemberVo);
	}

	@Override
	public List<ApiOrderListVO> memberOrderSelectAll(ApiOrderListVO apiOrderListVo) {
		return sqlSession.selectList(namespace + ".memberOrderSelectAll", apiOrderListVo);
	}

	@Override
	public int memberOrderAllCount(ApiOrderListVO apiOrderListVo) {
		return sqlSession.selectOne(namespace + ".memberOrderAllCount", apiOrderListVo);
	}

	@Override
	public List<ApiOrderDetailVO> memberOrderDetailSelectAll(ApiOrderDetailVO ApiOrderDetailVo) {
		return sqlSession.selectList(namespace + ".memberOrderDetailSelectAll", ApiOrderDetailVo);
	}

	@Override
	public int changeReverse(MemberVO memberVo) {
		return sqlSession.update(namespace + ".changeReverse", memberVo);
	}

	@Override
	public int changePrice(MemberVO memberVo) {
		return sqlSession.update(namespace + ".changePrice", memberVo);
	}

	@Override
	public int changeGrade(MemberVO memberVo) {
		return sqlSession.update(namespace + ".changeGrade", memberVo);
	}

	@Override
	public int idNameEmailCheck(MemberVO memberVo) {
		return sqlSession.selectOne(namespace + ".idNameEmailCheck", memberVo);
	}

	@Override
	public int resetPw(MemberVO memberVo) {
		return sqlSession.update(namespace + ".resetPw", memberVo);
	}

	@Override
	public List<MemberOrderPrdVO> memberOrderPrdSelect(MemberCriteria cri) {
		return sqlSession.selectList(namespace + ".memberOrderPrdSelect", cri);
	}

	@Override
	public int memberOrderPrdCount(MemberCriteria cri) {
		return sqlSession.selectOne(namespace + ".memberOrderPrdCount", cri);
	}

	@Override
	public List<ApiMemberReviewPrdVO> memberReviewPrdSelect(ApiMemberReviewPrdVO apiMemberReviewPrdVo) {
		return sqlSession.selectList(namespace + ".memberReviewPrdSelect", apiMemberReviewPrdVo);
	}

	@Override
	public int delete(String mem_id) {
		return sqlSession.delete(namespace + ".memberDelete", mem_id);
	}

	@Override
	public List<MemberDeleteVO> memberOrders(String mem_id) {
		return sqlSession.selectList(namespace + ".memberOrders", mem_id);
	}

	@Override
	public int adminMemberUpdate(MemberVO memberVo) {
		return sqlSession.update(namespace + ".adminMemberUpdate", memberVo);
	}

}