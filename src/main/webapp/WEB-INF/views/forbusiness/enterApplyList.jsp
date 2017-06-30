<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/js/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link href="${pageContext.request.contextPath}/js/libs/datetimepicker/datetimepicker.min.css" rel="stylesheet" media="screen">
</head>

<body>
	<!-- 路径导航 开始 -->
	<div class="col-xs-12">
	    <ol class="breadcrumb">
	        <li><a href="#">首页</a></li>
	        <li><a href="#">业务办理</a></li>
	        <li class="active">入住申请列表</li>
	    </ol>
	</div>
	<!-- 路径导航 结束 -->
		<div class="col-xs-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="col-xs-4">入住申请列表</div>
						<form action="${pageContext.request.contextPath}/dist/enterApply/search" method="post">
						<div class="col-xs-8 panel-oprerate">
								<a href="#"  class="btn btn-info" target="iframe_ch_ch">新增	</a>
						</div>
						
						
						<div class="form-inline">
							<div class="form-group">
									<label>申请日期：</label>
									<div id="form_datetime" class="input-group date form_datetime col-sm-3" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
					                    <input id="showdate1" class="form-control" size="16" type="text" value="" readonly="readonly">
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
					              </div>
								  <input type="hidden" id="dtp_input1" name="nextReturnTime" value="" />
								  -
									<div id="form_datetime2" class="input-group date form_datetime col-sm-3" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
					                    <input id="showdate2" class="form-control" size="16" type="text" value="" readonly="readonly">
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
					              </div>
								  <input type="hidden" id="dtp_input2" name="nextReturnTime" value="" /> 
									<input type="text"
										class="form-control quanxianmingcheng" placeholder="项目名称、用户名">
								<button id="query" type="submit" class="btn btn-info danxi_saixuan">搜索</button>
							</div>
						</div>
						</form>
				</div>
							
			<div class="panel-body">
					<table class="table table-bordered landReturn-table edit-tr">
						<thead>
							<tr class="info">
			                    <th rowspan="2">选择</th>
			                    <th rowspan="2">序号</th>
			                    <th rowspan="2">项目名称<br/></th>
			                    <th rowspan="2">房产</th>
			                    <th rowspan="2">客户名称</th>
			                    <th rowspan="2">申请日期</th>
			                    <th rowspan="2">审核状态</th>
			                    <th rowspan="2">操作</th>
			                </tr>
						</thead>
						<tbody class="tudiqianyue-tbody">

		                <c:forEach items="${enterApplyList}" var="enterApply" varStatus="status">
		                    <tr>
		                        <td><input type="checkbox" value=""></td>
		                        <td>${status.index+1}</td>
		                        <td>${enterApply.houseInfoDetails.project}</td>
		                        <td>${enterApply.houseInfoDetails.vhname}</td>
		                        <td>${enterApply.clientName}</td>
		                        <td><fmt:formatDate value="${enterApply.applyTime }" pattern="yyyy-MM-dd"/></td>
		                        <td>
		                            <c:if test="${enterApply.auditStatus eq 0}">未审核</c:if>
		                            <c:if test="${enterApply.auditStatus eq 1}">已通过</c:if>
		                            <c:if test="${enterApply.auditStatus eq 2}">未通过</c:if>
		                        </td>
		                        <td><a onclick="del();" class="btn btn-warning" href="#" role="button">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
		                               <a class="btn btn-info"
		                                href="${pageContext.request.contextPath}/dist/enterApply/enterApplyEdit?enterApplyId=${enterApply.enterApplyId}&houseInfoId=${enterApply.houseId}"
		                                role="button">编辑</a></td>
		                    </tr>
		                </c:forEach>
		                </tbody>
		            </table>
		            
				</div>
			</div>
			</div>
			
			<input type="hidden" id="projectId" class="project_id_class" value="${projectId }">
		
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/datetimepicker/datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/datetimepicker/datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
 $(function(){
 	formdate('#form_datetime');
 	formdate('#form_datetime2');
 })

function del(){
	 layer.confirm('是否确认删除?', {icon: 3, title:'提示'}, function(index){
		  //do something
	 window.location.href="${pageContext.request.contextPath}/dist/enterApply/deleteEnterApply?enterApplyId=${enterApply.enterApplyId}&pkHouse=${enterApply.houseId}";
	 layer.close(index);
});
} 
</script>
 
</html>
