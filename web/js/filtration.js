function sort(fl) {
    const name = "filter";
    var matches = document.cookie.match(new RegExp("(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"));
    if (fl == undefined) {
        fl = matches ? decodeURIComponent(matches[1]) : 0;
    } else {
        document.cookie = "filter=" + fl;
    }


    if (fl == 0) {
        for (i = 1; i < 4; i++) {
            if( document.getElementById("22"+i) !== null ){
                document.getElementById("22"+i).style.display = "block";
            }
            if( document.getElementById("27"+i) !== null ){
                document.getElementById("27"+i).style.display = "block";
            }
            if( document.getElementById("long"+i) !== null ){
                document.getElementById("long"+i).style.display = "block";
            }
        }
    } else {

        if (fl == 1) {
            for (i = 1; i < 4; i++) {
                if( document.getElementById("22"+i) !== null ){
                    document.getElementById("22"+i).style.display = "block";
                }
                if( document.getElementById("27"+i) !== null ){
                    document.getElementById("27"+i).style.display = "none";
                }
                if( document.getElementById("long"+i) !== null ){
                    document.getElementById("long"+i).style.display = "none";
                }


            }
        }
         if (fl == 2) {
                for (i = 1; i < 4; i++) {
                    if (document.getElementById("22" + i) !== null) {
                        document.getElementById("22" + i).style.display = "none";
                    }
                    if (document.getElementById("27" + i) !== null) {
                        document.getElementById("27" + i).style.display = "block";
                    }
                    if( document.getElementById("long"+i) !== null ){
                        document.getElementById("long"+i).style.display = "none";
                    }
                }
            }
            if (fl == 3) {
                for (i = 1; i < 4; i++) {
                    if (document.getElementById("22" + i) !== null) {
                        document.getElementById("22" + i).style.display = "none";
                    }
                    if (document.getElementById("27" + i) !== null) {
                        document.getElementById("27" + i).style.display = "none";

                    }
                    if( document.getElementById("long"+i) !== null ){
                        document.getElementById("long"+i).style.display = "block";
                    }
                }
            }
        }

}