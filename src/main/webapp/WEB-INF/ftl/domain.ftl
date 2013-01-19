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
						<h3 class="as-inline-block"><@shiro.principal/></h3>
						<#if domain.status==0>
						<i class="icon-locked"></i>
						<#elseif domain.status==1>
						<i class="icon-unlocked"></i>
						<#elseif domain.status==2>
						<i class="icon-wrench"></i>
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
</script>
</body>
</html>