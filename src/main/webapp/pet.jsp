<jsp:include page="header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet page</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="content petmargin">
    <div class="container ">
        <div class="row">
            <div class="col s4">
                <div class="">
                    <img src="img/petphotos/pet.jpg" class="materialboxed forsize  z-depth-3">
                </div>
            </div>
            <div class="col s8">
                <div class="">
                    <ul class="collapsible popout" data-collapsible="accordion">
                        <li>
                            <div class="collapsible-header active"><i class="material-icons mycolor">live_help</i>Pet
                            </div>
                            <div class="collapsible-body">
                                <div class="row center-align">
                                    <div class="col s4"><p>Type: <span
                                            class="mycolor">${pet.getPetType().getTypeName()}</span></p></div>
                                    <div class="col s4"><p>Speciec:<span
                                            class="mycolor">${pet.getSpecies().getSpeciesName()}</span></p>
                                    </div>
                                    <div class=" col s4"><p>Sex: <span class="mycolor">${pet.sex}</span></p></div>
                                </div>
                            </div>
                            <div class="collapsible-body"><p>${pet.description}</p></div>
                        </li>
                        <li>
                            <div class="collapsible-header"><i class="material-icons mycolor">person_pin</i>Owner</div>
                            <div class="collapsible-body">
                                <div class="row ">
                                    <div class="col s10 offset-l1"><img class="circle userPic left" src="/getuserimg"><a
                                            href="/userpage?user=${pet.getOwner().getId()}">
                                        <div class="petowner">${pet.getOwner().getUserName()}</div>
                                    </a>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
        <div class="center-align">
            <a class="btn tooltipped z-depth-3 pink darken-3" data-position="top" data-delay="50"
               data-tooltip="${pet.price}$"
               onclick="Materialize.toast('Pet added in basket', 4000)">Buy</a>
        </div>


    </div>
</div>


<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/forallpages.js"></script>
<script>
    $(document).ready(function () {
        $('.materialboxed').materialbox();
        $('.collapsible').collapsible({
            accordion: false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
        })
    });

</script>
</body>
</html>
