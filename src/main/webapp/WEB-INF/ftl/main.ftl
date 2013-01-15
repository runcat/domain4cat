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
						<h3 class="as-inline-block">小帮助</h3>
						 <div class="page-control" data-role="page-control">
					        <ul>
					            <li class="active"><a href="#frame1">主机记录</a></li>
					            <li><a href="#frame2">记录类型</a></li>
					            <li><a href="#frame3">线路类型</a></li>
					            <li><a href="#frame4">记录值</a></li>
					            <li><a href="#frame5">MX优先级</a></li>
					            <li><a href="#frame6">TTL</a></li>
					        </ul>
					        
					        <div class="frames">
					            <div class="frame active" id="frame1">
					            主机记录就是域名前缀，常见用法有：<br>
									www：解析后的域名为 www.runcat.org<br>
									@：直接解析主域名 runcat.org<br>
									*：泛解析，匹配其他所有域名 *.runcat.org<br>
					            </div>
					            <div class="frame" id="frame2">
					            要指向空间商提供的 IP 地址，选择「类型 A」，要指向一个域名，选择「类型 CNAME」<br>

									A记录：地址记录，用来指定域名的IPv4地址（如：8.8.8.8），如果需要将域名指向一个IP地址，就需要添加A记录。<br>
									CNAME： 如果需要将域名指向另一个域名，再由另一个域名提供ip地址，就需要添加CNAME记录。<br>
									TXT：在这里可以填写任何东西，长度限制255。绝大多数的TXT记录是用来做SPF记录（反垃圾邮件）。<br>
									NS：域名服务器记录，如果需要把子域名交给其他DNS服务商解析，就需要添加NS记录。<br>
									AAAA：用来指定主机名（或域名）对应的IPv6地址（例如：ff06:0:0:0:0:0:0:c3）记录。<br>
									MX：如果需要设置邮箱，让邮箱能收到邮件，就需要添加MX记录。<br>
									URL：从一个地址301重定向到另一个地址的时候，就需要添加URL记录（注：DNSPod目前只支持显性301重定向）。<br>
									SRV：记录了哪台计算机提供了哪个服务。格式为：服务的名字、点、协议的类型，例如：_xmpp-server._tcp。<br>
					            
					            </div>
					            <div class="frame" id="frame3">
					            若空间商只提供了一个 IP 地址或域名，选择「默认」就可以了<br>
									让指定线路的用户访问这个IP<br>
									常见用法有：<br>
									默认：必须添加，否则只有单独指定的线路才能访问您的网站。如果双线解析，建议「默认」线路填写「电信IP」<br>
									联通：单独为「联通用户」指定服务器 IP，其他用户依然访问「默认」<br>
									搜索引擎：指定一个服务器 IP 让蜘蛛抓取<br>
					            </div>
					            <div class="frame" id="frame4">
					            最常见的是将空间商提供的「IP地址」填写在这里哦～<br>

									各类型的记录值一般是这样的：<br>
									
									A记录：填写您服务器 IP，如果您不知道，请咨询您的空间商<br>
									CNAME记录：填写空间商给您提供的域名，例如：dnspod.cn
									MX记录：填写您邮件服务器的IP地址或企业邮局给您提供的域名，如果您不知道，请咨询您的邮件服务提供商<br>
									TXT记录：一般用于 Google、QQ等企业邮箱的反垃圾邮件设置<br>
									URL记录：填写要跳转到的网址，例如：http://www.baidu.com<br>
									AAAA：不常用。解析到 IPv6 的地址。<br>
									NS记录：不常用。系统默认添加的两个NS记录请不要修改。NS向下授权，填写dns域名，例如：f1g1ns1.dnspod.net<br>
									SRV记录：不常用。格式为：优先级、空格、权重、空格、端口、空格、主机名，记录生成后会自动在域名后面补一个“.”，这是正常现象。例如：5 0 5269 xmpp-server.l.google.com.<br>
					            </div>
					            <div class="frame" id="frame5">
					            MX优先级，用来指定邮件服务器接收邮件的先后顺序（1-50），一般默认设置为5、10、15等<br>
					            </div>
					            <div class="frame" id="frame6">
					            我们默认的 600 秒是最常用的，不用修改<br>

									即 Time To Live，缓存的生存时间。指地方dns缓存您域名记录信息的时间，缓存失效后会再次到DNSPod获取记录值。<br>
									
									600（10分钟）：建议正常情况下使用 600。<br>
									60（1分钟）：如果您经常修改IP，修改记录一分钟即可生效。长期使用 60，解析速度会略受影响。<br>
									3600（1小时）：如果您IP极少变动（一年几次），建议选择 3600，解析速度快。如果要修改IP，提前一天改为 60，即可快速生效。<br>
					            </div>
					        </div>
					    </div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<#include "footer.ftl">
<script type="text/javascript" src="${contextPath}/js/pagecontrol.js"></script>
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