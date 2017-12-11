function openTab(evt, tabName) {//переключение вкладок в на странице продукта
    var i, tabs, tab;
    tabs = document.getElementsByClassName("tabs");
    for (i = 0; i < tabs.length; i++) {
        tabs[i].style.display = "none";
    }

    tab = document.getElementsByClassName("tab");
    for (i = 0; i < tab.length; i++) {
        tab[i].className = tab[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

function openfirstTab(tabName) {//подсветка стартовой вкладки на странице продукта
    var i, tabs, tab;

    tabs = document.getElementsByClassName("tabs");
    for (i = 0; i < tabs.length; i++) {
        tabs[i].style.display = "none";
    }

    tab = document.getElementsByClassName("tab");
    for (i = 0; i < tab.length; i++) {
        tab[i].className = tab[i].className.replace(" active", "");
        if (tabName == tabs[i].getAttribute("id")) {
            tabs[i].style.display = "block";
            tab[i].className += " active";
        }
    }
}

