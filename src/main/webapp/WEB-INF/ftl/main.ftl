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
	                        </tr>
	                    </thead>
	                    <tbody>
                        	<#list data as row>
		                        <tr data-id=${row.id}>
	                        	<td><input type="checkbox" /></td>
	                        	<td class="right">${row.subDomain}</td>
	                        	<td class="right">${row.recordTypeE}</td>
	                        	<td class="right">${row.recordLine}</td>
	                        	<td class="right">${row.value}</td>
	                        	<td class="right">${row.mx}</td>
	                        	<td class="right">${row.ttl}</td>
		                        </tr>
                        	</#list>
	                    </tbody>
	                    <tfoot>
	                        <tr>
	                            <th></th>
	                            <th class="right">
	                            	<input type="text" />
	                            </th>
	                            <th class="right">
	                            	<select>
	                            		<option value="1">A</option>
	                            		<option value="2">CNAME</option>
	                            		<option value="3">TXT</option>
	                            		<option value="4">NS</option>
	                            		<option value="5">AAAA</option>
	                            		<option value="6">MX</option>
	                            		<option value="7">URL</option>
	                            		<option value="8">SRV</option>
	                            	</select>
	                            </th>
	                            <th class="right">
	                            	<select>
	                            		<option value="1">默认</option>
	                            	</select>
	                            </th>
	                            <th class="right">
	                            	<input type="text" />
	                            </th>
	                            <th class="right">
	                            -
	                            </th>
	                            <th class="right">
	                            	<input type="text" />
	                            </th>
	                            <th class="right">
	                            </th>
	                        </tr>
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
$("table").find("tbody").find("tr").each(function() {
	var id = $(this).attr("data-id");
	$(this).html();
});
</script>
</body>
</html>