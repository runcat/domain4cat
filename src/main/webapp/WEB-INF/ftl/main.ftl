<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${cfg.webTitle}">
<meta name="keywords" content="${cfg.metaKeywords}"/>
<meta name="description" content="${cfg.metaDescription}"/>
</@head>
</head>
<body>
<#include "header.ftl">
<div class="page" id="page-index">
    <div class="page-region">
        <div class="page-region-content">
            <div class="grid">
                <div class="row">
                    <div class="span12">
                    <h3><@shiro.principal/></h3>
                    <table class="hovered bordered striped">
	                    <thead>
	                        <tr>
	                            <th><input type="checkbox" /></th>
	                            <th class="right">主机记录</th>
	                            <th class="right">记录类型</th>
	                            <th class="right">线路类型</th>
	                            <th class="right">记录值</th>
	                            <th class="right">MX优先级</th>
	                            <th class="right">TTL</th>
	                            <th class="right">操作</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <tr>
	                        	<#list data as row>
	                        	<td><input type="checkbox" /></td>
	                        	<td class="right">${row.subDomain}</td>
	                        	<td class="right">${row.recordType}</td>
	                        	<td class="right">${row.recordLine}</td>
	                        	<td class="right">${row.value}</td>
	                        	<td class="right">${row.mx}</td>
	                        	<td class="right">${row.ttl}</td>
	                        	<td class="right"></td>
	                        	</#list>
	                        </tr>
	                    </tbody>
	                    <tfoot></tfoot>
	                </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<#include "footer.ftl">
<script type="text/javascript" src="js/carousel.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn_check").click(function() {
		var s_name = $("#name").val();
		var s_domain = $("#domain").val();
		var s_domain_text = $("#domain").find("option:selected").text();
		$.ajax({
			url:"${contextPath}/domain/"+s_domain+"/valid/"+s_name+".json"
			,dataType:"json"
			,beforeSend:function(XHR) {
				$("#btn_check").attr("disabled", true);
			}
			,success:function(data, textStatus, jqXHR) {
				if (data) {
					if (data.result) {
						$("#msg").html("被使用了，换一个吧！").show();
					} else {
						$("#subdomain").val(s_name+"."+s_domain_text);
						$("#msg").html("赶快输入密码占有她吧！");
						$(".content_toggle").toggle();
					}
				}
			}
			,complete:function(XHR, TS) {
				$("#btn_check").attr("disabled", false);
			}
		});
	});
	$("#btn_sub").click(function() {
		var s_name = $("#subdomain").val();
		var s_domain = $("#domain").val();
		var s_password = $("#password").val();
		$.ajax({
			url:"${contextPath}/domain.json"
			,type:"post"
			,dataType:"json"
			,data:{"name":s_name,"pid":s_domain,"plainPassword":s_password}
			,beforeSend:function(XHR) {
				$("#btn_sub").attr("disabled", true);
			}
			,success:function(data, textStatus, jqXHR) {
				if (data) {
					if (data.result) {
						$("#msg").html('占有成功，去登录<a href="${contextPath}/login"><i class="icon-arrow-right-3 fg-color-red"></i></a>');
					} else {
						$("#msg").html("---");
						$("#btn_sub").attr("disabled", false);
					}
				}
			}
		});
	});
    $('.github-info').each(function(){
        var $container = $(this);
        var repo = $container.data('repo');

        $.ajax({
            url: 'https://api.github.com/repos/' + repo,
            dataType: 'jsonp',

            success: function(results){
                var repo = results.data;
                var watchers = repo.watchers;
                var forks = repo.forks;
                //console.log(watchers, forks);
                $(".github-watchers").html(watchers);
                $(".github-forks").html(forks);
            }
        })
    });
});
</script>
</body>
</html>