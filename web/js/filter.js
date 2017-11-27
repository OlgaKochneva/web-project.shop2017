function sort(fl) {
    const name = "filter";
    var matches = document.cookie.match(new RegExp("(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"));
    if(fl == undefined) {
        fl = matches ? decodeURIComponent(matches[1]) : 0;
    }else{
        document.cookie = "filter=" + fl;
    }
    var type22, type27, typelg;
    type22=document.getElementsByClassName("22");
    type27=document.getElementsByClassName("27");
    typelg=document.getElementsByClassName("lg");
    if(fl==0)
    {for (i=0;i<type22.length;i++)
            {
                type22[i].style.display="block";
            }
            for (i=0;i<type27.length;i++)
            {
                type27[i].style.display="block";
            }
            for (i=0;i<typelg.length;i++)
            {
                typelg[i].style.display="block";
            }

        }
    if(fl==1)
        {
            for (i=0;i<type22.length;i++)
            {
                type22[i].style.display="block";
            }
            for (i=0;i<type27.length;i++)
            {
                type27[i].style.display="none";
            }
            for (i=0;i<typelg.length;i++)
            {
                typelg[i].style.display="none";
            }

        }
        if(fl==2)
        {
            for (i=0;i<type22.length;i++)
            {
                type22[i].style.display="none";
            }
            for (i=0;i<type27.length;i++)
            {
                type27[i].style.display="block";
            }
            for (i=0;i<typelg.length;i++)
            {
                typelg[i].style.display="none";
            }

        }
       if(fl==3)
        {
            for (i=0;i<type22.length;i++)
            {
                type22[i].style.display="none";
            }
            for (i=0;i<type27.length;i++)
            {
                type27[i].style.display="none";
            }
            for (i=0;i<typelg.length;i++)
            {
                typelg[i].style.display="block";
            }

        }
}

