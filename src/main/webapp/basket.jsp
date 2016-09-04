<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="admin">
<c:forEach items="${orders}" var="order"><c:choose><c:when test="${order.getStatus()!='done'}">
    <div class="row container z-depth-3 adminorder">
        <div class="col s12 ">
            <div class="card marginBetweenOrder z-depth-3 ">
                <div class="card-content ">
                    <div class="fixed-action-btn right horizontal" style="position:absolute;bottom: 90%; right: 24px;">
                        <a class="btn-floating btn-large pink darken-3 ">
                            <i class="large material-icons">settings</i>
                        </a>
                        <ul>
                            <li><a  href="/deleteorder?id=${order.getId()}" class="btn-floating red"><i class="material-icons">delete</i></a></li>
                            <li><a class="btn-floating modal-trigger green mod"
                                   href="#confirmModal${order.getTargetPet().getId()}"><i class="material-icons">credit_card</i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-title left-align"><a href="/pet?pet=${order.getTargetPet().getId()}"><img
                            class=" circle petPic z-depth-3"
                            src="/getimg?kind=p&petid=${order.getTargetPet().getId()}"></a>
                        <span id="priceInOrder" class="mycolor ">    ${order.getTargetPet().getPrice()}$</span>
                    </div>
                </div>
                <div class="card-action row center-align">
                    <div class="col s4">Type:<span
                            class="mycolor"> ${order.getTargetPet().getPetType().getTypeName()}</span></div>
                    <div class="col s4">Species:<span
                            class="mycolor">${order.getTargetPet().getSpecies().getSpeciesName()}</span></div><span
                        class="col s4">
                        Male:<span class="mycolor">${order.getTargetPet().getSex()}</span></span>
                </div>
            </div>
        </div>
    </div>
    <div id="confirmModal${order.getTargetPet().getId()}" class="confirmmodal modal">
        <div class="modal-content">
            <div class="row">
                <div class="center-align"><h1>Payment for ${order.getTargetPet().getPrice()}$</h1></div>

                <form class="col s12" action="/orderinfo" method="get" id="confirmform">
                    <div class="row">
                        <div class="hide input-field col s12">
                            <i class="material-icons prefix">info_outline</i>
                            <input  name="orderid" value="${order.getId()}" id="order" type="text">
                            <label for="order">Order</label>
                        </div>
                        <div class="input-field col s12">
                            <i class="material-icons prefix">room</i>
                            <input name="address" id="place" type="text">
                            <label for="place">Delivery place</label>
                        </div>
                        <div class="input-field col s12">
                            <i class="material-icons prefix">vpn_key</i>
                            <input type="date" class="datepicker" id="date" name="date">
                            <label for="date">Delivery time</label>
                        </div>
                    </div>
                    <div class="center-align">
                        <button class="btn waves-effect waves-light  pink darken-3 z-depth-3"
                                type="submit">Make payment
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</c:when></c:choose>
</c:forEach></div>
<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/forallpages.js"></script>
<script>
    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 10
    });
</script>
</body>
</html>

