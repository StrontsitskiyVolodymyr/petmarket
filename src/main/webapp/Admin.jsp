<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="row container admin">
    <div class="col s12">
        <ul class="tabs">
            <li class="tab col s4"><a class="active" href="#users">Users</a></li>
            <li class="tab col s4"><a href="#types">Types</a></li>
            <li class="tab col s4"><a href="#species">Species</a></li>
        </ul>
    </div>
    <div id="users" class="col s12">
        <div class="collection">
            <a class="collection-item center-align red-text">Go on page to delete</a>
            <c:forEach items="${users}" var="user">
                <a href="/userpage?user=${user.getId()}" class="collection-item">${user.getUserName()}</a>
            </c:forEach>
        </div>
    </div>
    <div id="types" class="col s12">
        <div class="collection">
            <a class="collection-item red-text center-align">Remember you can't delete type while at least one species
                or pet link to him</a>
            <c:forEach items="${types}" var="type">
                <a href="/delete?type=${type.getId()}" class="collection-item">${type.getTypeName()}<span
                        class="new badge red " data-badge-caption=" Click on row to delete"></span></a>
            </c:forEach>
        </div>
    </div>
    <div id="species" class="col s12">
        <div class="collection">
            <a class="collection-item red-text center-align">Remember you can't delete species while at least one pet
                link to him</a>
            <c:forEach items="${species}" var="spesies">
                <a href="/delete?species=${spesies.getId()}" class="collection-item"><span
                        class="red-text"> ${spesies.getParentType().getTypeName()} - - - </span>${spesies.getSpeciesName()}<span
                        class="new badge red " data-badge-caption=" Click on row to delete"></span></a>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/forallpages.js"></script>
<script>
    $(document).ready(function () {
        $('ul.tabs').tabs();
    });
</script>
</body>
</html>
