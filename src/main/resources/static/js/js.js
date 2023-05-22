function validarFormularioCliente() {
	var nombre = document.querySelector("#nombre").value;
	var apellido = document.querySelector("#apellidos").value;
	var dni = document.querySelector("#dni").value;
	var ciudad = document.querySelector("#ciudad").value;
	var telefono = document.querySelector("#telefono").value;
	var email = document.querySelector("#email").value;

	if (nombre.length < 2 || nombre.length > 9) {
		alert("El nombre debe tener entre 2 y 9 caracteres.");
		return false;
	}

	if (apellido.length < 2 || apellido.length > 9) {
		alert("El apellido debe tener entre 2 y 9 caracteres.");
		return false;
	}

	if (!/^[0-9]{8}[a-zA-Z]{1}$/.test(dni)) {
		alert("El DNI debe tener 8 números y una letra al final.");
		return false;
	}

	if (ciudad.length < 3 || ciudad.length > 20) {
		alert("La ciudad debe tener entre 3 y 20 caracteres.");
		return false;
	}

	if (!/^[0-9]{1,9}$/.test(telefono)) {
		alert("El teléfono debe tener entre 1 y9 números.");
		return false;
	}

	if (!email.endsWith("@gmail.com")) {
		alert("El correo electrónico debe terminar en '@gmail.com'.");
		return false;
	}

	return true;
}
