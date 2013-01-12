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
                    <div class="span6">
					        <img src="${contextPath}/img/cat.png" />
					        <p class="tertiary-info-secondary-text bg-color-grayDark" style="padding: 10px; color: #fff;">
                            
                        </p>
                    </div>
                    <div class="span6">
                        <div class="span4 offset1 padding30 place-left">
                            <br>
                            <h2 class="">管理域名</h2>
                            <form id="login-form" action="${contextPath}/login" method="post">
                            	<div class="row">
											<div class="input-control text span3">
										        <input id="username" name="username" type="text" placeholder="域名" />
										        <button class="helper"></button>
										    </div>
											<div class="input-control password span3">
												<input id="password" name="password" type="password" placeholder="密码" /><button class="helper"></button>
											</div>
											<label class="input-control checkbox">
										        <input type="checkbox" name="rememberMe">
										        <span class="helper">下次自动登录</span>
										    </label>
                            	</div>
									    <div class="row">
									    	<span id="msg" class="span3">${shiroLoginFailure}</span>
									    </div>
									    <input id="btn_check" type="submit" value="管理"/>
                            </form>
                        </div>
                    </div>
                </div>
            	<div class="row padding40"></div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftl">
<script type="text/javascript">
</script>
</body>
</html>