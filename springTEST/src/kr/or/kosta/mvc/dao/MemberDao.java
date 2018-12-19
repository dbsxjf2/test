package kr.or.kosta.mvc.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.dto.MologVO;
import kr.or.kosta.dto.MyMemVO;

@Repository
public class MemberDao implements MemberDaoInter{
	
    @Autowired
	private SqlSessionTemplate ss;
	
	
	@Override
	public void addMem(MyMemVO vo) {
	 ss.insert("mymember.join",vo);
		
	}

	@Override
	public int idChk(String id) {
	return ss.selectOne("mymember.idChk", id);	
	}
	
	
	@Override
	public MyMemVO loginchk(MyMemVO vo) {
		return ss.selectOne("mymember.loginchk", vo);
	}

	@Override
	public void mlog(MologVO vo) {
	
	 ss.insert("mymember2.addlog", vo);
	}
	
	}
