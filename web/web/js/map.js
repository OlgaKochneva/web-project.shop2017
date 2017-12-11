var map;
var Shop1;
var Shop2;

function initMap() {
    ymaps.ready(init);

    function init() {
        map = new ymaps.Map("map", {
            center: [48.783056, 44.771321],
            zoom: 12,
            controls: ['smallMapDefaultSet']
        });
        Shop1 = new ymaps.Placemark([48.78821988, 44.74996448], {

            hintContent: 'Boards only',
            balloonContent: 'Магазин скейтбордов Boards only ' +
            'Проспект Ленина, 84'
        });
        Shop2 = new ymaps.Placemark([48.77212909, 44.80039537], {

            hintContent: 'Boards only',
            balloonContent: 'Магазин скейтбордов Boards only ' +
            'Улица Александрова, 18'
        });

        map.geoObjects.add(Shop1);
        map.geoObjects.add(Shop2);
    }
}
    function changeShop() {
        var shop = document.getElementById("shop-choice").value;

        map.setZoom(17);
        switch (shop) {
            case '2':
                map.setCenter([48.78821988, 44.74996448]);
                break;
            case '1':
                map.setCenter([48.77212909, 44.80039537]);
                break;
        }
    }

function changeType() {
    if(document.getElementById("type-choice").checked){
        document.getElementById("shop").style.display = "none";
        document.getElementById("courier").style.display = "block";
    }
    else {
        document.getElementById("shop").style.display = "block";
        document.getElementById("courier").style.display = "none";
    }
}

