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
                    <div class="span12 padding10 fg-color-darken text-center">
                        分享你的域名，成就万千用户！<i>请使用IE9+等现代浏览器</i>
                    </div>
                </div>
                <div class="row">
                    <div class="span8">
                        <div class="hero-unit">
                            <div id="carousel1" class="carousel" data-role="carousel" data-param-duration="300">
                                <div class="slides">

                                    <div class="slide" id="slide1" style="display: block; left: 0px; ">
                                        <h2>域猫干什么</h2>
										<br>
                                        <p class="bg-color-blueDark padding20 fg-color-white">
                                            将域名托管到域猫，不明真相的群众就可以申请、使用和管理此域名的二级域名。<br>
                                            二级域名用户可以管理此二级域名记录，支持A、CNAME、URL等…<br>
                                            由域猫负责该域名记录的维护和管理。<br>
                                            域猫系统目前功能粗糙，希望广大基友共同开发分享、域名管理等功能。
                                        </p>
                                        
                                    </div>

                                    <div class="slide" id="slide2" style="display: block; left: -580px; ">
                                        <h2 class="fg-color-darken">分享域名</h2>
                                        <p class="bg-color-red padding20 fg-color-white">
                                            我想将我闲置的域名<strong><a href="${contextPath}/domain/share">共享</a></strong>给大家用？<br>
                                            分享功能已经上线，任何问题可联系at1943@gmail.com。<br>
                                            分享前请考核以下分享条件：
                                        </p>

                                        <div class="span3 place-left">
                                            <ul class="unstyled sprite-details">
                                                <li><i class="icon-checkmark"></i> 拥有域名</li>
                                                <li><i class="icon-checkmark"></i> dns记录设置到dnspod.cn</li>
                                                <li><i class="icon-checkmark"></i> 及时续费</li>
                                            </ul>
                                        </div>
                                        <div class="span3 place-left">
                                            <ul class="unstyled sprite-details">
                                                <li><i class="icon-checkmark"></i> 愿托管到域猫分享</li>
                                                <li><i class="icon-checkmark"></i> 域名由域猫管理解析</li>
                                                <li><i class="icon-checkmark"></i> 承诺1年以上的共享期</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <span class="control left"><i class="icon-arrow-left-3"></i></span>
                                <span class="control right"><i class="icon-arrow-right-3"></i></span>

	                            <div class="markers">
		                            <ul>
			                            <li class=""><a href="javascript:void(0)" data-num="0"></a></li>
			                            <li class=""><a href="javascript:void(0)" data-num="1"></a></li>
		                            </ul>
	                            </div>
                            </div>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="span4 padding30 place-left bg-color-blueLight" id="sponsorBlock">
                            <br>
                            <h2 class="">想加入 ?</h2>
                            	<div class="row content_toggle">
											<div class="input-control text span3">
										        <input id="name" type="text" />
										        <button class="helper"></button>
										    </div>
											<div class="input-control select span3">
										        <select id="domain">
										        	<#list data as row>
										            <option value="${row.dnspodDomainId}">${row.name}</option>
										        	</#list>
										        </select>
										    </div>
									    <input id="btn_check" type="button" value="我要"/>
                            	</div>
                            	<div class="row content_toggle no-display">
											<div class="input-control text span3 outline-color-red">
										        <input id="subdomain" type="text" readonly="readonly" />
										    </div>
											<div class="input-control password span3">
												<input id="password" type="password" /><button class="helper"></button>
											</div>
									    <input id="btn_sub" type="button" value="占有"/>
                            	</div>
									    <div class="row">
									    	<span id="msg" class="span3">输入并选择喜欢的域名</span>
									    </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="grid">
                <div class="row">
                	<div class="span8">
                		<div class="row" style="margin-bottom: 22px;">
	                    <div class="span4 bg-color-blue">
	                        <img src="images/simple.png" class="place-right" style="margin: 10px;">
	                        <h2 class="fg-color-white">&nbsp;分享闲置域名</h2>
	                    </div>
	
	                    <div class="span4 bg-color-green">
	                        <img src="images/grid.png" class="place-right" style="margin: 10px;">
	                        <h2 class="fg-color-white">&nbsp;免费二级域名</h2>
	                    </div>
                		</div>
                		<div class="row">
	                    <div class="span4 bg-color-pink">
	                        <img src="images/logo32.png" class="place-right" style="margin: 10px;height: 48px;">
	                        <h2 class="fg-color-white">&nbsp;详细管理面板</h2>
	                    </div>
								<div class="span4 bg-color-yellow">
	                        <img src="images/responsive.png" class="place-right" style="margin: 10px;">
	                        <h2 class="fg-color-white">&nbsp;多方式使用</h2>
	                    </div>
                		</div>
                	</div>
                	<div class="span4">
                		<div class="row">
                        <h2><i class="icon-github-3"></i> GitHub Project Info:</h2>
                        <table class="github-info" data-repo="runcat/domain4cat">
                            <tbody>
                            <tr>
                                <td><i class="icon-star-4"></i> Starred:</td>
                                <td class="right"><span class="github-watchers">0</span></td>
                            </tr>
                            <tr>
                                <td><i class="icon-share-2"></i> Forks:</td>
                                <td class="right bg"><span class="github-forks">0</span></td>
                            </tr>
                            <tr>
                                <td colspan="2" style="padding: 20px 0 0; border: 0;">
                                    <button class="image-button bg-color-orange fg-color-white" onclick="document.location.href='https://github.com/runcat/domain4cat'">View on Github<img class="bg-color-pinkDark" src="images/github.png"></button>
                                    <button class="image-button bg-color-darken fg-color-white" onclick="document.location.href='https://github.com/runcat/domain4cat/zipball/master'">Download<img class="bg-color-green" src="images/download-32.png"></button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                		</div>
                	</div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftl">
