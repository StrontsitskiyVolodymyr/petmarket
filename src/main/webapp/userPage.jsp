<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container userpaje">
    <div class="right">
        <c:choose>
            <c:when test="${someuser.getImg()!=null}"> <img class="circle userPicLarge z-depth-3"
                                                            src="/getuserimg"></c:when>
            <c:otherwise><img class="pink darken-3" src="img/nophoto.png"></c:otherwise>
        </c:choose>
    </div>
    <ul class="collection with-header z-depth-3">
        <li class="collection-header"><h4><i class="material-icons prefix medium">account_circle</i><span
                class="right">${someuser.getUserName()}
        <c:choose>
            <c:when test="${user.id==someuser.getId()}"><a href="/useredit"><i
                    class="material-icons mycolor">settings</i></a></c:when>
        </c:choose></span>
        </h4></li>
        <li class="collection-item"><i class="material-icons prefix">room</i><span
                class="right">${someuser.getCity()}</span></li>
        <li class="collection-item"><i class="material-icons prefix">phone</i><span
                class="right">${someuser.getPhone()}</span></li>
        <li class="collection-item"><i class="material-icons prefix">email</i><span
                class="right">${someuser.getEmail()}</span></li>

    </ul>
</div>
<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/forallpages.js"></script>
</body>
</html>
