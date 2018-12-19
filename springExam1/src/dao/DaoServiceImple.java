package dao;

import java.sql.SQLException;

import vo.MjoinVO;
//target 메소드
public class DaoServiceImple implements DaoService {
	@Override
	public void transactionTest(MjoinVO vo) throws SQLException {
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		System.out.println(vo.getPwd());
		System.out.println(vo.getInfo()+" 등을 입력처리 함");
		
	}
}
