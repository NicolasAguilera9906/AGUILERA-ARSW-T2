var gmap = (function () {

    function initMap(data){
        if(data!=null) {
            var options = {
                zoom: 4,
                center: {lat: data.coord.lat, lng: data.coord.lon}
            }
            //New map
            var map = new google.maps.Map(document.getElementById('map'), options);

            //Add marker
            var marker = new google.maps.Marker({
                position: {lat: data.coord.lat, lng: data.coord.lon},
                map: map
            });
        }
    }
    return {
        initMap,initMap,
    };
})();