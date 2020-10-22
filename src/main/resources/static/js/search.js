var searchModule = (function () {

    var url = "https://open-weath3r-app.herokuapp.com"

    function searchWeather(city) {
        if(city=="" || city==null){
            Swal.fire({
                position: "center",
                icon: "error",
                title: "Oops...",
                text: "The city can't be null",
                showConfirmButton: false,
                timer: 2500
            }).then(function(){
                window.location.href=url;
            });
        }
        else {
            apiclient.getWeatherOfACity(city).then(function (data, text) {
                clear();
                weather = parse(data);
                write(weather);
                gmap.initMap(weather);
            });
        }
    }
    function clear(data){
        $("#city").html("");
        $("#temperature").html("");
        $("#description").html("");
        $("#windspeed").html("");
        $("#pressure").html("");
        $("#humidity").html("");
        $("#dew_point").html("");
        $("#visibility").html("");
        $("#date").html("");
    }
    function write(data){
        var timezoneInMinutes = data.timezone / 60;
        var currTime = moment().utcOffset(timezoneInMinutes).format("dddd, MMMM Do YYYY, h:mm:ss a");
        $("#date").append(currTime);
        $("#city").append("<b>"+data.name+","+data.sys.country+"<b>");
        var temp = Math.round(data.main.temp-273.15);
        $("#temperature").append("<b>"+temp+"&deg;"+"C");
        var tempLike = Math.round(data.main.feels_like-273.15);
        $("#description").append("Feels like "+tempLike+"&deg;"+"C"+". "+data.weather[0].main+". "+data.weather[0].description);
        $("#windspeed").append("Wind speed: "+data.wind.speed+" m/s");
        $("#pressure").append("Pressure: "+data.main.pressure+" hPa");
        $("#humidity").append("Humidity: "+data.main.humidity+" %");
        var tempMin = Math.round(data.main.temp_min-273.15);
        $("#dew_point").append("Dew point: "+tempMin+" %");
        var visibility = (data.visibility)/1000;
        $("#visibility").append("Visibility "+visibility+" km");

    }

    function parse(txt){
        return JSON.parse(txt);
    }

    return {
        searchWeather:searchWeather,
    };
})();