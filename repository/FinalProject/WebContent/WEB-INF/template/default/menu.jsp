<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<style>
.menubar li ul {
display:none;  /* ���ÿ��� ����޴��� �Ⱥ��̰� �ϱ� */

}

.menubar li:hover ul {
display:block;   /* ���콺 Ŀ�� �ø��� ����޴� ���̰� �ϱ� */
}
</style>
<script>
function logout(){
	alert('�α׾ƿ� �Ǿ����ϴ�.');
}
</script>
	        <div class="menubar">
<ul>
	<li><a href="resume">�̷¼�&��Ʈ������ ����</a></li>
	<li><a href="company">���ɱ�� ����</a></li>
	<li><a href="jobsearch">�л�80%�̻�</a></li>
	<li><a href="logout" onclick="logout()">�α׾ƿ�</a></li>
	
	
                <ul>
                   
                   <li><a href="classlist">��ü����</a>
                      <ul>
                        <li><a href="clogin">�� ����</a></li>
                        
                        </ul>
                      
                   </li>
            
                </ul>
             </div>
	
  
</ul>
