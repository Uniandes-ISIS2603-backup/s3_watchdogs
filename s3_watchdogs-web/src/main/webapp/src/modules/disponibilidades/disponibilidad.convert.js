function convertDisp(disponibilidad){
    
    var disp = disponibilidad.matrizHorarios;
    
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
    
    var rta = {dom:{h8:d[0], h9:d[1], h10:d[2], h11:d[3], h12:d[4], h13:d[5], h14:d[6], h16:d[7], h17:d[8], h18:d[9], h19:d[10],h20:d[11]},
               lun:{h8:l[0], h9:l[1], h10:l[2], h11:l[3], h12:l[4], h13:l[5], h14:l[6], h16:l[7], h17:l[8], h18:l[9], h19:l[10],h20:l[11]},
               mar:{h8:m[0], h9:m[1], h10:m[2], h11:m[3], h12:m[4], h13:m[5], h14:m[6], h16:m[7], h17:m[8], h18:m[9], h19:m[10],h20:m[11]},
               mie:{h8:x[0], h9:x[1], h10:x[2], h11:x[3], h12:x[4], h13:x[5], h14:x[6], h16:x[7], h17:x[8], h18:x[9], h19:x[10],h20:x[11]},
               jue:{h8:j[0], h9:j[1], h10:j[2], h11:j[3], h12:j[4], h13:j[5], h14:j[6], h16:j[7], h17:j[8], h18:j[9], h19:j[10],h20:j[11]},
               vie:{h8:v[0], h9:v[1], h10:v[2], h11:v[3], h12:v[4], h13:v[5], h14:v[6], h16:v[7], h17:v[8], h18:v[9], h19:v[10],h20:v[11]},
               sab:{h8:s[0], h9:s[1], h10:s[2], h11:s[3], h12:s[4], h13:s[5], h14:s[6], h16:s[7], h17:s[8], h18:s[9], h19:s[10],h20:s[11]}};
           
    disponibilidad.matrizHorarios = rta;
}

