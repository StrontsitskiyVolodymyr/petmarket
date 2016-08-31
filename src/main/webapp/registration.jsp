<jsp:include page="header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container z-depth-3">
    <div class="row ">
        <form class="col s10 offset-l1" method="post" action="/registration" id="registrationform">
            <div class="center-align txtmarginregistration">
                <img class="input-field pink darken-3" src="img/check_users_group-512.png"></div>
            <div class="row">
                <div class="input-field col s5 txtmarginregistration">
                    <i class="material-icons prefix">account_circle</i>
                    <input id="icon_acount" type="text"  name="user">
                    <label for="icon_acount">Full Name</label>
                </div>
                <div class="input-field col s5 offset-l1 txtmarginregistration">
                    <i class="material-icons prefix">email</i>
                    <input id="icon_email" type="email"  name="email">
                    <label for="icon_email">Email</label>
                </div>
                <div class="input-field col s5 txtmarginregistration">
                    <i class="material-icons prefix">vpn_key</i>
                    <input id="icon_key1" type="password" name="password">
                    <label for="icon_key1">Password</label>
                </div>
                <div class="input-field col s5 offset-l1 txtmarginregistration">
                    <i class="material-icons prefix">vpn_key</i>
                    <input id="icon_key2" type="password"  name="password2">
                    <label for="icon_key2">Repeat password</label>
                </div>
                <div class="input-field col s5 txtmarginregistration">
                    <i class="material-icons prefix">phone</i>
                    <input id="icon_pone" type="tel" class="validate" name="phone">
                    <label for="icon_pone">Phone</label>
                </div>
                <div class="input-field col s5 offset-l1 txtmarginregistration">
                    <i class="material-icons prefix">room</i>
                    <input id="icon_city" type="text"  name="city">
                    <label for="icon_city">City</label>
                </div>
                <div class="center-align  txtmarginregistration">
                    <input type="checkbox" id="agree"/>
                    <label for="agree">I have read and agree to all the license terms</label>
                </div>
                <div class="center-align">
                    <button class="btn waves-effect waves-light  pink darken-3 z-depth-3" id="subButton">Create new
                        account
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/forallpages.js"></script>
</body>
</html>
