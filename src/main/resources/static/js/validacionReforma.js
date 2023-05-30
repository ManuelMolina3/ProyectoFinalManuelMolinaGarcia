document.getElementById("fechaFinal").addEventListener("blur", validarFechas);
document.getElementById("fechaInicio").addEventListener("blur", validarFechas);
document.getElementById("presupuesto").addEventListener("blur", validarFechas);
let error = document.querySelectorAll(".errorForm");
error.forEach(p => p.hidden = true);
function validarFechas(evento) {
    let fechaInicioInput = document.getElementById("fechaInicio");
    let fechaFinalInput = document.getElementById("fechaFinal");
    let presupuestoInput = document.getElementById("presupuesto");
    let presupuesto = presupuestoInput.value;
    let fechaInicio = new Date(fechaInicioInput.value);
    let fechaFinal = new Date(fechaFinalInput.value);
    let resultado = true;
    if (fechaInicio > fechaFinal) {
      document.getElementById("fechaFinal").nextElementSibling.hidden = false;
      resultado = false;
    }else{
      document.getElementById("fechaFinal").nextElementSibling.hidden = true;
    }
    if(presupuesto < 0){ 
      document.getElementById("presupuesto").nextElementSibling.hidden = false;
      resultado = false;
    }else{
      document.getElementById("presupuesto").nextElementSibling.hidden = true;
    }
    if(!resultado){
        evento.preventDefault();
    }
    return resultado;
  }
let formulario = document.getElementById("formulario");
formulario.addEventListener("submit", validarFechas);