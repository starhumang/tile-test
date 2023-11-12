<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="resources/images/${vo.prodImage }" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1"></div>
                        <h1 class="display-5 fw-bolder">${vo.prodName }</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through">${vo.price }</span>
                            <span>${vo.offPrice }</span>
                        </div>
                        <p class="lead">${vo.prodDesc }</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Related products</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <!-- 상품목록 -->
                    <c:forEach items="${list }" var="item">
                    <c:if test="${item.prodCode != vo.prodCode }">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="resources/images/${item.prodImage }" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Special Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <c:forEach  begin="1" end="${item.likeIt }" step="1">
                                        <div class="bi-star-fill"></div>
                                        </c:forEach>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">${item.price }</span>
                                    ${item.offPrice }
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productInfo.do?prodCode=${item.prodCode }">상세보기</a></div>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    </c:forEach>
   
                    </div>
                <!-- 상품목록 -->
                </div>
        </section>
       <script>
       const prodCode= "${vo.prodCode}"
    		function initList(){
       			
       			
       			fetch('infoBodyList.do', {
    				method: 'post',
    				headers: {
    					'Content-Type': 'application/x-www-form-urlencoded'
    				},
    				body: 'prodCode=' + prodCode
    			})
    			.then(resolve => resolve.json())
    			.then(result => {
    				console.log(result)
    			})
       			
       		}
       initList();
       </script>