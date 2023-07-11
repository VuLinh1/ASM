<div class="humberger__menu__overlay"></div>
<div class="humberger__menu__wrapper">
    <div class="humberger__menu__logo">
        <a href="#"><img src="img/logo.png" alt="" /></a>
    </div>
    <div class="humberger__menu__cart">
        <ul>
            <li>
                <a href="cart"><i class="fa fa-shopping-bag"></i> <span>${sessionScope.lstCart.size()}</span></a>
            </li>
        </ul>

    </div>
    <div class="humberger__menu__widget">
        <div class="header__top__right__auth">
            <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
        </div>
    </div>
    <nav class="humberger__menu__nav mobile-menu">
        <ul>
            <li active><a href="home">Home</a></li>
            <li  ><a href="shop">Shop</a></li>
            <li>
                <a href="#">Pages</a>
                <ul class="header__menu__dropdown">
                    <li><a href="./cart">Shoping Cart</a></li>
                    <li><a href="./checkout">Check Out</a></li>
                </ul>
            </li>

            <li><a href="./profile">Profile</a></li>
        </ul>
    </nav>
    <div id="mobile-menu-wrap"></div>

</div>