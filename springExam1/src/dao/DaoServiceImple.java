package dao;

import java.sql.SQLException;

import vo.MjoinVO;
//target �޼ҵ�
public class DaoServiceImple implements DaoService {
	@Override
	public void transactionTest(MjoinVO vo) throws SQLException {
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		System.out.println(vo.getPwd());
		System.out.println(vo.getInfo()+" ���� �Է�ó�� ��");
		
	}
}
