<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>GeeksforBooks </title>

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

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">

            <div class="checkout__form">
                <h4>Billing Details</h4>
                <form action="checkout" method ="post">


                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <c:forEach items="${requestScope.lstAccountContact}" var="ac">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input" ">
                                            Name<span></span>
                                            <input style="color: black" disabled="" type="text" value="${ac.accountContactName}">
                                        </div>
                                    </div>
                                </div>

                                <div class="checkout__input">
                                    Address<span></span>
                                    <input style="color: black" disabled="" type="text" value="${ac.accountContactAddress}">
                                </div> 
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            Phone<span></span>
                                            <input style="color: black" disabled="" type="text"   value="${ac.accountContactMobile}">
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>      
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="checkout__order">
                                <h4>Your Order</h4>
                                <div class="checkout__order__products">Products <span>Total</span></div>
                                <c:forEach items="${sessionScope.lstCart}" var="c">
                                    <ul>
                                        <li>${c.orderDetailProductName}<span>${c.orderDetailPriceProduct}$</span></li>
                                    </ul>
                                </c:forEach>
                                <div class="checkout__order__total">Total <span>${requestScope.totalPrice}$</span></div>
                                <a href="sign-up"> <div class="checkout__input__checkbox">
                                        <label for="acc-or">
                                            Create an account? (click) 

                                        </label>
                                    </div>
                                </a>
                                <div id="my_form">       
                                    <button id="nextStep" type="submit" class="site-btn">PLACE ORDER</button>
                                </div>
                                <div id="thank_you" style="display: none;">
                                    <p class="cool-message">Thanks for placing your order!</p>
                                    <a href ="home">Close</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->
    <style>
        .cool-message {
            font-size: 24px;
            color: #3366ff;
            text-align: center;
            padding: 10px;
            background-color: #f7f7f7;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
    </style>
    <!-- Footer Section Begin -->
    <%@include file="Component/Footer-infor.jsp" %>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script>
        var nextStep = document.querySelector('#nextStep');

        nextStep.addEventListener('click', function (e) {
            e.preventDefault();
            // Hide first view
            document.getElementById('my_form').style.display = 'none';

            // Show thank you message element
            document.getElementById('thank_you').style.display = 'block';
        });
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