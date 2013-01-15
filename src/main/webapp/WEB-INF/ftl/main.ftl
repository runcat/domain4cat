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
						<a id="switch1" class="no-display"></a>
						<a id="switch1_off" class="no-display"></a>
						<table class="hovered bordered striped">
							<thead>
								<tr>
									<th style="width: 43px;"></th>
									<th class="right">主机记录</th>
									<th class="right">记录类型</th>
									<th class="right">线路类型</th>
									<th class="right">记录值</th>
									<th class="right">MX优先级</th>
									<th class="right">TTL</th>
									<th class="right"></th>
								</tr>
							</thead>
							<tbody>
								<#list data as row>
								<tr data-id=${row.id}>
									<td><h6 class="icon-pencil clickable" style="margin: 0 0;" title="编辑"></h6></td>
									<td class="right">${row.subDomain}</td>
									<td class="right">${row.recordTypeE}</td>
									<td class="right">${row.recordLine}</td>
									<td class="right">${row.value}</td>
									<td class="right">${row.mx}</td>
									<td class="right">${row.ttl}</td>
									<td class="right"></td>
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
<script type="text/javascript" src="${contextPath}/js/jquery.allofthelights.js"></script>
<script type="text/javascript">
var recordTypeTem = '<select>\
									<option value="1">A</option>\
									<option value="2">CNAME</option>\
									<option value="3">TXT</option>\
									<option value="4">NS</option>\
									<option value="5">AAAA</option>\
									<option value="6">MX</option>\
									<option value="7">URL</option>\
									<option value="8">SRV</option>\
							</select>';
var recordLineTem = '<select><option value="1">默认</option></select>';
$("table").find("h6").live('click', function() {
	var _this = $(this);
	var tr = _this.parent().parent();
	var id = tr.attr("data-id");
	$.ajax({
		url:"${contextPath}/admin/dnsrecord/"+id+"/edit.json"
			,type:"get"
			,dataType:"json"
			,beforeSend:function(XHR) {
			}
			,success:function(data, textStatus, jqXHR) {
				if (data) {
					if (data.result) {
						var r = data.data;
						var trclone = tr.clone();
						tr.find("h6").hide();
						var tds = tr.find("td");
						tr.allofthelights({"switch_id":"switch1","opacity":"0.3"});
						$("#switch1").click();
						$(tds[2]).html(recordTypeTem);
						$(tds[3]).html(recordLineTem);
						$(tds[4]).html('<input type="text" value="'+r.value+'" />');
						$(tds[6]).html('<input type="text" value="'+r.ttl+'" />');
						$(tds[7]).html('<a id="ok" class="clickable">确定</a><a id="cancel" class="clickable">取消</a>');
						tr.find("select").val(r.recordType);
						$("#cancel").click(function(){
							tr.html(trclone.find("td"));
							$("#switch1_off").click();
							tr.find("h6").show();
						});
						$("#ok").click(function(){
							var inputs = tr.find("input");
							r.recordType = tr.find("select").val();
							r.value = inputs[0].value;
							r.ttl = inputs[1].value;
							$.ajax({
								url:"${contextPath}/admin/dnsrecord/"+id+".json"
									,type:"post"
									,dataType:"json"
									,data:r
									,success:function(data, textStatus, jqXHR) {
										if (data) {
											if (data.result) {
												$(tds[2]).html(data.dnsRecord.recordTypeE);
												$(tds[3]).html(data.dnsRecord.recordLine);
												$(tds[4]).html(data.dnsRecord.value);
												$(tds[6]).html(data.dnsRecord.ttl);
												$(tds[7]).html("");
												$("#switch1_off").click();
												tr.find("h6").show();
											} else {
												alert(data.message);
											}
										}
									}
							});
						});
					} else {
						$("#msg").html("---");
						$("#btn_sub").attr("disabled", false);
					}
				}
			}
	});
	$(this).html();
});
</script>
</body>
</html>