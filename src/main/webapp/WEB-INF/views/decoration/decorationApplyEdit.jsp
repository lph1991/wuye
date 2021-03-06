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
</head>
<body>
<div class="container">
    <div class="row">
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
            <div class="panel panel-default tudiqianyue">
                <form class="form-horizontal"
                      action="${pageContext.request.contextPath}/dist/updateDecorationApply" method="post">
                    <div class="form-group" style="margin-top: 50px">
                        <input type="hidden" name="decorationApplyId" value="${decorationApply.decorationApplyId}"/>
                        <label class="col-sm-2 control-label">项目名称:</label>
                        <div class="col-sm-10">
                            <label class="col-sm-2 control-label">${decorationApply.houseInfoDetails.project}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">房产信息:</label>
                        <div class="col-sm-10">
                            <label class="col-sm-2 control-label">${decorationApply.houseInfoDetails.vhname}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">客户名称:</label>
                        <div class="col-sm-10">
                            <input type="text" name="clientName" value="${decorationApply.clientName}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">楼号:</label>
                        <div class="col-sm-10">
                            <input type="text" name="houseInfoId" value="${decorationApply.houseInfoId}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请时间:</label>
                        <div class="col-sm-10">
                            <input type="text" name="applyTime"
                                   value="<fmt:formatDate value="${decorationApply.applyTime }" pattern="yyyy-MM-dd HH:dd:ss"/>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">预计工期:</label>
                        <div class="col-sm-10">
                            <input type="text" name="antipateTime" value="${decorationApply.antipateTime}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">现场管理人:</label>
                        <div class="col-sm-10">
                            <input type="text" name="localeCustodian" value="${decorationApply.localeCustodian}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">现场管理人联系方式:</label>
                        <div class="col-sm-10">
                            <input type="text" name="localeCustodianPhone"
                                   value="${decorationApply.localeCustodianPhone}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">装修部位:</label>
                        <div class="col-sm-10">
                            <input type="text" name="decorationParts" value="${decorationApply.decorationParts}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">装修面积:</label>
                        <div class="col-sm-10">
                            <input type="text" name="decorateArea" value="${decorationApply.decorateArea}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">施工人数:</label>
                        <div class="col-sm-10">
                            <input type="text" name="constructPeopleNumber"
                                   value="${decorationApply.constructPeopleNumber}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">装修公司:</label>
                        <div class="col-sm-10">
                            <input type="text" name="decorationCompany" value="${decorationApply.decorationCompany}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">装修负责人:</label>
                        <div class="col-sm-10">
                            <input type="text" name="decorationLeader" value="${decorationApply.decorationLeader}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">装修负责人联系方式:</label>
                        <div class="col-sm-10">
                            <input type="text" name="decorationLeaderPhone"
                                   value="${decorationApply.decorationLeaderPhone}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">装修押金:</label>
                        <div class="col-sm-10">
                            <input type="text" name="decorationDeposit" value="${decorationApply.decorationDeposit}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">装修管理费:</label>
                        <div class="col-sm-10">
                            <input type="text" name="decorationManagementCost"
                                   value="${decorationApply.decorationManagementCost}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">出入证工本费:</label>
                        <div class="col-sm-10">
                            <input type="text" name="passPapersCost" value="${decorationApply.passPapersCost}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">出入证押金:</label>
                        <div class="col-sm-10"><br/>
                            <input type="text" name="passPapersDeposit" value="${decorationApply.passPapersDeposit}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">附件:</label>
                        <div class="col-sm-10">
                            <a target="main" href="${pageContext.request.contextPath}" class="btn btn-info"
                               type="button"><span class="glyphicon glyphicon-plus"></span>批量打包下载
                            </a>
                            <br/>
                            <c:forEach items="${decorationMaterialList}" var="decorationMaterial"> <input type="text"
                                                                                                          value="${decorationMaterial.materialName}"/><br/></c:forEach>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">装修明细:</label>
                        <div class="col-sm-10" style="width: 700px">
                            <div class="panel-body">
                                <table class="table table-bordered tudiqianyue-table">
                                    <tbody class="tudiqianyue-tbody">
                                    <c:forEach var="decorateDetail" items="${decorateDetailList}">
                                        <tr class="tudiqianyue-tdtr">
                                            <td>${decorateDetail.detailOrder}</td>
                                            <td>${decorateDetail.detailContent}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">审核意见:</label>
                        <div class="col-sm-10 radio">
                            <label>
                                <input type="radio" name="opinion"
                                       value="0" <c:if test="${decorationApply.opinion eq 0}">checked="checked"
                                </c:if>/>反馈
                            </label>
                            <label>
                                <input type="radio" name="opinion"
                                       value="1"
                                       <c:if test="${decorationApply.opinion eq 1}">checked="checked"</c:if>/>同意
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">反馈意见:</label>
                        <div class="col-sm-10">
                            1, <input type="text" name="FEEDBACK1"/><br/>
                            2, <input type="text" name="FEEDBACK2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">特殊装修:</label>
                        <div class="col-sm-10 radio">
                            <label>
                                <input type="radio" name="isSpecialDecoration"
                                       value="1"
                                       <c:if test="${decorationApply.isSpecialDecoration eq 1}">checked="checked"</c:if>/>是
                            </label>
                            <label>
                                <input type="radio" name="isSpecialDecoration"
                                       value="0"
                                       <c:if test="${decorationApply.isSpecialDecoration eq 0}">checked="checked"</c:if>/>否
                            </label>
                            <br/>
                            <input type="text" value="${decorationApply.specialDecorationFile}"/><a href="#">下载</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">审核状态:</label>
                        <div class="col-sm-10 radio">
                            <label>
                                <input type="radio" name="auditStatus" id="optionsRadios1"
                                       <c:if test="${decorationApply.auditStatus eq 0}">checked="checked"</c:if>
                                       value="0"/>未审核
                            </label>
                            <label>
                                <input type="radio" name="auditStatus" id="optionsRadios2"
                                       <c:if test="${decorationApply.auditStatus eq 1}">checked="checked"</c:if>
                                       value="1"/>已通过
                            </label>
                            <label>
                                <input type="radio" name="auditStatus" id="optionsRadios3"
                                       <c:if test="${decorationApply.auditStatus eq 2}">checked="checked"</c:if>
                                       value="2"/>未通过
                            </label>
                        </div>
                    </div>
                    <div class="form-group" style="margin-left:360px">
                        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-save"></span>保存
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        /*alert("");*/
    });
</script>
</html>