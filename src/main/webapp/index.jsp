<jsp:include page="header.jsp"></jsp:include>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<div class="body">
    <div class="content">
        <div class="slider">
            <ul class="slides">
                <li>
                    <img src=img/slide1.jpg>
                    <div class="caption center-align">
                        <h3> Sometime they funny...</h3>
                    </div>
                </li>
                <li>
                    <img src=img/slide3.jpg>
                    <div class="caption right-align">
                        <h3>Sometime fascinating...</h3>
                    </div>
                </li>
                <li>
                    <img src="img/slide6.jpg">
                    <div class="caption left-align">
                        <h3>And always faithful...</h3>
                    </div>
                </li>
            </ul>
        </div>
        <div class="row center-align">
            <div class="container indexcontent ">
                <div class="col s4 center-align ">
                    <a href="/petsearch"><i class="material-icons large mycolor">search</i></a>
                    <h3>Searching pet</h3>
                    <h5>Here you can find the pet by type, prise, city or species</h5>
                </div>
                <div class="col s4 center-align">
                    <a href="/petadding"><i class="material-icons large mycolor">queue</i></a>
                    <h3>Adding pet</h3>
                    <h5>Here you can sell or give free your pet</h5>
                </div>
                <div class="col s4 center-align">
                    <a href=""><i class="mycolor material-icons large">forum</i></a>
                    <h3>Owners forum</h3>
                    <h5>Here you can participate in discussions or create your own</h5>
                </div>
            </div>
        </div>

    </div>
    <jsp:include page="futer.jsp"></jsp:include>
    <!--Scripts-->
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
    <script type="text/javascript" src="js/forallpages.js"></script>
    <script>
        $(document).ready(function () {
            $('.slider').slider({full_width: true, height: 600});
        });
    </script>
</div>
</html>
