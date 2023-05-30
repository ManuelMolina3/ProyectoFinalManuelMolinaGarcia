document.getElementById("coste").addEventListener("blur", validarPrecio);
document.getElementById("pvpMaterial").addEventListener("blur", validarPrecio);
let error = document.querySelectorAll(".errorForm");
error.forEach(p => p.hidden = true);
function validarPrecio(evento) {
    let costeInput = document.getElementById("coste");
    let pvpInput = document.getElementById("pvpMaterial");
    let resultado = true;
    if (costeInput.value > pvpInput.value) {
        document.getElementById("pvpMaterial").nextElementSibling.hidden = false;
        resultado = false;
    } else {
        document.getElementById("pvpMaterial").nextElementSibling.hidden = true;
    }
    if (costeInput.value < 0) {
        document.getElementById("coste").nextElementSibling.hidden = false;
        resultado = false;
    }else{
        document.getElementById("coste").nextElementSibling.hidden = true;
    }
    if (!resultado) {
        evento.preventDefault();
    }
    return resultado;
}
let formulario = document.getElementById("formulario");
formulario.addEventListener("submit", validarPrecio);