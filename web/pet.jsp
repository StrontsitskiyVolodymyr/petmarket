<jsp:include page="header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div></div>
<div>
    <div class="carousel">
        <a class="carousel-item" href="#one!"><img src="http://lorempixel.com/250/250/nature/1"></a>
        <a class="carousel-item" href="#two!"><img src="http://lorempixel.com/250/250/nature/2"></a>
        <a class="carousel-item" href="#three!"><img src="http://lorempixel.com/250/250/nature/3"></a>
        <a class="carousel-item" href="#four!"><img src="http://lorempixel.com/250/250/nature/4"></a>
        <a class="carousel-item" href="#five!"><img src="http://lorempixel.com/250/250/nature/5"></a>
    </div>
    <ul class="collapsible popout" data-collapsible="accordion">
        <li>
            <div class="collapsible-header"><i class="material-icons">filter_drama</i>First</div>
            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
        </li>
        <li>
            <div class="collapsible-header"><i class="material-icons">place</i>Second</div>
            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
        </li>
        <li>
            <div class="collapsible-header"><i class="material-icons">whatshot</i>Third</div>
            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
        </li>
    </ul>
</div>
<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script>
    $(document).ready(function () {
        $('.carousel').carousel();
    });
    $(document).ready(function () {
        $('.collapsible').collapsible({
            accordion: false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
        });
    });


</script>
</body>
</html>
