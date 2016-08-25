<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit profile</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link type="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container userpajeedit">
    <div class="right center-align">
        <div class="image-upload">
            <label for="file-input">
                <!--    <img class="pink darken-3" src="img/addphoto.png"/>-->
                <img class="circle userPicLarge" src="/img/userphotos/user.jpg">
            </label>
            <form id="uploadphoto" method="post" action="/uploaduserphoto"   enctype="multipart/form-data">
                <input class="hide" id="file-input" type="file" onchange=$("#uploadphoto").submit() name="photo"/>
            </form>
        </div>
        <div class="btnEditAccountPadding">
            <button class="btnEditAccount btn waves-effect waves-light  pink darken-3 "
                    onclick=$("#userEditSubmit").submit()>Save changes
            </button>
        </div>
        <div class="btnEditAccountPadding">
            <button data-target="modalChangePassword"
                    class="btnEditAccount btn waves-effect waves-light  pink darken-3 modal-trigger">Change password
            </button>
        </div>
        <div class="btnEditAccountPadding">
            <button data-target="modalDeleteAccount"
                    class="btnEditAccount btn waves-effect waves-light  pink darken-3 modal-trigger">Delete account
            </button>
        </div>

    </div>
    <form action="/useredit" method="post" id="userEditSubmit">
        <ul class="collection with-header center-align">
            <li class="collection-item"><h4><label for="full_name"><i class="material-icons prefix medium">account_circle</i></label><input
                    name="userName"
                    value="${user.userName}" id="full_name" type="text" class="validate">
            </h4>
            </li>
            <li class="collection-item"><label for="city"><i class="material-icons prefix">room</i></label><input
                    name="city"
                    value="${user.city}" id="city"
                    type="text" class="validate">
            </li>
            <li class="collection-item"><label for="phone"><i class="material-icons prefix">phone</i></label><input
                    name="phone"
                    value="${user.phone}" id="phone"
                    type="tel" class="validate">
            </li>
        </ul>
    </form>
</div>
<jsp:include page="futer.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/forallpages.js"></script>
<script>
    $(document).ready(function () {
        Materialize.updateTextFields();
    });
</script>
</body
        <!-- Modal Structure ChangePassword -->
<div id="modalChangePassword" class="modal">
    <div class="modal-content">
        <div class="row">
            <form class="col s12">
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">vpn_key</i>
                        <input id="icon_key1" type="password" class="validate">
                        <label for="icon_key1">Old password</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">vpn_key</i>
                        <input id="icon_key2" type="password" class="validate">
                        <label for="icon_key2">New password</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">vpn_key</i>
                        <input id="icon_key3" type="password" class="validate">
                        <label for="icon_key3">Repeat new password</label>
                    </div>
                </div>
                <div class="center-align">
                    <button class="btn waves-effect waves-light  pink darken-3" type="submit" name="action">Change
                        Password
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Modal Structure DeleteAccount -->
<div id="modalDeleteAccount" class="modal">
    <div class="modal-content">
        <div class="row center-align">
            <h4>Are you sure?</h4>
            <h5>All your data wil be deleted and this can't be canceled! </h5>
        </div>
        <div class="center-align">
            <a href="/deleteuser" class="btn waves-effect waves-light  pink darken-3">Delete account
            </a>
        </div>
    </div>
</div>
</html>
