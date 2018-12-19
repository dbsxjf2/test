package kr.or.kosta.mvc.dao;

import kr.or.kosta.dto.MologVO;
import kr.or.kosta.dto.MyMemVO;

public interface MemberDaoInter {
	public void addMem(MyMemVO vo);
    public MyMemVO loginchk(MyMemVO vo);
	public int idChk(String id);
	public MologVO mlog(MologVO vo);
}
