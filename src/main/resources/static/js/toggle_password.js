let state = false;
function toggle()
{
    if(state)
    {
        document.getElementById("password").setAttribute("type","password");
        document.getElementById("togglePassword").style.color="black";
        state= false;
    }
    else
    {
        document.getElementById("password").setAttribute("type","text");
        document.getElementById("togglePassword").style.color="white";
        state= true;
    }
}