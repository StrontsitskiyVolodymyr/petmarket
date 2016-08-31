<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet Adding</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row ">
        <form class="col s12 petAddingMargin z-depth-3 " method="post" action="/petadding" id="petaddform">
            <div class="col s8 offset-l2 ">
                <div class="center-align input-field txtmargin"><h1 class="mycolor">Add parameters step by step</h1>
                </div>
                <div class="input-field txtmargin ">
                    <input placeholder="Put zero if free" id="priceinput" type="number" min="0" class="validate"
                           name="price">
                    <label for="priceinput">Price in $</label>
                </div>
                <div class="input-field txtmargin" id="divtypeselect">
                    <select id="typeselect" name="typeselect">
                        <option value="" disabled selected>Choose type</option>
                        <option value="notype">Add new type</option>
                        <c:forEach items="${pettypes}" var="item">
                            <option id="sometype" value=${item.getTypeName()}>${item.getTypeName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-field txtmargin" id="addtype">
                    <input type="text" class="validate type" name="newtype">
                    <label for="addtype">New type</label>
                </div>
                <div class="input-field txtmargin" id="species">
                    <select name="speciesa" id="speciesselect">
                        <option value="" disabled selected>Choose species</option>
                        <option value="nospecies">Add new species</option>
                    </select>
                </div>
                <div class="input-field txtmargin" id="addspecies">
                    <input type="text" class="validate" name="newspecies">
                    <label for="addspecies">New species</label>
                </div>
                <div class="input-field txtmargin" id="sex">
                    <select name="sex">
                        <option value="" disabled selected>Choose sex</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>
                <div class="input-field txtmargin" id="description">
                    <textarea class="materialize-textarea" length="255" name="description" id="descriptioninput" minlength="5"></textarea>
                    <label for="description">Add description</label>
                </div>
            </div>
        </form>
        <div class="center-align btninbotom" id="btnadd">
            <button id="subpetadd" class="btn waves-light pink darken-3 z-depth-3">Add pet</button>
        </div>
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

