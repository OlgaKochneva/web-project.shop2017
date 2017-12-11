function to_cart(x) {//добавление товара в корзину

    const elem = [];
    var count = [];
    for (k = 1; k < 4; k++) {
        elem.push("c" + k);
    }
    var matches;
    for (k = 0; k < 3; k++) {
        matches = document.cookie.match(new RegExp("(?:^|; )" + elem[k].replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"));
        count[k] = matches ? decodeURIComponent(matches[1]) : 0;
    }


    for (k = 1; k < 4; k++) {
        if (x == k) {
            count[k-1]++;
            document.cookie = elem[k-1] + "=" + count[k-1];
        }
    }

}
//удалить товар из горзины полностью
function del(x) {
    const elem = [];
    for (k = 1; k < 4; k++) {
        elem.push("c" + k);
    }

    for (k = 1; k < 4; k++) {
        if (x == k) {
            document.cookie = elem[k-1] + "=0";
        }
    }
    location.reload();
}
//увеличить на 1
function plus(x) {
    const elem = [];
    var count = [];
    for (k = 1; k < 4; k++) {
        elem.push("c" + k);
    }
    var matches;
    for (k = 0; k < 3; k++) {
        matches = document.cookie.match(new RegExp("(?:^|; )" + elem[k].replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"));
        count[k] = matches ? decodeURIComponent(matches[1]) : 0;
    }


    for (k = 1; k < 4; k++) {
        if (x == k) {
            count[k-1]++;
            document.cookie = elem[k-1] + "="+ count[k-1];
        }
    }
    location.reload();
}
//уменьшить на 1
function minus(x) {
    const elem = [];
    var count = [];
    for (k = 1; k < 4; k++) {
        elem.push("c" + k);
    }
    var matches;
    for (k = 0; k < 3; k++) {
        matches = document.cookie.match(new RegExp("(?:^|; )" + elem[k].replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"));
        count[k] = matches ? decodeURIComponent(matches[1]) : 0;
    }

    for (k = 1; k < 4; k++) {
        if (x == k) {
            count[k-1]--;
            document.cookie = elem[k-1] + "="+ count[k-1];
        }
    }
    location.reload();
}