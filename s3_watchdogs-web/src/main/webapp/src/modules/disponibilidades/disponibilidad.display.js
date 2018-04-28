function pathDisponibilidad(dummy){

    if(dummy == "D"){
        return "src/images/disponible.jpg";
    }else if(dummy == "A"){
        return "src/images/agendado.png";
    }else if (dummy == "L"){
        return "src/images/libre.jpg";
    }else {
        return "";
    }    
}
