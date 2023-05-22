let nombreInput = document.getElementById("nombre");
let apellidoInput = document.getElementById("apellido");
let dniInput = document.getElementById("dni");
let ciudadInput = document.getElementById("ciudad");
let telefonoInput = document.getElementById("telefono");
let emailInput = document.getElementById("email");

// Crear función de validación
function validarFormulario() {
  // Validar nombre
  if (nombreInput.value.length > 13) {
    alert("El nombre no puede tener más de 13 letras.");
    return false;
  }

  // Validar apellido
  if (apellidoInput.value.length > 13) {
    alert("El apellido no puede tener más de 13 letras.");
    return false;
  }

  // Validar DNI
  let dniRegex = /^[0-9]{8}[a-zA-Z]$/;
  if (!dniRegex.test(dniInput.value)) {
    alert("El DNI no es válido.");
    return false;
  }

  // Validar ciudad
  if (ciudadInput.value.length < 3 || ciudadInput.value.length > 13) {
    alert("La ciudad debe tener entre 3 y 13 letras.");
    return false;
  }

  // Validar teléfono
  if (telefonoInput.value.length > 9) {
    alert("El teléfono no puede tener más de 9 números.");
    return false;
  }

  // Validar email
let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+gmail\.com$/;
  if (!emailRegex.test(emailInput.value)) {
    alert("El email debe terminar en @gmail.com.");
    return false;
  }


  return true;
}

let formulario = document.getElementById("formulario");
formulario.addEventListener("submit", validarFormulario);