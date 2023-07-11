<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>GeeksforBooks</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Humberger Begin -->
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
        <section class="breadcrumb-section set-bg" >
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

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form action="cart" method="post">
                        <c:if test="${sessionScope.lstCart.size() ne 0}">
                            <div class="shoping__cart__table">
                                <table>
                                    <thead>
                                        <tr>
                                            <th class="shoping__product">Products</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${sessionScope.lstCart}" var="c">
                                        <tbody>
                                            <tr>
                                                <td class="shoping__cart__item">
                                                    <a style="text-decoration: none; color: black; line-height: 1.6;" href="product-detail?productId=${c.productId}">
                                                        <img src="${c.orderDetailProductImg}" alt="">
                                                        <h5>${c.orderDetailProductName}</h5>
                                                    </a>
                                                </td>
                                                <td class="shoping__cart__price">
                                                    ${c.orderDetailPriceProduct}$
                                                </td>
                                                <td>
                                                    <div class="quantity">
                                                        <input name="orderDetailQuantity" type="reset" value="${c.orderDetailQuantity}">
                                                    </div>
                                                </td>

                                            </tr>
                                        </tbody>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <c:if test="${sessionScope.lstCart.size() eq 0}">
                      <h3>Oops! No products found. </h3>
                                            <h3>GO SHOPPING FOR MORE KNOWLEDGE</h3>

                    </c:if>
                </div>
                <c:if test="${sessionScope.lstCart.size() ne 0}">
                    <div class="col-lg-6"  >
                        <div class="shoping__checkout">
                            <h5>Cart Total</h5>
                            <ul>
                                <li>Total <span>${requestScope.totalPrice} $</span></li>
                            </ul>
                            <a href="checkout" class="primary-btn">PROCEED TO CHECKOUT</a>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>//
    </section>
    <!-- Shoping Cart Section End -->

    <!-- Footer Section Begin -->
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