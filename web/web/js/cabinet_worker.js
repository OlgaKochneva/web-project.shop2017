function checked(x) {//работа с радиобаттанами
    xx = parseInt(x);
    switch(xx){
        case 1:
            document.getElementById("b1").setAttribute("checked","checked");
            break;
        case 2:
            document.getElementById("b2").setAttribute("checked","checked");
            break;
        case 3:
            document.getElementById("b3").setAttribute("checked","checked");
            break;
        default:
            document.getElementById("b1").setAttribute("checked","checked");
            break;
    }
}

function changeTab(evt, tabName) {//переключение вкладок и их подсветка
    var i, tabs, tab;
    tabs = document.getElementsByClassName("tab");
    for (i = 0; i < tabs.length; i++) {
        tabs[i].style.display = "none";
    }

    tab = document.getElementsByClassName("cart_tab");
    for (i = 0; i < tab.length; i++) {
        tab[i].className = tab[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}