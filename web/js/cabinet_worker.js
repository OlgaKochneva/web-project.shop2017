function checked(x) {
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