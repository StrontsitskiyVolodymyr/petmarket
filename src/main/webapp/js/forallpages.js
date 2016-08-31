$(document).ready(function () {
    $('.modal-trigger').leanModal();

});
$(document).ready(function () {
    $(".button-collapse").sideNav();
});


/*registration validation*/

$(document).ready(function () {
    $('#subButton').on('click', function () {
        if ($('#agree:checked').length > 0) {
            if (!$("#icon_acount").val()) {
                Materialize.toast('You must specify the full name', 4000);
            } else if (!$('#icon_email').val()) {
                Materialize.toast('You must specify the email', 4000);
            } else if (!$('#icon_key2').val()) {
                Materialize.toast('You forgot about the password', 4000);
            } else if ($('#icon_key2').val() == $('#icon_key1').val()) {
                if (isEmail($('#icon_email').val())) {
                    isUniqueEmail($('#icon_email').val());
                }
                else {
                    Materialize.toast('Email is invalid', 4000);
                }
            } else {
                Materialize.toast('Entered different password', 4000);
            }
        } else {
            Materialize.toast('Before that you must agree to license terms', 4000);
            return false;
        }
        return false;
    });
});


/*pet adding hide  or  show fields rules of inputs + ajax for species for current type*/

$(document).ready(function () {
    $('#addtype').hide();
    $('#species').hide();
    $('#addspecies').hide();
    $('#sex').hide();
    $('#description').hide();
    $('#btnadd').hide();

});

$(document).ready(function () {
    $("#price").on("input", function () {
        $('#divtypeselect').show();
    });
});

$(document).ready(function () {
    $("#addtype").on("input", function () {
        $('#species').show();
    });
});


$(document).ready(function () {
    $("#typeselect").on("change", function () {
            if ($("#typeselect :selected").val() == 'notype') {
                $('#addtype').show();
                $('#species').hide();
            } else {
                $('#addtype').hide();
                $('#species').show();
                var currenttype = $("#typeselect :selected").val();
                $.ajax({
                    url: '/getspecies',
                    type: 'POST',
                    dataType: 'json',
                    data: 'currenttype=' + currenttype,
                    success: function (json) {
                        var listitems = '';
                        listitems += "<option value=''" + 'disabled selected' + '>Choose species</option>';
                        listitems += '<option value=' + '"nospecies"' + '>Add new species</option>';
                        $.each(json, function (i, value) {
                            listitems += '<option value=' + '"' + value + '">' + value + '</option>';
                        });
                        $("#speciesselect").empty();
                        $('#speciesselect').append(listitems);
                        $("#speciesselect").material_select();
                    }
                });
            }
        }
    )
});

$(document).ready(function () {
    $("#speciesselect").on("change", function () {
        if ($("#speciesselect :selected").val() == 'nospecies') {
            $('#addspecies').show();
            $('#sex').hide();
        } else {
            $('#sex').show();
        }
    });
});

$(document).ready(function () {
    $("#addspecies").on("input", function () {
        $('#sex').show();
    });
});

$(document).ready(function () {
    $("#sex").on("change", function () {
        $('#description').show();
    });
});

$(document).ready(function () {
    $("#description").on("input", function () {
        $('#btnadd').show();
    });
});

$(document).ready(function () {
    $("#price").on("input", function () {
        $('#btnadd').show();
    });
});

//end of pet adding hide  or  show fields rules of inputs + ajax for species for current type


//pet add price validation

$(document).ready(function () {
    $('#subpetadd').on('click', function () {
        if (!$('#priceinput').val()) {
            Materialize.toast('You must specify the price', 4000);
        } else if ($('#priceinput').val() >= 0) {
            $('#petaddform').submit();
        }
        else {
            Materialize.toast('Price invalid ', 4000);
        }
    });
});

//email validation

function isEmail(email) {
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email);
}

//log in

$(document).ready(function () {
    $('#loginbtn').on('click', function () {
        if (!$('#login').val()) {
            Materialize.toast('Enter your email', 4000);
        } else if (isEmail($('#login').val())) {
            dataCorrect($('#login').val(), $('#passwordlogin').val());
        }
        else {
            Materialize.toast('Email invalid', 4000);
        }
    });
});

//  ajax  for  checking email and password

function dataCorrect(email, password) {
    $.ajax({
        url: '/correctdata',
        type: 'POST',
        dataType: 'json',
        data: {email: email, password: password},
        success: function (jsonresult) {
            var checkstatus = '';
            $.each(jsonresult, function (index, value) {
                checkstatus = value;
            });
            if (checkstatus == "wrongemail") {
                Materialize.toast('Account with this email doesn' + "'" + 't exist', 4000);
                return false
            }
            if (checkstatus == "wrongpass") {
                Materialize.toast('Wrong password', 4000);
                return false
            }
            if (checkstatus == "ok") {
                $('#loginform').submit();
                return false
            }
        }
    });
}


function isUniqueEmail(email) {
    $.ajax({
        url: '/correctemail',
        type: 'POST',
        dataType: 'json',
        data: {email: email},
        success: function (jsonresult) {
            var checkstatus = '';
            $.each(jsonresult, function (index, value) {
                checkstatus = value;
            });
            if (checkstatus == 'bademail') {
                Materialize.toast('Email already occupied', 4000);
                return false
            }
            if (checkstatus == "ok") {
                $('#registrationform').submit();
                return false
            }
        }
    });
}