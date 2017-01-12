<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Cache-Control" content="max-age=300" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${query} - 商品搜索 - 宜立方商城</title>
	<link rel="stylesheet" type="text/css" href="/css/productList.css" />
<link rel="stylesheet" type="text/css" href="/css/base_w1200.css" />
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="stylesheet" type="text/css" href="/css/jquery.alerts.css" />
<script type="text/javascript" src="/js/jquery-1.5.1.min.js"></script>
</head>
<body>
<!-- header start -->
<jsp:include page="commons/header.jsp" />
<jsp:include page="commons/mainmenu.jsp" />
<!-------面包线 linknav--------->
<div class="linknav">
	<div class="schArticle">
		<a href="/article/search?keyword=%E6%9C%88%E9%A5%BC" target="_blank">找到和“<span>${query}</span>”相关的文章<span
			id="articlenum">${totalPages }</span>篇&gt;&gt;
		</a>
	</div>
	<div class="breadcrumb">
		<span>全部结果&nbsp;&gt;&nbsp;${query}</span>
	</div>
</div>
<div class="content_list">
  <div class="left-box">
    <div class="catlist" id="cateall">
      <div class="ct"><h2>商品精选</h2></div>
		<div class="cm">
			<div class="catitem" style="padding: 10px 12px 10px 12px;">
				<div>
					<div>
						<a target="_blank" href="#">
							<img width="160" height="160" data-img="1" src="images/210x210_1600247877_0_1.jpg" class="err-product">
						</a>
					</div>
					<div>
						<strong style="font-family: Verdana;font-weight: 400;color:#e4393c;">￥139.00</strong>
					</div>
					<div>
						<a target="_blank" href="#">
							<em>自然派 沙爹牛肉干(独立装)100g 100g</em>
						</a>
					</div>
				</div>
			</div>
			<div class="catitem" style="padding: 10px 12px 10px 12px;">
				<div>
					<div>
						<a target="_blank" href="#">
							<img width="160" height="160" data-img="1" src="images/210x210_1800136444_1_10.jpg" class="err-product">
						</a>
					</div>
					<div>
						<strong style="font-family: Verdana;font-weight: 400;color:#e4393c;">￥139.00</strong>
					</div>
					<div>
						<a target="_blank" href="#">
							<em>佳沛zespri 新西兰绿奇异果 6粒（36-39号）</em>
						</a>
					</div>
				</div>
			</div>
			
		</div>
	</div> 
  </div>
  <div class="main-box">
    <div class="related-search"><span>筛选条件：</span></div>
