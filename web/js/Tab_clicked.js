function openTab(evt, tabName) {
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

function openfirstTab(tabName) {
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
