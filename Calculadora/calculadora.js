window.onload = function(){ 
        pantalla=document.getElementById("textoPantalla");
    }
    x="0"; 
    iniciarNumero=1; 
    coma=0; 
    ni=0; 
    op="no"; 

    function numero(numeroEntrada) { 
             if (x=="0" || iniciarNumero==1  ) {	
                pantalla.innerHTML=numeroEntrada; 
                x=numeroEntrada; 
                if (numeroEntrada==".") { 
                   pantalla.innerHTML="0."; 
                   x=numeroEntrada; 
                   coma=1;
                }
            }
            else { 
                   if (numeroEntrada=="." && coma==0) { 
                       pantalla.innerHTML+=numeroEntrada;
                       x+=numeroEntrada;
                       coma=1;  
                   }

                   else if (numeroEntrada=="." && coma==1) {} 

                   else {
                       pantalla.innerHTML+=numeroEntrada;
                       x+=numeroEntrada
                   }
                }
                iniciarNumero=0 
             }
             
    function operar(s) {
             igualar() 
             ni=x 
             op=s; 
             iniciarNumero=1; 
             }	

    function igualar() {
             if (op=="no") { 
                pantalla.innerHTML=x;	
                }
             else { 
                sl=ni+op+x; 
                sol=eval(sl) 
                pantalla.innerHTML=sol 
                x=sol; 
                op="no"; 
                iniciarNumero=1; 
                }
            }

    function raizc() {
             x=Math.sqrt(x) 
             pantalla.innerHTML=x; 
             op="no"; 
             iniciarNumero=1; 
    }

    function porcent() { 
             x=x/100 
             pantalla.innerHTML=x;
             igualar() 
             iniciarNumero=1
             }

    function opuest() { 
             nx=Number(x); 
             nx=-nx; 
             x=String(nx); 
             pantalla.innerHTML=x; 
             }

    function inve() {
             nx=Number(x);
             nx=(1/nx);
             x=String(nx);		 
             pantalla.innerHTML=x;
             iniciarNumero=1; 
             }
    
    function retro(){ 
             cifras=x.length; 
             br=x.substr(cifras-1,cifras)
             x=x.substr(0,cifras-1) 
             if (x=="") {x="0";} 
             if (br==".") {coma=0;} 
             pantalla.innerHTML=x;	 
             }

    function borradoParcial() {
            pantalla.innerHTML=0; 
            x=0;
            coma=0;					
            }

    function borradoTotal() {
             pantalla.innerHTML=0; 
             x="0"; 
             coma=0; 
             ni=0 
             op="no"
             }