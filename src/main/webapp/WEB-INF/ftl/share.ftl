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
					<div class="row padding10"></div>
					<div class="row">
						<div class="span6 bg-color-blueLight padding20">
							<div class="row">
							<p>
							共享域名需将顶级域名(如:runcat.org、biaoliao.info)托管到域猫上，由域猫对其记录进行管理。
							</p>
							<ul>
								<li>确认你的域名没有添加到dnspod.cn的帐号中</li>
								<li>在域名注册商处将域名的dns服务器修改为f1g1ns1.dnspod.net和f1g1ns2.dnspod.net</li>
								<li>在域猫系统中将域名提交到域猫</li>
								<li>带域名生效</li>
							</ul>
							<p>
							若提示"仅域名所有者可进行此操作",请在你的dnspod.cn帐号中删除此域名才可将其托管到域猫！<br>
							修改 DNS 服务器需要最长 72 小时的全球生效时间，请耐心等待<br>
							若遇到困难请联系QQ群:235696438
							</p>
							</div>
						</div>
						<div class="span6">
							<div class="span4 offset1 padding30 place-left">
								<br>
								<h2 class="">提交域名</h2>
								<form action="" method="post">
									<div class="row content_toggle">
										<div class="input-control text span3">
											<input name="name" type="text" tabindex="1" />
											<button class="helper"></button>
										</div>
										<div class="input-control password span3">
											<input name="password" type="password" tabindex="2" />
											<button class="helper"></button>
										</div>
										<input type="submit" value="提交" tabindex="3" />
									</div>
									<div class="row">
										<span class="span3">${message}</span>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<#include "footer.ftl">
<script src="${contextPath}/js/input-control.js"></script>
<script type="text/javascript">
</script>
</body>
</html>