$(document).ready(function () {
    $('.sidenav').sidenav({
        edge: 'right'
    });

    $('.modal').modal();

    if (sessionStorage.scrollTop != "undefined") {
        $(window).scrollTop(sessionStorage.scrollTop);
    }
})

$(window).scroll(function () {
    sessionStorage.scrollTop = $(this).scrollTop();
})