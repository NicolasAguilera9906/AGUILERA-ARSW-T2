var apiclient = (function () {

    var url = "https://open-weath3r-app.herokuapp.com"
    function getWeatherOfACity(city){
        var data = $.ajax({
            url: url + "/weather?q=" + city,
            type: "GET"
        });
        return data;
    }
    return {
        getWeatherOfACity:getWeatherOfACity,
    };

})();