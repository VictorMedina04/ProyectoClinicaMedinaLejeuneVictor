document.addEventListener('DOMContentLoaded', function() {
	let form = document.getElementById('formulario');
	form.addEventListener('submit', function(event) {
		if (!form.checkValidity()) {
			event.preventDefault();
			event.stopPropagation();
		}
		form.classList.add('was-validated');
	}, false);
});