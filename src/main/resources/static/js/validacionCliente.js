document.getElementById("dni").addEventListener("blur", validarFormulario);
document.getElementById("telefono").addEventListener("blur", validarFormulario);
document.getElementById("email").addEventListener("blur", validarFormulario);

let error = document.querySelectorAll(".errorForm");
error.forEach(p => p.hidden = true);

// Crear función de validación
function validarFormulario(evento) {
  let dniInput = document.getElementById("dni");
  let telefonoInput = document.getElementById("telefono");
  let emailInput = document.getElementById("email");

  let resultado = true;

  // Validar DNI
  let dniRegex = /^[0-9]{8}[a-zA-Z]$/;
  if (!dniRegex.test(dniInput.value)) {
    document.getElementById("dni").nextElementSibling.hidden = false;
    resultado = false;
  } else {
    document.getElementById("dni").nextElementSibling.hidden = true;
  }

  // Validar teléfono
  if (telefonoInput.value.length > 9 || telefonoInput.value.length < 8) {
    document.getElementById("telefono").nextElementSibling.hidden = false;
    resultado = false;
  } else {
    document.getElementById("telefono").nextElementSibling.hidden = true;
  }
let emailRegex = /^[^\s@]+@[^\s@]+.[^\s@]+$/;
if (!emailRegex.test(emailInput.value)) {
document.getElementById("email").nextElementSibling.hidden = false;
resultado= false;
}else{
document.getElementById("email").nextElementSibling.hidden = true;

}

  // Si al menos un campo no es válido
  if (!resultado) {
    evento.preventDefault();
  }
}

let formulario = document.getElementById("formulario");
formulario.addEventListener("submit", validarFormulario);