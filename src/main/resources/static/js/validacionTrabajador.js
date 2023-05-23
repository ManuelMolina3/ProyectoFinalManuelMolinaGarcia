document.getElementById("email").addEventListener("blur", validarTrabajdor);
let error = document.querySelectorAll(".errorForm");
error.forEach(p => p.hidden = true);
function validarTrabajdor(evento) {
    let emailInput = document.getElementById("email");
    let resultado = true;
    let emailRegex = /^[^\s@]+@[^\s@]+.[^\s@]+$/;
    if (!emailRegex.test(emailInput.value)) {
        document.getElementById("email").nextElementSibling.hidden = false;
        resultado = false;
    } else {
        document.getElementById("email").nextElementSibling.hidden = true;
    }
    if (!resultado) {
        evento.preventDefault();
    }
}
let formulario = document.getElementById("formulario");
formulario.addEventListener("submit", validarTrabajdor);