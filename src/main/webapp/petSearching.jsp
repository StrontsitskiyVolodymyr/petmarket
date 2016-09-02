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
<div class="container ">
    <div class="row rowspace">
        <div class="col s12">
            <div class="row">
                <div class="input-field col s12">
                    <form action="/petsearch">
                        <i class="material-icons prefix">search</i>
                        <input type="text" id="autocomplete-input"  name="param">
                        <label for="autocomplete-input">Write here what are you looking for</label>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row rowspace">
        <c:choose>
            <c:when test="${pets.size()==0}"><img class="imgnr z-depth-3" src="img/noresult2.png"></c:when>
            <c:otherwise>
                <c:forEach items="${pets}" var="item">
                <div class="col s4">
                    <div class="medium card sticky-action z-depth-3">
                        <div class="card-image waves-effect waves-block waves-light">
                            <c:choose>
                                <c:when test="${item.getImg()!=null}"><img class="activator"
                                                                           src="/getimg?kind=p&petid=${item.getId()}"></c:when>
                                <c:otherwise><img class="activator pink darken-3 "
                                                  src="img/nopetphoto.png"/></c:otherwise>
                            </c:choose>
                        </div>
                        <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4">
                    <c:choose>
                        <c:when test="${item.price==0}">
                            <span class="green-text">Free</span>
                        </c:when>
                        <c:otherwise>
                            ${item.price}$
                        </c:otherwise>
                    </c:choose>
                        <i class="material-icons right">more_vert</i></span>
                        </div>
                        <div class="card-reveal">
                <span class="card-title grey-text text-darken-4">${item.getPetType().getTypeName()}<i
                        class="material-icons right">close</i></span>
                            <p>Species: <span class="mycolor">${item.getSpecies().getSpeciesName()}</span></p>
                            <p>Sex: <span class="mycolor">${item.getSex()}</span></p>
                            <p>${item.getDescription()}</p>
                        </div>
                        <div class="card-action right-align">
                            <a href="/pet?pet=${item.getId()}">Go on page</a>
                        </div>
                    </div>
                </div>
            </c:forEach></c:otherwise>
        </c:choose>

    </div>
</div>

<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/forallpages.js"></script>
<script>
    $(document).ready(function () {
        $('select').material_select();
    });
 </script>
</body>
</html>
