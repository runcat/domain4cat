<div class="page">
        <div class="nav-bar">
            <div class="nav-bar-inner padding10">
                <span class="element">
                    2012, Metro UI CSS © by <a class="fg-color-white" href="mailto:sergey@pimenov.com.ua">Sergey Pimenov</a>
                </span>
            </div>
        </div>
    </div>
<script src="${contextPath}/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
<#if (cfg.duoshuoKey)!""=="">
<!-- Duoshuo Comment BEGIN -->
	var duoshuoQuery = {
		short_name:"${cfg.duoshuoKey}"
		,sso:{
			login:"${cfg.hostUrl}${contextPath}/dsLogin",
			logout:"${cfg.hostUrl}${contextPath}/logout"
		}
	};
	(function() {
		var ds = document.createElement('script');
		ds.type = 'text/javascript';ds.async = true;
		ds.src = 'http://static.duoshuo.com/embed.js';
		ds.charset = 'UTF-8';
		(document.getElementsByTagName('head')[0] 
		|| document.getElementsByTagName('body')[0]).appendChild(ds);
	})();
<!-- Duoshuo Comment END -->
</#if>
$(function() {
	$('.carousel').carousel();
	$('#qrcode').qrcode({width: 188,height: 188,text: window.location.href});
});
</script>
<div style="display: none;">${cfg.hiddenSource}</div>
