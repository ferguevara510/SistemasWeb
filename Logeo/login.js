var BotonValidar = document.getElementById("enviar");

BotonValidar.addEventListener("click", function () {
    var params = new URLSearchParams();
    var usuario = document.getElementById("usuario").value;
    var password = document.getElementById("password").value;
    params.append("usu", usuario);
    params.append("pass", password);
    console.log("{" + "name:'" + params.get("usu") + "'," + "pass:'" + params.get("pass") + "'}");
    //var params2 = "{" + "name:'" + params.get("nombre") + "'," + "pass:'" + params.get("pass") + "'}";  // forma de equívoca de construir el objeto, ya que le sobran las llaves
    var params3 =  "name:'" + params.get("usu") + "'," + "pass:'" + params.get("pass") + "'";
    axios.post("http://localhost:4567/holaJson", { "usu": params.get("usu"), pass: params.get("pass") } )
        .then(function (rs) {
            console.log(rs.data);
            //alert(rs.data)
        })
        .catch(function (error) {
            console.log(error);
        });

        if(params.get("usu") == "Nadia"){
            if(params.get("pass") == "12345"){
                console.log("Hola");
                window.location.replace('usuarios.html');
            }
        }else{
            window.location.replace('registro.html');
             
        }
});