<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${cfg.webTitle}">
<meta name="keywords" content="${cfg.metaKeywords}" />
<meta name="description" content="${cfg.metaDescription}" />
</@head>
<link rel="stylesheet" href="${contextPath}/css/jquery.allofthelights.css">
<style type="text/css">
.clickable{
cursor:pointer;
}
.icon-loading-gif{
background: url("${contextPath}/images/preloader-w8-line-black.gif");
}
</style>
</head>
<body>
<#include "header.ftl">
<div class="page" id="page-index">
	<div class="page-region">
		<div class="page-region-content">
			<div class="grid">
				<div class="row">
					<div class="span12">
						<#if domain.status==0>
						<h3 class="as-inline-block"><@shiro.principal/></h3>
						<i class="icon-locked"></i>
						<#elseif domain.status==1>
						<h3 class="as-inline-block"><@shiro.principal/></h3>
						<i class="icon-unlocked" title=""></i>
						<#elseif domain.status==2>
						<h3 class="as-inline-block fg-color-red"><@shiro.principal/></h3>
						<a id="check" title="点击诊断域名状态" href="#"><i class="icon-wrench"></i></a>
						</#if>
						<table class="hovered bordered striped">
							<thead>
								<tr>
									<th class="right">域名</th>
									<th class="right">域名</th>
									<th class="right">邮箱</th>
									<th class="right">状态</th>
									<th class="right">注册时间</th>
									<th class="right">注册ip</th>
								</tr>
							</thead>
							<tbody>
								<#list subdomains as row>
								<tr data-id=${row.id}>
									<td class="right">${row.name}</td>
									<td class="right">${row.fullname}</td>
									<td class="right">${row.email}</td>
									<td class="right">${row.status}</td>
									<td class="right">${row.registTime}</td>
									<td class="right">${row.registIp}</td>
								</tr>
								</#list>
							</tbody>
							<tfoot>
							</tfoot>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<#include "footer.ftl">
<script type="text/javascript">
$(function() {
	$("#check").click(function() {
		_this = $(this).find("i");
		$.ajax({
			url:"${contextPath}/admin/domain/status.json"
			,data:{"dnspodDomainId":"${domain.dnspodDomainId}"}
			,dataType:"json"
			,beforeSend:function(XHR) {
			}
			,success:function(data, textStatus, jqXHR) {
				if (data) {
					if (data.data == "dnserror") {
						alert("域名不可用，请在域名注册处修改dns");
					} else if (data.data == "") {
						_this.removeClass("icon-wrench");
						_this.addClass("icon-unlocked");
						$("h3.as-inline-block").removeClass("fg-color-red");
						alert("域名可用");
					} else if (data.data == "notexist") {
						alert("域名不可用");
					}
				}
			}
		});
	});
});
</script>
</body>
</html>