<script type="text/javascript" src="${contextPath}/js/carousel.js"></script>
<script src="${contextPath}/js/input-control.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn_check").click(function() {
		var s_name = $("#name").val();
		var s_domain = $("#domain").val();
		var s_domain_text = $("#domain").find("option:selected").text();
		$.ajax({
			url:"${contextPath}/subdomain/valid.json"
			,data:{"dnspodDomainId":s_domain,"name":s_name}
			,dataType:"json"
			,beforeSend:function(XHR) {
				$("#btn_check").attr("disabled", true);
			}
			,success:function(data, textStatus, jqXHR) {
				if (data) {
					if (data.result) {
						$("#msg").html("被使用了，换一个吧！").show();
					} else {
						$("#subdomain").val(s_name+"."+s_domain_text);
						$("#msg").html("赶快输入密码占有她吧！");
						$(".content_toggle").toggle();
					}
				}
			}
			,complete:function(XHR, TS) {
				$("#btn_check").attr("disabled", false);
			}
		});
	});
	$("#btn_sub").click(function() {
		var s_name = $("#name").val();
		var s_fullname = $("#subdomain").val();
		var s_domain = $("#domain").val();
		var s_password = $("#password").val();
		$.ajax({
			url:"${contextPath}/subdomain.json"
			,type:"post"
			,dataType:"json"
			,data:{"name":s_name,"fullname":s_fullname,"dnspodDomainId":s_domain,"password":s_password}
			,beforeSend:function(XHR) {
				$("#btn_sub").attr("disabled", true);
			}
			,success:function(data, textStatus, jqXHR) {
				if (data) {
					if (data.result) {
						$("#msg").html('占有成功，去登录<a href="${contextPath}/login"><i class="icon-arrow-right-3 fg-color-red"></i></a>');
					} else {
						$("#msg").html(data.message);
						$("#btn_sub").attr("disabled", false);
					}
				}
			}
		});
	});
    $('.github-info').each(function(){
        var $container = $(this);
        var repo = $container.data('repo');

        $.ajax({
            url: 'https://api.github.com/repos/' + repo,
            dataType: 'jsonp',

            success: function(results){
                var repo = results.data;
                var watchers = repo.watchers;
                var forks = repo.forks;
                //console.log(watchers, forks);
                $(".github-watchers").html(watchers);
                $(".github-forks").html(forks);
            }
        })
    });
});
</script>
</body>
</html>