document.getElementById("email").addEventListener("blur", validarTrabajador);
document.getElementById("sueldo").addEventListener("blur", validarTrabajador);
document.getElementById("precioHorasExtra").addEventListener("blur", validarTrabajador);
let error = document.querySelectorAll(".errorForm");
error.forEach(p => p.hidden = true);
function validarTrabajador(evento) {
    let emailInput = document.getElementById("email");
    let sueldoInput = document.getElementById("sueldo");
    let precioHorasExtraInput = document.getElementById("precioHorasExtra");
    let sueldo = sueldoInput.value;
    let precioHorasExtra = precioHorasExtraInput.value;
    let resultado = true;
    let emailRegex = /^[^\s@]+@[^\s@]+.[^\s@]+$/;
    if (!emailRegex.test(emailInput.value)) {
        document.getElementById("email").nextElementSibling.hidden = false;
        resultado = false;
    } else {
        document.getElementById("email").nextElementSibling.hidden = true;
    }
    if (sueldo < 0) {
        document.getElementById("sueldo").nextElementSibling.hidden = false;
        resultado = false;
    } else {
        document.getElementById("sueldo").nextElementSibling.hidden = true;
    }
    if (precioHorasExtra < 0) {

        document.getElementById("precioHorasExtra").nextElementSibling.hidden = false;
        resultado = false;
    } else {
        document.getElementById("precioHorasExtra").nextElementSibling.hidden = true;
    }
    if (!resultado) {
        evento.preventDefault();
    }
}
let formulario = document.getElementById("formulario");
formulario.addEventListener("submit", validarTrabajador);