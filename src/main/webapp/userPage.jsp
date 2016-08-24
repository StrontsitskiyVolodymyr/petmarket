<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link petType="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link petType="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container userpaje">
    <div class="right">
   <!--<a href="/useredit"><img class="pink darken-3" src="img/check_users_group-512%20-%20Copy.png"></a>-->
        <img class="circle userPicLarge" src="/img/userphotos/user.jpg">
</div>
       <ul class="collection with-header">
        <li class="collection-header"><h4><i class="material-icons prefix medium">account_circle</i><span class="right">${user.user}<a href="/useredit"><i class="material-icons mycolor">settings</i></a></span></h4></li>
        <li class="collection-item"><i class="material-icons prefix">room</i><span class="right">${user.city}</span></li>
        <li class="collection-item"><i class="material-icons prefix">phone</i><span class="right">${user.phone}</span></li>
        <li class="collection-item"><i class="material-icons prefix">email</i><span class="right">${user.email}</span></li>

    </ul>
</div>
<jsp:include page="futer.jsp"></jsp:include>
<script petType="text/javascript" src="js/jquery.js"></script>
<script petType="text/javascript" src="js/materialize.js"></script>
<script petType="text/javascript" src="js/forallpages.js"></script>
</body>
</html>
