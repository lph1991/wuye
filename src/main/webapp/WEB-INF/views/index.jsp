<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: luopa
  Date: 2017/5/24
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <%@include file="/common/common.jsp" %>
    <script type="text/javascript">
        function logout() {
            location.href = "/loginOut";
        }
    </script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" id="header">
    <div class="container">
        <div class="col-md-4 col-xs-4">
            <img class="logo-img" src="${pageContext.request.contextPath}/imgs/logo02.png">
        </div>
        <div class="col-md-8 col-xs-8">
            <div class="col-xs-12">
                <shiro:user>
                    <div class="nav-group">
                        <div class="user-container">
                            <div class="user-photo-wrap"><img
                                    src="${pageContext.request.contextPath}/imgs_test/timg.jpg" alt="..."
                                    class="img-circle user-photo"></div>
                            <div class="user-name"><shiro:principal property="realname"/></div>
                        </div>
                        <button class="btn btn-default" type="button" onclick="logout()"><span class="glyphicon glyphicon-off"></span>退出
                    </div>
                </shiro:user>
            </div>

        </div>
    </div>
</nav>

<aside class="aside" id="aside1">
    <div class="navbar-collapse bs-example-js-navbar-collapse collapse" aria-expanded="false">
        <aside id="aside2">
            <ul class="panel-group level01" id="aside_one_01" role="tablist">
                <shiro:hasPermission name="customer_manage">
                    <li class="panel" role="tab" id="panel_one_01">
                        <div class="panel-header">
                            <a data-toggle="collapse" data-parent="#aside_one_01" href="#collapse_one_01">
                                <span class="icon glyphicon glyphicon-user"></span>
                                用户管理
                                <div class="arrow"><span class="glyphicon glyphicon-menu-right"></span></div>
                            </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse_one_01" role="tablist">
                            <ul class="panel-group level02" id="aside_one_02">
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/user/getAllUser?pageNum=1&pageSize=10"
                                           target="main">用户列表</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="payment_manage">
                    <li class="panel" role="tab" id="panel_two_01">
                        <div class="panel-header">
                            <a data-toggle="collapse" data-parent="#aside_two_01" href="#collapse_two_01">
                                <span class="icon glyphicon glyphicon-credit-card"></span>
                                快捷缴费
                                <div class="arrow"><span class="glyphicon glyphicon-menu-right"></span></div>
                            </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse_two_01" role="tablist">
                            <ul class="panel-group level02" id="aside_two_02">
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/propertyRecords/payFeeRecords"
                                           target="main">物业费用</a>
                                    </div>
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/propertyRecords/index"
                                           target="main">物业缴费记录</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/kfRecords/payFeeRecords"
                                           target="main">开发费用</a>
                                    </div>
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/kfRecords/index" target="main">开发缴费记录</a>
                                    </div>
                                </li>
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/utilitiesRecords/electricIndex"
                                           target="main">电费缴费记录表</a>
                                    </div>

                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/utilitiesRecords/waterIndex"
                                           target="main">水费缴费记录表</a>
                                    </div>
                                </li>
                                
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/account/index" target="main">对账表</a>
                                    </div>
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/account/accountDetails" target="main">对账表明细</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="house&contract_manage">
                    <li class="panel" role="tab" id="panel_three_01">
                        <div class="panel-header">
                            <a data-toggle="collapse" data-parent="#aside_three_01" href="#collapse_three_011">
                                <span class="icon glyphicon glyphicon-book"></span>
                                房屋及合同
                                <div class="arrow"><span class="glyphicon glyphicon-menu-right"></span></div>
                            </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse_three_011" role="tablist">
                            <ul class="panel-group level02" id="aside_three_011">
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/houseInfoDetailsBack/getHouseInfoDetailsList?pageNum=1&pageSize=10"
                                           target="main">房产信息</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/sellContractBack/getSellContractList?pageNum=1&pageSize=10"
                                           target="main">销售合同表</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/rentContractBack/getRentContractList?pageNum=1&pageSize=10"
                                           target="main">租赁合同表</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="business">
                    <li class="panel" role="tab" id="panel_four_01">
                        <div class="panel-header">
                            <a data-toggle="collapse" data-parent="#aside_four_01" href="#collapse_four_01">
                                <span class="icon glyphicon glyphicon-thumbs-up"></span>
                                业务办理
                                <div class="arrow"><span class="glyphicon glyphicon-menu-right"></span></div>
                            </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse_four_01" role="tablist">
                            <ul class="panel-group level02" id="aside_four_02">
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/dist/enterApply/enterApplyList?pageNum=1&pageSize=500"
                                           target="main">入住申请</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main"
                                           href="${pageContext.request.contextPath}/dist/enterMaterial/findEnterMaterialList?pageNum=1&pageSize=500">入住资料列表</a>
                                    </div>

                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main"
                                           href="${pageContext.request.contextPath}/dist/toDecorationApplyList">装修申请</a>
                                    </div>

                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${pageContext.request.contextPath}/dist/decorationMateria/todecorationMateria">装修附件与资料</a>
                                    </div>
                                </li>


                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" target="main"
                                           href="${pageContext.request.contextPath}/findRetreatLeaseApply">退租申请</a>
                                    </div>

                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main"
                                           href="${pageContext.request.contextPath}/findReletApply">续租申请</a>
                                    </div>

                                </li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasPermission>

                <shiro:hasPermission name="system_manage">
                    <li class="panel" role="tab" id="panel_five_01">
                        <div class="panel-header">
                            <a data-toggle="collapse" data-parent="#aside_four_01" href="#collapse_five_01">
                                <span class="icon glyphicon glyphicon-cog"></span>
                                系统设置
                                <div class="arrow"><span class="glyphicon glyphicon-menu-right"></span></div>
                            </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse_five_01" role="tablist">
                            <ul class="panel-group level02" id="aside_five_02">
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/admin/sys/rename/1">更名</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/admin/sys/decoinfo/2">装修须知</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/page/system/waterele/houslist">房产电费限制</a>
                                    </div>

                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/page/system/waterele/projectlist">项目电费限制</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/admin/sys/set">系统信息设置</a>
                                    </div>
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/admin/sys/checkinprompt/3">入住提示信息</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/page/system/project/projectlist">项目设置</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/page/system/bill/propertylist">物业开票列表</a>
                                    </div>
                                </li>
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/page/system/bill/develist">开发开票列表</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a target="main" href="${basePath}/admin/sys/ammelist">电表设置</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasPermission>

                <shiro:hasPermission name="message_manage">
                    <li class="panel" role="tab" id="panel_six_01">
                        <div class="panel-header">
                            <a data-toggle="collapse" data-parent="#aside_six_01" href="#collapse_six_011">
                                <span class="icon glyphicon glyphicon-bullhorn"></span>
                                通知管理
                                <div class="arrow"><span class="glyphicon glyphicon-menu-right"></span></div>
                            </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse_six_011" role="tablist">
                            <ul class="panel-group level02" id="aside_six_011">
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/messageManageBack/getMessageManageList?pageNum=1&pageSize=10"
                                           target="main">通知列表</a>
                                    </div>
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/messageManageBack/messageManageEdit"
                                           target="main">发布通知</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasPermission>

                <shiro:hasPermission name="dictionary">
                    <li class="panel" role="tab" id="panel_seven_01">
                        <div class="panel-header">
                            <a data-toggle="collapse" data-parent="#aside_four_01" href="#collapse_seven_01">
                                <span class="icon glyphicon glyphicon-wrench"></span>
                                数据字典
                                <div class="arrow"><span class="glyphicon glyphicon-menu-right"></span></div>
                            </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse_seven_01" role="tablist">
                            <ul class="panel-group level02" id="aside_seven_02">
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/typeRefinement/getTypeData?pageNum=1&pageSize=10&typeDifferentiateId=9"
                                           target="main">通知类型</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/typeRefinement/getTypeData?pageNum=1&pageSize=10&typeDifferentiateId=1"
                                           target="main">房产使用属性</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/typeRefinement/getTypeData?pageNum=1&pageSize=10&typeDifferentiateId=2"
                                           target="main">企业在U谷中的属性</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/typeRefinement/getTypeData?pageNum=1&pageSize=10&typeDifferentiateId=3"
                                           target="main">所属行业</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/typeRefinement/getTypeData?pageNum=1&pageSize=10&typeDifferentiateId=4"
                                           target="main">上市类型</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/typeRefinement/getTypeData?pageNum=1&pageSize=10&typeDifferentiateId=5"
                                           target="main">专利类型</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/typeRefinement/getTypeData?pageNum=1&pageSize=10&typeDifferentiateId=6"
                                           target="main">退租类型</a>
                                    </div>

                                </li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasPermission>

                <shiro:hasPermission name="authority">
                    <li class="panel" role="tab" id="panel_eight_01">
                        <div class="panel-header">
                            <a data-toggle="collapse" data-parent="#aside_four_01" href="#collapse_eight_01">
                                <span class="icon glyphicon glyphicon-lock"></span>
                                权限
                                <div class="arrow"><span class="glyphicon glyphicon-menu-right"></span></div>
                            </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse_eight_01" role="tablist">
                            <ul class="panel-group level02" id="aside_eight_02">
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/user/index" target="main">管理用户列表</a>
                                    </div>
                                </li>

                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/admin/role/roleIndex" target="main">角色列表</a>
                                    </div>
                                </li>
                                <li class="panel" role="tab">
                                    <div class="panel-header">
                                        <a href="${pageContext.request.contextPath}/topay" target="main">支付</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasPermission>
            </ul>
        </aside>
    </div>
</aside>
<article class="container article" id="article">
    <!-- 正文部分 -->
    <!--<iframe class="my-iframe" id="main" src="./index-level2.html"></iframe>-->
    <iframe class="my-iframe" id="main" src="about:blank" name="main"></iframe>
</article>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript">


    $(".aside-more").click(function () {
        $("body").toggleClass("aside-on");
    });
    $(function () {
        $("[data-toggle='collapse']").click(function () {
            var value = $(this).attr("href");
            if (value === "#") {
                $("#main-lv2").attr("src", "userlist.jsp");
            }
        })
    })
    function changeTitle(title) {
        $("#main-lv2").attr("src", "${pageContext.request.contextPath}/html_page/page/" + title);
    }

</script>
</html>
