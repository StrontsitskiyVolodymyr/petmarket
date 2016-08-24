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
<div class="container">
        <div class="row">
        <form class="col s12" method="post" action="/registration">
            <div class="center-align">
                <img class="input-field pink darken-3" src="img/check_users_group-512.png"></div>
            <div class="row">
                <div class="input-field col s6">
                    <i class="material-icons prefix">account_circle</i>
                    <input id="icon_acount" type="text" class="validate" name="user">
                    <label for="icon_acount">Full Name</label>
                </div>
                <div class="input-field col s6">
                    <i class="material-icons prefix">email</i>
                    <input id="icon_email" type="email" class="validate" name="email">
                    <label for="icon_email">Email</label>
                </div>
                <div class="input-field col s6">
                    <i class="material-icons prefix">vpn_key</i>
                    <input id="icon_key" type="password" class="validate">
                    <label for="icon_key">Password</label>
                </div>
                <div class="input-field col s6">
                    <i class="material-icons prefix">vpn_key</i>
                    <input id="icon_key2" type="password" class="validate" name="password">
                    <label for="icon_key2">Repeat password</label>
                </div>
                <div class="input-field col s6">
                    <i class="material-icons prefix">phone</i>
                    <input id="icon_pone" type="tel" class="validate" name="phone">
                    <label for="icon_pone">Phone</label>
                </div>
                <div class="input-field col s6">
                    <i class="material-icons prefix">room</i>
                    <input id="icon_city" type="text" class="validate" name="city">
                    <label for="icon_city">City</label>
                </div>
                <form>
                    <p>
                        <input type="checkbox" id="test5"/>
                        <label for="test5">I have read and agree to all the license terms</label>
                    </p>
                </form>
                <div class="center-align">
                    <button  class="btn waves-effect waves-light  pink darken-3 " type="submit" >Create new account</button>
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
