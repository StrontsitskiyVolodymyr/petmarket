<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <div class="nav-wrapper   pink darken-3">
        <a href="/" class="brand-logo"><img src="/img/logo.png"></a>
        <ul class="right hide-on-med-and-down">
            <li>
                <nav> <!--searche-->
                    <div class="nav-wrapper">
                        <form action="/petsearch" id="searchform">
                            <div class="input-field pink darken-3">
                                <input id="searchinput" type="search" required name="param">
                                <label for="searchinput"><i class="material-icons">search</i></label>
                                <i class="material-icons">close</i>
                            </div>
                        </form>
                    </div>
                </nav>
            </li>
            <li>
                <c:choose>
                    <c:when test="${user!=null}"> <!--Side nav btn -->
                        <a href="#" data-activates="slide-out"
                           class="waves-effect waves-light button-collapse show-on-large">
                            <c:choose>
                                <c:when test="${user.img!=null}"><img class="circle right userPic"
                                                                      src=/getimg?kind=u&userid=${user.id}></c:when>
                                <c:otherwise><i class="material-icons right">person_pin</i></c:otherwise>
                            </c:choose>
                                ${user.userName}</a>
                    </c:when>
                    <c:otherwise>
                        <a class="  modal-trigger " href="#logInModal"><i class="material-icons right">person_pin</i>Log
                            <!--btn for modal-->
                            in</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
</nav>
<!-- Modal log in structure -->
<div id="logInModal" class="modal">
    <div class="modal-content">
        <div class="row">
            <form class="col s12" action="/index" method="post" id="loginform">
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">account_circle</i>
                        <input name="email" id="login" type="email">
                        <label for="login">Email</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">vpn_key</i>
                        <input id="passwordlogin" type="password" name="password">
                        <label for="passwordlogin">Password</label>
                    </div>
                </div>
            </form>
            <div class="center-align">
                <button id="loginbtn" class="btn waves-effect waves-light  pink darken-3 z-depth-3" name="action">
                    Sign in
                </button>
                <a class="btn waves-effect waves-light  pink darken-3 z-depth-3"
                   href="/registration">Registration</a></div>
        </div>
    </div>
</div>
<!--side nav!-->
<ul id="slide-out" class="side-nav">
    <li>
        <div class="userView">
            <img class="background  " src="img/side-nav-bac.jpg">
            <a href="/userpage?user=${user.id}">
                <c:choose>
                    <c:when test="${user.img!=null}"><img class="circle userPic"
                                                          src="/getimg?kind=u&userid=${user.id}"></c:when>
                </c:choose>
            </a>
            <a href="/userpage?user=${user.id}"><span class="white-text name">${user.userName}</span></a>
            <a href="/userpage?user=${user.id}"><span class="white-text email">${user.email}</span></a>
        </div>
    </li>
    <c:choose>
        <c:when test="${user.userRole=='admin'}">
            <li><a class="waves-effect" href="/adminpage"><i class="material-icons ">settings</i>Admin page</a></li>
            <li>
                <div class="divider"></div>
            </li>
        </c:when>
    </c:choose>
    <li><a class="waves-effect" href="/petsearch"><i class="material-icons ">search</i>Search for a pet</a></li>
    <li><a class="waves-effect" href="/petadding"><i class="material-icons ">queue</i>Add pet</a></li>
    <li><a class="waves-effect" href="/petsearch?userid=${user.id}"><i class="material-icons">done_all</i>Added pets</a>
    </li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a href="/useredit" class="waves-effect"><i class="material-icons ">settings</i>Settings</a></li>
    <li><a href="/logout" class="waves-effect"><i class="material-icons ">input</i>Log out</a></li>
</ul>
