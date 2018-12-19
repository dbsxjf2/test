<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<style>
.menubar li ul {
display:none;  /* 평상시에는 서브메뉴가 안보이게 하기 */

}

.menubar li:hover ul {
display:block;   /* 마우스 커서 올리면 서브메뉴 보이게 하기 */
}
</style>
<script>
function logout(){
	alert('로그아웃 되었습니다.');
}
</script>
	        <div class="menubar">
<ul>
	<li><a href="resume">이력서&포트폴리오 관리</a></li>
	<li><a href="company">관심기업 관리</a></li>
	<li><a href="jobsearch">학생80%이상</a></li>
	<li><a href="logout" onclick="logout()">로그아웃</a></li>
	
	
                <ul>
                   
                   <li><a href="classlist">전체강의</a>
                      <ul>
                        <li><a href="clogin">내 강의</a></li>
                        
                        </ul>
                      
                   </li>
            
                </ul>
             </div>
	
  
</ul>
