document.getElementById("numHoras").addEventListener("blur", validarParte);
document.getElementById("numHorasExtra").addEventListener("blur", validarParte);
document.getElementById("refo").addEventListener("blur", validarParte);
let error = document.querySelectorAll(".errorForm");
error.forEach(p => p.hidden = true);
function validarParte(evento) {
    let numHorasInput = document.getElementById("numHoras");
    let numHorasExtraInput = document.getElementById("numHorasExtra");
    let numHoras = numHorasInput.value;
    let numHorasExtra = numHorasExtraInput.value;
    let resultado = true;
    if (numHoras < 0 || numHoras > 8) {
        document.getElementById("numHoras").nextElementSibling.hidden = false;
        resultado = false;
    }
    else {
        document.getElementById("numHoras").nextElementSibling.hidden = true;
    }
    if (numHorasExtra < 0 || numHorasExtra > 2) {
        document.getElementById("numHorasExtra").nextElementSibling.hidden = false;
        resultado = false;
    }
    else {
        document.getElementById("numHorasExtra").nextElementSibling.hidden = true;
    }
    if(refo.value == "-1"){
        document.getElementById("refo").nextElementSibling.hidden = false;
        resultado = false;
      }else{
        document.getElementById("refo").nextElementSibling.hidden = true;
      }
    if (!resultado) {
        evento.preventDefault();
    }
    return resultado;
}
let formulario = document.getElementById("formulario");
formulario.addEventListener("submit", validarParte);