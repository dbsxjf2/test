<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="warp">
	<div>
		<div id="addcomfileform">
			<form action="addExcel" method="post" enctype="multipart/form-data">
				<input type="file" id="m_file" name="m_file">
				
				<input type="submit" value="���̱�"> 
			</form>
				<button id="soondelete">�����ﲨ</button>
		</div>
	</div>
	
	<form action="addcomlist" method="post">
		<div id="addlist">
		
		</div>
		<div>
			�����ȣ : <input type="text" id="" name="cplist[0].cpnum"/>
			����� : <input type="text" id="" name="cplist[0].cpname"/>
			�����ġ : <input type="text" id="" name="cplist[0].cploc"/>
			����з� : <input type="text" id="" name="cplist[0].keyword"/>
			Ȩ������ : <input type="text" id="" name="cplist[0].cplink"/>
			<div id="plusaddform">
				
			</div>	
			<div>
				<img id="addbuttonimg" src="resources/img/kjh_addimg.png" alt="�Է��� �߰�"  width="25" height="25">
			</div>			
			<div>
				<input type="submit" value="�߰�"/>
			</div>
		</div>
	</form>
	
	<div>
		<div>
			<input type="text" name="query" id="query">
			<button id="searchBtn" title="To saramin">�˻�</button>
		</div>
		<table>
			<tbody id="saraminbody">
			
			</tbody>		
		</table>
		<div>
			<button id="aftBtn" >������</button>
			<div id="tfoottarget">
			
			</div>
		</div>
	</div>
	</div>
<script>
	$(document).ready(function(){
		var total = 100;
		var count = 10;
		var start = 0; 
		let cplistindex = 1;
		$("#searchBtn").click(function(){
			getCpListFromSaramin($("#query").val(),start,count);
		});
		
		
		$("#aftBtn").click(function(){
			if(count < total){
				count += 10;
				getCpListFromSaramin($("#query").val(),start,count);
			}
		});	
		
		$("#soondelete").click(function(){
			console.log("value:::"+$("#m_file").val());
		});
		
		$("#addbuttonimg").click(function(){
			console.log("addbuttonimg.event!!!");
			var htmlsource = "";
			htmlsource += ' �����ȣ : <input type="text" id="" name="cplist['+cplistindex+'].cpnum"/>';
			htmlsource += ' ����� : <input type="text" id="" name="cplist['+cplistindex+'].cpname"/>';
			htmlsource += ' �����ġ : <input type="text" id="" name="cplist['+cplistindex+'].cploc"/>';
			htmlsource += ' ����з� : <input type="text" id="" name="cplist['+cplistindex+'].keyword"/>';
			htmlsource += ' Ȩ������ : <input type="text" id="" name="cplist['+cplistindex+'].cplink"/><br/>';
			cplistindex+=1;
			$("#plusaddform").append(htmlsource)
		});
		
		function getCpListFromSaramin(keyword, start, count){
			$.ajax({	
				url : "saramin?query="+keyword+"&start="+start+"&count="+count,
				dataType : "json",
				success : function(data){				
					console.log(data);
					let show ="";
					$(data).each(function(){
						console.log(data);
					});
					total = $(data["job-search"].jobs.total)[0];
					$("#tfoottarget").html("tatal:"+total+" ... current:"+count);
					$(data["job-search"].jobs.job).each(function(index, item){
						show += "<tr><td>"+(index+1)+"</td><td> <button class='formadd'>�Է¿� �߰��ϱ�</button></td><tr/>";
						show += "<tr><td>��ȣ::</td><td id='num"+index+"' value='"+item.id+"'>"+item.id+"</td><tr/>";
						show += "<tr><td>�̸�::</td><td id='name"+index+"' value='"+item.company.name.content+"'>"+item.company.name.content+"</td><tr/>";
						show += "<tr><td>��ġ::</td><td id='loc"+index+"' value="+item.position.location.content+">"+item.position.location.content+"</td><tr/>";
						show += "<tr><td>�з�::</td><td id='word"+index+"' value="+item.keyword+">"+item.keyword+"</td><tr/>";
						show += "<tr><td>Ȩ������::</td><td id='link"+index+"' value="+item.url+"><a href='"+item.url+"'>"+item.url+"</a></td></tr>";
					});
					$("#saraminbody").html(show);
					const arr =document.querySelectorAll(".formadd");
					arr.forEach(function(item, index) {
						console.log(item + ":::" + index);
						selectgroup(item, index);
					});
					function selectgroup(item, index) {
						item.addEventListener("click", function(evt) {
							
							let addnum= ($("#num"+(index))).text();
							let addname= ($("#name"+(index))).text();
							let addloc= $("#loc"+index).text();
							let addword= $("#word"+index).text();
							let addlink= $("#link"+index).text();							
							
							let htmlsource2 = "";
							htmlsource2 += ' �����ȣ : <input type="text" id="" name="cplist['+cplistindex+'].cpnum" value='+addnum+' />';
							htmlsource2 += ' ����� : <input type="text" id="" name="cplist['+cplistindex+'].cpname" value='+addname+' /><br/>';
							htmlsource2 += ' �����ġ : <input type="text" id="" name="cplist['+cplistindex+'].cploc" value='+addloc+' />';
							htmlsource2 += ' ����з� : <input type="text" id="" name="cplist['+cplistindex+'].keyword" value='+addword+' />';
							htmlsource2 += ' Ȩ������ : <input type="text" id="" name="cplist['+cplistindex+'].cplink" value='+addlink+' /><br/>';
							cplistindex+=1;
							$("#addlist").append(htmlsource2);
						});
					}
				}
			});
		}		
	});
</script>
