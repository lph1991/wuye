<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
</head>
<body>

<div class="col-xs-12">

    <div class="panel panel-default tudiqianyue">
        <div class="panel-heading">
            <div class="col-xs-4">角色列表</div>
            <div class="col-xs-8 panel-oprerate">
                <div class="col-xs-12">

                    <span style="margin-right: 10px"><button class="btn btn-info" type="button"><span
                            class="glyphicon glyphicon-pencil"></span>新增</button></span>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <table class="table table-bordered tudiqianyue-table">
                <thead>
                <tr class="info">
                    <th rowspan="2">序号</th>
                    <th rowspan="2">角色名称</th>
                    <th rowspan="2">描述</th>
                    <th rowspan="2">操作</th>
                </tr>
                <tr class="info">

                </tr>
                </thead>
                <tbody class="tudiqianyue-tbody">
                <tr class="tudiqianyue-tdtr">
                    <td>1</td>
                    <td>Admin</td>
                    <td>test</td>
                    <td><a href="#">编辑</a>|<a href="#">删除</a></td>
                </tr>
                <tr class="tudiqianyue-tdtr">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/libs/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var tableEdit = {
        content: function (option) {
            var _tableEdit = this;
            if ($(".tudiqianyue").is(".tableedit")) {
                $(".tudiqianyue-tdtr").find("td").css({
                    "border": "",
                    "background": ""
                });
            }
            $(".tudiqianyue").addClass("tableedit");
            var tr = $(".tudiqianyue-tdtr").length;
            $(".tudiqianyue-tdtr").each(function (_index, _this) {
                var trIndex = _index;
                $(this).find("td").each(function (_index, _this) {
                    var tdIndex = _index;
                    // $(this).attr("contenteditable","true");
                    if (tdIndex == option.start) {
                        $(this).css({"border-left": "2px solid red"});
                    }
                    if (tdIndex == option.end) {
                        $(this).css({"border-right": "2px solid red"});
                    }
                    if (trIndex == 0 && tdIndex >= option.start && tdIndex <= option.end) {
                        $(this).css({"border-top": "3px solid red"})
                    }
                    if (trIndex == tr - 1 && tdIndex >= option.start && tdIndex <= option.end) {
                        $(this).css({"border-bottom": "3px solid red"})
                    }
                    if (tdIndex >= option.start && tdIndex <= option.end) {
                        $(this).css({"background": "#fff"}).attr("contenteditable", "true");
                    }
                });
            });
            if (option.cancel) {
                $(option.cancel).click(function () {
                    _tableEdit.close(option);
                });
            }
            if (typeof option.callback == "function") {
                option.callback();
            }
        },
        setTd: function (option) {
        },
        close: function (option) {
            $(".tudiqianyue").removeClass("tableedit");
            $(".tudiqianyue-tdtr").each(function (_index, _this) {
                var trIndex = _index;
                var tr = $(".tudiqianyue-tdtr").length;
                $(this).find("td").each(function (_index, _this) {
                    var tdIndex = _index;
                    if (tdIndex == option.start) {
                        $(this).css({"border-left": ""})
                    }
                    if (tdIndex == option.end) {
                        $(this).css({"border-right": ""})
                    }
                    if (trIndex == 0 && tdIndex >= option.start && tdIndex <= option.end) {
                        $(this).css({"border-top": ""})
                    }
                    if (trIndex == tr - 1 && tdIndex >= option.start && tdIndex <= option.end) {
                        $(this).css({"border-bottom": ""})
                    }
                    if (tdIndex >= option.start && tdIndex <= option.end) {
                        $(this).css({"background": "#fff"}).attr("contenteditable", "false");
                    }
                });
            });
        },
    };

    $("#edit-xieyi").click(function () {
        tableEdit.content({
            start: 1,
            end: 3,
            cancel: "#tudiqianyue-remove",
            callback: function (data) {
                console.log(111111)
            }
        })
    });
    $("#edit-hetong").click(function () {
        tableEdit.content({
            start: 3,
            end: 6,
            callback: function (data) {

            }
        })
    });
    $("#tudiqianyue-remove").click(function () {

    });
</script>
</html>