<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="image-upload">
                    <c:choose>
                        <c:when test="${pet.getImg()!=null}"><img class="materialboxed forsize  z-depth-3"
                                                                  src="/getimg?kind=p&petid=${pet.getId()}"></c:when>
                        <c:otherwise><img class="pink darken-3 circle"
                                          src="img/nopetphoto.png"/></c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="col s8">
                <div class="">
                    <ul class="collapsible popout" data-collapsible="accordion">
                        <li>
                            <div class="collapsible-header active"><i class="material-icons mycolor">live_help</i>Price:
                                <c:choose><c:when test="${pet.price==0}"><span
                                        class="green-text">Free</span></c:when><c:otherwise><span>${pet.price}$</span></c:otherwise></c:choose>
                           <c:choose><c:when test="${user.getUserRole()=='admin'}"><span class="right"><a  href="/deletepet?petid=${pet.id}" class="btn waves-effect pink darken-3 z-depth-3">Delete</a></span></c:when></c:choose> </div>
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
                            <div class="collapsible-header"><i
                                    class="material-icons mycolor">person_pin</i>Owner<c:choose><c:when
                                    test="${user.id==pet.getOwner().getId()}"> settings</c:when></c:choose></div>
                            <div class="collapsible-body">
                                <div class="row ">
                                    <div class="col s10 offset-l1">
                                        <c:choose>
                                            <c:when test="${user.id!=pet.getOwner().getId()}"><img class="circle userPic left"
                                                                 src="/getimg?kind=u&userid=${pet.getOwner().getId()}"><a
                                                    href="/userpage?user=${pet.getOwner().getId()}">
                                                <div class="petowner">${pet.getOwner().getUserName()}</div>
                                            </a></c:when>
                                            <c:otherwise>
                                                <div class="center-align btbspace">
                                                    <c:choose>
                                                        <c:when test="${pet.getOwner().getId()==user.id}">
                                                            <div class=" hide">
                                                                <form action="/uploadphoto?petid=${pet.getId()}" method="post" enctype="multipart/form-data"
                                                                      id="uploadphotopet">
                                                                    <div class="file-field input-field">
                                                                        <div class=" btn waves-effect light z-depth-3 pink darken-3">
                                                                            <input id="btnaddpetphoto" type="file" onchange=$("#uploadphotopet").submit()
                                                                                   name="petphoto">
                                                                        </div>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                            <label for="btnaddpetphoto" class="btn z-depth-3 pink darken-3 waves-effect">Upload new photo</label>
                                                            <a href="/deletepet?petid=${pet.id}" class="btn pink darken-3 z-depth-3 waves-effect">Delete pet</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a class="btn tooltipped z-depth-3 pink darken-3" data-position="top" data-delay="50"
                                                               data-tooltip="${pet.price}$"
                                                               onclick="Materialize.toast('Pet added in basket', 4000)">Add in basket</a>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
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
