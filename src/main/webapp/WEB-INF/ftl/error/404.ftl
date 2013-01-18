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
<#include "error/header.ftl">
<div class="page" id="page-index">
    <div class="page-region">
        <div class="page-region-content">
            <div class="grid">
            <h3>找不到</h3>
				<p>${message}</p>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftl">
</body>
</html>