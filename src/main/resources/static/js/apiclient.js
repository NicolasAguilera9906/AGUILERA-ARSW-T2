var apiclient = (function () {

    var url = "https://open-weath3r-app.herokuapp.com"
    function getWeatherOfACity(city){
        var data = $.ajax({
            url: url + "/weather?q=" + city,
            type: "GET",
            error: function (request){
                Swal.fire({
                    position: "center",
                    icon: "error",
                    title: "Oops...",
                    text: request.responseText,
                    showConfirmButton: false,
                    timer: 2500
                }).then(function(){
                    window.location.href=url;
                });
            }
        });
        return data;
    }
    return {
        getWeatherOfACity:getWeatherOfACity,
    };

})();