<div class="r-select">
      <div class="cm">
        <div class="attrs-extend">
        <c:if test="${filterList != null }">
        <div class="attr first" style="border-top: 0px;">
            <div class="a-key">已选条件：</div>
            <div class="a-value">
              <div class="c-list">
                <ul>
                  <c:forEach items="${filterList }" var="filter">
                  <li><a href="/search.html?keyword=${query }&amp;<c:forEach items="${filterList }" var="f"><c:if test="${f.param != filter.param }">${f.param }=${f.value }&amp;</c:if></c:forEach>sort=${sort }"><span>${filter.name }：</span>${filter.value}<b></b></a></li>
                  </c:forEach>
                </ul>
			  </div>
		      <div class="c-clear"><span><b></b><a href="/search.html?keyword=${query }&amp;sort=${sort }">清除筛选条件</a></span></div>
			</div>
		</div>
		</c:if>
        <c:if test="${category==null }">
        <div class="attr">
            <div class="a-key">分类：</div>
            <div class="a-value">
				<div class="v-list">
					<ul>
						<c:forEach items="${categoryList }" var="cat">
						<li>
						  <a href="/search.html?keyword=${query }&amp;category=${cat.name }&amp;<c:forEach items="${filterList }" var="f"><c:if test="${f.param != 'category' }">${f.param }=${f.value }&amp;</c:if></c:forEach>sort=${sort }">${cat.name }<span class="v-c">(${cat.count })</span></a>
						</li>
						</c:forEach>
					</ul>
				</div>
				<div class="v-show"><span class="s-more"><b></b>更多</span></div>
            </div>
          </div>
          </c:if>
          <c:if test="${price==null }">
          <div class="attr">
				<div class="a-key">价格：</div>
				<div class="a-value">
				  <div class="v-list">
					<ul>
					<c:forEach items="${priceRange }" var="p">
					<li>
					  <a href="/search.html?keyword=${query }&amp;price=${p.value }&amp;<c:forEach items="${filterList }" var="f"><c:if test="${f.param != 'price' }">${f.param }=${f.value }&amp;</c:if></c:forEach>sort=${sort }">${p.name }</a>
                    </li>
					</c:forEach>
					</ul>
				  </div>
				  <div class="v-show hide"><span class="s-more"><b></b>更多</span></div>
				</div>
			  </div>
		</c:if>
        </div>
        <div class="attrs-show hide"></div>
      </div>
    </div>
   <a id="prolist-id"></a>
    <div class="r-filter">
      <div class="f-sort">
        <div class="sort">
          <ul>
			<li <c:if test="${sort == null || sort.contains('sellnum') }">class="curr"</c:if>><a href="/search.html?keyword=${query }&amp;<c:forEach items="${filterList }" var="f"><c:if test="${f.param != 'price' }">${f.param }=${f.value }&amp;</c:if></c:forEach>sort=<c:if test="${sort==null || sort!='sellnum-asc' }">sellnum-asc</c:if><c:if test="${sort=='sellnum-asc' }">sellnum-desc</c:if>">热卖
				<c:if test="${sort == 'sellnum-asc' }">
				<div class="up"><b></b></div></a>
				</c:if>
				<c:if test="${sort == null || sort == 'sellnum-desc' }">
				<div class="down"><b></b></div></a>
				</c:if>
			  </a>
			</li>
			<li <c:if test="${sort.contains('price') }">class="curr"</c:if>><a href="/search.html?keyword=${query }&amp;<c:forEach items="${filterList }" var="f"><c:if test="${f.param != 'price' }">${f.param }=${f.value }&amp;</c:if></c:forEach>sort=<c:if test="${sort=='price-desc' }">price-asc</c:if><c:if test="${sort!='price-desc' }">price-desc</c:if>">价格
				<c:if test="${sort == 'price-asc'}">
				<div class="up"><b></b></div></a>
				</c:if>
				<c:if test="${sort == 'price-desc' }">
				<div class="down"><b></b></div></a>
				</c:if>
			  </a>
			</li>
          </ul>
        </div>
        <div class="pagin">
          <span class="txt"><span class="n">${page }</span>/${totalPages }</span>
          <span class="prev">上一页</span><span class="next">下一页</span>       	</div>
        <div class="total">共<span>${recourdCount }</span>个商品</div>
      </div>
    </div>
    <a name="prolist" id="prolist"></a>
    <div class="p-list">
      <ul class="list-all">
         <c:forEach items="${itemList }" var="item">
         <li>
            <div class="l-wrap">
				<div class="pic">
					<a class="trackref" href="http://localhost:8086/item/${item.id}.html" title="" target="_blank">
						<img src="${item.img_url}" style="display:inline"/>
					</a>
				</div>
	            <div class="price">
					<span><span class="p-now">￥<strong><fmt:formatNumber groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" value="${item.sell_price }"/></strong></span><span class="p-nor"></span><span class="active" style="">直降</span></span>			
				</div>
	            <div class="title-a">
	                <a class="trackref presaleSign_225865" href="http://localhost:8086/item/${item.id}.html" target="_blank">${item.item_name }</a>
	            </div>
	        	<div class="title-b" style=""><a class="trackref" href="http://localhost:8086/item/${item.id}.html" target="_blank">${item.ad_word }</a></div>
	            <div class="comment">
	                <div class="owner_shop_list">自营</div>                    
	            </div>
		    </div>
		 </li>
         </c:forEach>
    </ul>
      <span class="clear"></span>
    </div>
    
    <div class="pages">
	      </div>
    
  </div>
  <jsp:include page="commons/footer.jsp" />
<script type="text/javascript" src="/js/common.js?v=20160713"></script>
<script type="text/javascript" src="/js/cart.js?v=20160713"></script>
<script type="text/javascript" src="/js/jquery.alerts.js"></script>
<script type="text/javascript" src="/js/NewVersion.js?v=20160713"></script>
<script type="text/javascript" src="/js/cookie.js?v=20160416222"></script>
<script type="text/javascript" src="/js/shadow.js?v=20160416"></script>
</div>
</html>