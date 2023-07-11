<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="hero pb-0">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="hero__categories">
                    <div class="hero__categories__all">
                        <i class="fa fa-bars"></i>
                        <span>Genre</span>
                    </div>
                 
                         <ul style="display: none;">
                        <c:forEach  items="${requestScope.lstGenre}" var="g">
                            <li><a  href="shop?genreId=${g.genreId}">${g.genreName}</a></li>
                        </c:forEach> 
                    </ul>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="hero__search">
                    <div class="hero__search__form">
                        <form method="get" action="shop">
                            <input value="${requestScope.searchValue}" name="searchValue" type="text" placeholder="What do yo u need?" />
                            <button type="submit" class="site-btn">SEARCH</button>
                        </form>
                    </div>
                    <div class="hero__search__phone">
                        <div class="hero__search__phone__icon">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="hero__search__phone__text">
                            <h5>+84 82828030703</h5>
                            <span>support 24/7 time</span>
                        </div>
                    </div>
                </div>

                </section>