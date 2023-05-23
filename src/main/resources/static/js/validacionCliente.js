let nombreInput = document.getElementById("nombre");
let apellidoInput = document.getElementById("apellido");
let dniInput = document.getElementById("dni");
let ciudadInput = document.getElementById("ciudad");
let telefonoInput = document.getElementById("telefono");
let emailInput = document.getElementById("email");

// Crear función de validación
function validarFormulario(evento) {
	let resultado= true;
  // Validar nombre
  if (nombreInput.value.length > 13) {
    alert("El nombre no puede tener más de 13 letras.");
	resultado= false;
  }

  // Validar apellido
  if (apellidoInput.value.length > 13) {
    alert("El apellido no puede tener más de 13 letras.");
     resultado= false;
  }

  // Validar DNI
  let dniRegex = /^[0-9]{8}[a-zA-Z]$/;
  if (!dniRegex.test(dniInput.value)) {
    alert("El DNI no es válido.");
     resultado= false;
  }

  // Validar ciudad
  if (ciudadInput.value.length < 3 || ciudadInput.value.length > 13) {
    alert("La ciudad debe tener entre 3 y 13 letras.");
     resultado= false;
  }

  // Validar teléfono
  if (telefonoInput.value.length = 9) {
    alert("El teléfono tiene que tener 9 números.");
     resultado= false;
  }

  // Validar email
let emailRegex = /^[^\s@]+@[^\s@]+\@]+gmail\.com$/;
  if (!emailRegex.test(emailInput.value)) {
    alert("El email debe terminar en @gmail.com");
     resultado= false;
  }

  evento.preventDefault();
  return resultado;
}

let formulario = document.getElementById("formulario");
formulario.addEventListener("submit", validarFormulario);