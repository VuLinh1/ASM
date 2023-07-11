<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <meta charset="UTF-8" />
        <meta name="description" content="Ogani Template" />
        <meta name="keywords" content="Ogani, unica, creative, html" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>GeeksforBooks</title>

        <!-- Google Font -->
        <link
            href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
            rel="stylesheet"
            />
        <style>
            html{
                scroll-behavior: smooth;
            }

            #myBtn {
                display: none;
                position: fixed;
                bottom: 20px;
                right: 30px;
                z-index: 99;
                font-size: 18px;
                border: none;
                outline: none;
                background-color: green;
                color: white;
                cursor: pointer;
                padding: 15px;
                border-radius: 4px;
            }

            #myBtn:hover {
                background-color: #333;
            }
        </style>
        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css" />
        <link rel="stylesheet" href="css/nice-select.css" type="text/css" />
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css" />
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css" />
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css" />
        <link rel="stylesheet" href="css/style.css?v=6" type="text/css" />
        <link rel="stylesheet" href="css/pagination.css" type="text/css" />
    </head>

    <body>
        <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
        <!-- Humberger Begin -->
        <%@include file="Component/header-authen.jsp" %>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
        <%@include file="Component/header-infor.jsp" %>

        <!-- Header Section End -->

        <!-- Hero Section Begin -->
        <%@include file="Component/hero-section.jsp" %>
        <!-- Hero Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg m-0 p-0" >
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">

                        <h2 class="webbook-heading">
                            <span>GeeksforBooks</span>

                        </h2>
                        <div class="breadcrumb__option">
                            <a href="/home">Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Section Begin -->
    <section class="product spad pt-0">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">

                        <div class="sidebar__item">
                            <h4>Price</h4>
                            <div class="price-range-wrap">
                                <form action="shop" method="get">
                                    <c:if test="${requestScope.genreId != 0}">
                                        <input type="hidden" name="genreId" value="${requestScope.genreId}">
                                    </c:if>
                                    <h5 class="section-title  text-uppercase mb-3"><span class="Filter">Filter by price ($)</span></h5>
                                    <div
                                        class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                        data-min="10"
                                        data-max="540"
                                        >
                                        <div
                                            class="ui-slider-range ui-corner-all ui-widget-header"
                                            ></div>
                                        <span
                                            tabindex="0"
                                            class="ui-slider-handle ui-corner-all ui-state-default"
                                            ></span>
                                        <span
                                            tabindex="0"
                                            class="ui-slider-handle ui-corner-all ui-state-default"
                                            ></span>
                                    </div>
                                    <div class="range-slider">
                                        <div class="price-input">
                                            <input type="text" id="minamount"name="priceFrom"  value=""/>
                                            <input type="text" id="maxamount"  name="priceTo" value=""/>
                                        </div>
                                    </div>
                                    <button type="submit" style="background-color: black" class="btn btn-primary px-5 w-100"><i class="fa fa-filter mr-1"></i> Filter</button>
                                </form>
                            </div>
                        </div>


                        <div class="sidebar__item">

                            <h2 style="font-family: 'Times New Roman', serif; font-size: 28px; text-align: center; color: #6b584d; letter-spacing: 2px;">
                                Embark on an <span style="color: #a9978e;">Endless Journey</span><br>
                                of <span style="color: #a9978e;">Imagination</span> and <span style="color: #a9978e;">Knowledge</span><br>
                                with Our <span style="color: #a9978e;">Vast Library</span> of Captivating <span style="color: #a9978e;">Books</span>!
                            </h2>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="product__discount">
                        <div class="section-title product__discount__title">
                            <h2>Sale Off</h2>
                        </div>
                        <div class="row">
                            <div class="product__discount__slider owl-carousel">
                                <c:forEach items="${requestScope.lstProductSaleOff}" var="p">
                                    <div class="col-lg-4">
                                        <div class="product__discount__item product-card">
                                            <div
                                                class="product__discount__item__pic set-bg product-card__img"
                                                data-setbg="${p.productImg}"
                                                >                     
                                                <div class="product__discount__percent">-20%</div>
                                                <ul class="product__item__pic__hover">
                                                    <li>
                                                        <a href="product-detail?productId=${p.productId}"><i class="fa fa-shopping-cart"></i></a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="product__discount__item__text">
                                                <span>GeekforBooks</span>
                                                <h5>${p.productName}</h5>
                                                <a>${p.authorName}</a> 
                                                <div class="product__item__price">
                                                    <h5>${p.productPrice} $</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="filter__item">
                    <div class="row">
                        <div class="col-lg-4 col-md-5">
                            <div class="filter__sort">
                                <span>Product</span> 
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-3">
                            <div class="filter__option">
                                <span class="icon_grid-2x2"></span>
                                <span class="icon_ul"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <c:forEach items="${requestScope.lstProduct}" var="p">
                        <div  class="col-lg-4 col-md-6 col-sm-6 d-flex flex-wrap align-items-center">
                            <div class="product__item product-card">
                                <div
                                    class="product__item__pic set-bg product-card__img"
                                    data-setbg="${p.productImg}">
                                    <ul class="product__item__pic__hover">
                                        <li>
                                            <a href="product-detail?productId=${p.productId}"><i class="fa fa-shopping-cart"></i></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="#">${p.productName}</a></h6>
                                    <a>${p.authorName}</a> 
                                    <h5>${p.productPrice}$</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <div class="product__pagination">
                    <nav>
                       <ul class="pagination justify-content-center">
    <li class="page-item<c:if test="${requestScope.pageCur eq 1}"> disabled</c:if>">
        <a class="page-link" href="${requestScope.href}page=${requestScope.pageCur - 1}">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
        </a>
    </li>
    
    <c:forEach items="${requestScope.lstPage}" var="p">
        <li class="page-item<c:if test="${p eq requestScope.pageCur}"> active</c:if>">
            <a class="page-link" href="${requestScope.href}page=${p}">${p}</a>
        </li>
    </c:forEach>
    
    <li class="page-item<c:if test="${requestScope.pageCur eq requestScope.totalPage}"> disabled</c:if>">
        <a class="page-link" href="${requestScope.href}page=${requestScope.pageCur + 1}">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
        </a>
    </li>
</ul>

                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

    <!-- Footer Section Begin -->
<%@include file="Component/Footer-infor.jsp" %>
<!-- Footer Section End -->
<style>
    .webbook-heading {
        font-family: Cursive, sans-serif;
        font-size: 36px;
        color: #333;
        text-transform: uppercase;
        text-align: center;
        padding: 10px;
    }
</style>

<!-- Js Plugins -->
<script>
// Get the button
let mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>   
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
