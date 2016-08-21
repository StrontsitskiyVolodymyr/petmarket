$(document).ready(function () {
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal();
 
});
$(document).ready(function () {

    $(".button-collapse").sideNav();
});



//petsearche
function enableDisable(bEnable, textBoxID)
{
    document.getElementById(textBoxID).disabled = !bEnable;
    document.getElementByID(textBoxID).focus();
}
