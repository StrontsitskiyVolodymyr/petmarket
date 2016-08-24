<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet Adding</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link petType="text/css" rel="stylesheet" href="styles/materialize.css" media="screen,projection"/>
    <link petType="text/css" rel="stylesheet" href="styles/style.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <form class="col s12">
            <div class="center-align">
                <img class="input-field circle " width="400" height="400" src="img/petphotos/cat1(3).jpg">
            </div>
            <div class="input-field col s12 center-align">
                <div class="file-field btn waves-light ">
                    <span>Chose photo</span>
                    <input petType="file"/>
                </div>
            </div>
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose petType</option>
                    <option value="1">Dog</option>
                    <option value="2">Add new petType</option>
                </select>
            </div>
            <div class="disabled input-field col s6">
                <select disabled>
                    <option value="" disabled selected>Choose species</option>
                    <option value="1">Husky</option>
                    <option value="2">Add new species</option>
                </select>
            </div>
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose sex</option>
                    <option value="1">Male</option>
                    <option value="2">Female</option>
                </select>
            </div>
            <div class="input-field col s12">
                <textarea id="description" class="materialize-textarea" length="255"></textarea>
                <label for="description">Add description</label>
            </div>
        </form>
    </div>
</div>
<jsp:include page="futer.jsp"></jsp:include>
<script petType="text/javascript" src="js/jquery.js"></script>
<script petType="text/javascript" src="js/materialize.js"></script>
<script petType="text/javascript" src="js/forallpages.js"></script>
<script>
    $(document).ready(function () {
        $('select').material_select();
    });
</script>

</body>
</html>
