function to_cart(x) {

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