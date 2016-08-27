<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet searching</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div>
    <h4>Filters</h4>
    <h5>Price</h5>
    <form action="#">
        <p class="range-field">
            <input type="range" id="test5" min="0" max="100"/>
        </p>
    </form>
    <h5>Type</h5>
    <div class="input-field col s12">
        <select>
            <option value="" disabled selected>Choose type</option>
            <option value="1">Option 1</option>
            <option value="2">Option 2</option>
            <option value="3">Option 3</option>
        </select>
    </div>
    <h5>Species</h5>
    <div class="input-field col s12">
        <select>
            <option value="" disabled selected>Choose species</option>
            <option value="1">Option 1</option>
            <option value="2">Option 2</option>
            <option value="3">Option 3</option>
        </select>
    </div>
</div>
<div class="container ">
    <div class="row">
        <c:forEach items="${pets}" var="item">
            <div class="col s4">
                <div class="small card sticky-action z-depth-3 ">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img class="activator" src="img/slide3.jpg">
                    </div>
                    <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">${item.getPetType().getTypeName()}<i
                            class="material-icons right">more_vert</i></span>
                        <p><a href="/pet?pet=${item.getID()}">Look closer</a></p>
                    </div>
                    <div class="card-reveal">
                <span class="card-title grey-text text-darken-4">${item.getPetType().getTypeName()}<i
                        class="material-icons right">close</i></span>
                        <p>Species: <span class="mycolor">${item.getSpecies().getSpeciesName()}</span></p>
                        <p>Sex: <span class="mycolor">${item.getSex()}</span></p>
                        <p>${item.getDescription()}</p>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="center-align">
        <ul class="pagination">
            <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
            <li class="active mycolor"><a href="">1</a></li>
            <c:forEach items="pages" var="item">
                <li class="waves-effect"><a href="/petsearch?paje=${item.page}">${item.page}</a></li>
            </c:forEach>

            <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
        </ul>
    </div>

</div>
<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/forallpages.js"></script>
<script>$(document).ready(function () {
    $('select').material_select();
});
</script>
</body>
</html>
