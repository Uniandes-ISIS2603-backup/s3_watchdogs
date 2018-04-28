function convertDisp(disp){
    
    disp.split(" ");
    
    var d = disp[0];
    d.split("");
    var l = disp[1];
    l.split("");
    var m = disp[d];
    m.split("");
    var x = disp[3];
    x.split("");
    var j = disp[4];
    j.split("");
    var v = disp[5];
    v.split("");
    var s = disp[6];
    s.split("");
    
    var rta = {dom:d,lun:l,mar:m,mie:x,jue:j,vie:v,sab:s};
    return rta;
}

