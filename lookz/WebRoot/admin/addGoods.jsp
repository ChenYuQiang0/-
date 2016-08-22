<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��Ʒ���-Lookz</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./bootstrap/css/mystyles.css" rel="stylesheet">
    <link href="./css/admin.css" rel="stylesheet">
    <link href="./css/updGoods.css"rel="stylesheet"/>
    <script src="./bootstrap/js/bootstrap.min.js"></script>

	
  </head>
  
  <body>
  
    <div class="myheading">
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">
                    Lookz
                </a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav ">
                    <li class="dropdown">
                    	<a href="ShowAdminServlet"class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">��Ա����<span class="caret"></span></a>
                    	<ul class="dropdown-menu" role="menu">
                    		<li><a href="AdminShowServlet">��Ա����</a></li>
                    		<li><a href="AdminShowMessageServlet">���Թ���</a></li>
                    	</ul>
                    </li>
                    <li class="dropdown active" >
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">��Ʒ����<span class="caret"></span></a>
                    	<ul class="dropdown-menu" role="menu">
                    		<li><a href="AdminsShowGoodsServlet">��Ʒ����</a></li>
                    		<li><a href="admin/addGoods.jsp">��Ʒ���</a></li>
                    	</ul>
                    </li>
                    
                    <c:choose>
	                	<c:when test="${admins.admins_rank==6}">
	                		<li class="dropdown" >
		                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">����Ա����<span class="caret"></span></a>
		                    	<ul class="dropdown-menu" role="menu">
		                    		<li><a href="AdminsShowAdminsServlet">����Ա����</a></li>
		                    		<li><a href="admin/addAdmins.jsp">����Ա���</a></li>
		                    	</ul>
		                    </li>
		                    <li><a class="pull-right">��ӭ��������Ա&nbsp;&nbsp;&nbsp;${admins.name }&nbsp;&nbsp;&nbsp;��¼</a></li>
	                	</c:when>
	                	<c:otherwise>
	                		<li><a class="pull-right">��ӭ��ͨ����Ա&nbsp;&nbsp;&nbsp;${admins.name }&nbsp;&nbsp;&nbsp;��¼</a></li>
	                	</c:otherwise>
	                </c:choose>
                    
                </ul>
            </div>
        </nav>
    </div>

    <div class="mybody container" id="updgoodscon">
        <div class="row">
            
            <div class="content col-md-5 col-sm-5">
                
                <div class="table-responsive">
                <form action="AdminsAddGoodsServlet" method="post" enctype="multipart/form-data">
                    <table class="table table-bordered table-hover" align="center">
                        <tr align="center" style="background-color:#e0dde1">
                        	<td colspan="2"><h3>��Ʒ���</h3></td>
                        </tr>
                        <tr>
                        	<th>��Ʒ��</th>
                        	<td><input name="name" type="text"/></td>
                        </tr>
                        <tr>
                        	<th>��Ʒ����</th>
                        	<td>
								<select name="type"> 
									<option >&nbsp;&nbsp;&nbsp;&nbsp;</option> 
									<option value ="����">����</option>  
								    <option value ="���">���</option>  
								</select> 
							</td>
                        </tr>
                        <tr>
                        	<th>ζ������</th>
                        	<td>
								<select name="tasteType"> 
									<option >&nbsp;&nbsp;&nbsp;&nbsp;</option> 
									<option value ="����">����</option>  
								    <option value ="ˬ��">ˬ��</option>
								    <option value ="����">����</option>
								    <option value ="��">��</option>
								    <option value ="��">��</option>
								    <option value ="��">��</option>  
								</select>
							</td>
                        </tr>
                        
                        <tr>
                        	<th>��������</th>
                        	<td>
								<select name="healthType"> 
									<option >&nbsp;&nbsp;&nbsp;&nbsp;</option> 
									<option value ="��θ">��θ</option>  
								    <option value ="��Ƣ">��Ƣ</option>
								    <option value ="����">����</option>
								    <option value ="���">���</option>  
								    <option value ="�в�">�в�</option>
								    <option value ="���">���</option>
								    <option value ="ҹ��">ҹ��</option>
								    <option value ="��ʽ">��ʽ</option>
								    <option value ="��ʽ">��ʽ</option>
								    <option value ="��ͯ�ײ�">��ͯ�ײ�</option>
								    <option value ="ѧ���ײ�">ѧ���ײ�</option>
								    <option value ="�����ײ�">�����ײ�</option>  
								</select>
							</td>
                        </tr>
                        <tr>
                        	<th>���̣���ϵ</th>
                        	<td>
								<select name="manufacturer"> 
									<option >&nbsp;&nbsp;&nbsp;&nbsp;</option> 
									<option value ="����">����</option>  
								    <option value ="³��">³��</option>
								    <option value ="����">����</option>
								    <option value ="�ղ�">�ղ�</option>  
								    <option value ="����">����</option>
								    <option value ="���">���</option>
								    <option value ="�ղ�">�ղ�</option>
								    <option value ="���">���</option>
								</select>
							</td>
                        </tr>
                        <tr>
                        	<th>����</th>
                        	<td><input type="text" name="price"/></td>
                        </tr>
                        <tr>
                        	<th>ͼƬ</th>
                        	<td><input type="file" name="f" id="exampleInputFile"></td>
                        </tr>
                       
                        <tr>
                        	<th>���</th>
                        	<td><input name="num" type="text"/></td>
                        </tr>
                        <tr>
                        	<th>��Ʒ�ۿ�</th>
                        	<td>
								<select name="dicount"> 
									<option value="1">ԭ��</option> 
									<option value ="0.9">����</option>  
								    <option value ="0.8">����</option>
								    <option value ="0.7">����</option>
								    <option value ="0.6">����</option>  
								    <option value ="0.5">����</option>
								    <option value ="0.4">����</option>
								    <option value ="0.3">����</option>
								    <option value ="0.2">����</option>
								</select>
							</td>
                        </tr>
                        <tr>
                        	<th>��Ʒ����</th>
                        	<td><textarea cols="22" rows="3" name="introduce"></textarea></td>
                        </tr>
                        <tr align="center">
                        	<td colspan="2">
                        		<input type="submit" name="submit" value="�ύ"/>
                        		<span style="color:red">${msg }</span>
                        	</td>
                        </tr>
                    </table>
                </form>   
                </div>
            </div>
        </div>
    </div>
	
<script src="./bootstrap/js/jquery-2.1.1.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<script>
    $(".navbar-nav a").click(function(e){
        $(this).tab("show");
    })
</script>
  </body>
</html>
