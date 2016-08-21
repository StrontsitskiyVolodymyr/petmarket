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
<div class="left">
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

<div>
    <div class="small card sticky-action ">
        <div class="card-image waves-effect waves-block waves-light">
            <img class="activator" src="img/slide3.jpg">
        </div>
        <div class="card-content">
            <span class="card-title activator grey-text text-darken-4">Card Title<i class="material-icons right">more_vert</i></span>
            <p><a href="#">This is a link</a></p>
        </div>
        <div class="card-reveal">
            <span class="card-title grey-text text-darken-4">Card Title<i class="material-icons right">close</i></span>
            <p>Here is some more information about this product that is only revealed once clicked on.</p>
        </div>
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
