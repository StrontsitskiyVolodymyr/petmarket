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
    <div class="row">
        <form class="col s12 petAddingMargin" method="post" action="/petadding">
            <div class="col s6 offset-l3">
                <div class="center-align input-field txtmargin"><h1>Pet adding</h1></div>
                <div class="input-field txtmargin">
                    <input placeholder="Leave empty if free" id="price" type="number" min="1" class="validate" name="price">
                    <label for="price">Price in $</label>
                </div>
                <div class="input-field txtmargin ">
                    <select name="type">
                        <option value="" disabled selected>Choose type</option>
                        <option value="notype">Add new type</option>
                        <c:forEach items="${pettypes}" var="item">
                            <option value=${item}>${item}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-field txtmargin">
                    <input id="addtype" type="text" class="validate" name="newtype">
                    <label for="addtype">New type</label>
                </div>
                <div class="input-field txtmargin">
                    <select nama="species">
                        <option value="" disabled selected>Choose species</option>
                        <option value="nospesies">Add new species</option>
                        <c:forEach items="${pettypes}" var="item">
                            <option value=${item}>${item}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-field txtmargin">
                    <input id="addspecies" type="text" class="validate" name="newspecies">
                    <label for="addspecies">New species</label>
                </div>
                <div class="input-field txtmargin">
                    <select name="sex">
                        <option value="" disabled selected>Choose sex</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>
                <div class="input-field txtmargin">
                    <textarea id="description" class="materialize-textarea" length="255" name="description"></textarea>
                    <label for="description">Add description</label>
                </div>
                <div class="center-align">
                    <button type="submit" class="btn waves-light">Add pet</button>
                </div>
            </div>
        </form>
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

