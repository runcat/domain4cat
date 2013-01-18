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
						<div class="span6 offset3">
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
<script type="text/javascript">
</script>
</body>
</html>