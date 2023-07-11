<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <meta charset="UTF-8" />
        <meta name="description" content="Ogani Template" />
        <meta name="keywords" content="Ogani, unica, creative, html" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>GeekforBooks</title>

        <!-- Google Font -->
        <link
            href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
            rel="stylesheet"
            />

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css" />
        <link rel="stylesheet" href="css/nice-select.css" type="text/css" />
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css" />
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css" />
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css" />
        <link rel="stylesheet" href="css/style.css?v=6" type="text/css" />
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Humberger Begin -->
        <%@include file="Component/header-authen.jsp" %>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
        <%@include file="Component/header-infor.jsp" %>
        <!-- Header Section End -->

        <!-- Hero Section Begin -->
       <%@include file="Component/hero-section.jsp" %>
        <!-- Featured Section Begin -->
        <section class="featured spad pt-0">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Featured Product</h2>
                        </div>
                    </div>
                </div>
                <div class="row featured__filter">

                    <!-- for each in here  -->
                    <c:forEach items="${requestScope.lstProductFeatured}" var="p">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                            <div class="featured__item product-card">
                                <div class="featured__item__pic set-bg product-card__img" data-setbg="${p.productImg}">
                                    <ul class="featured__item__pic__hover">
                                        <li>
                                            <a href="product-detail?productId=${p.productId}"><i class="fa fa-shopping-cart"></i></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="#">${p.productName}</a></h6>
                                    <a>${p.authorName}</a> 
                                    <h5>${p.productPrice} $</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- end foreach -->

                </div>
            </div>
        </section>
         <%@include file="Component/Footer-infor.jsp" %>
        <!-- Footer Section End -->

        <!-- Js Plugins -->
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
