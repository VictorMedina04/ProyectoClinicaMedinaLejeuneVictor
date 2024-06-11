document.addEventListener('DOMContentLoaded', function() {
	'use strict';
	let forms = document.querySelectorAll('.needs-validation');
	Array.prototype.slice.call(forms).forEach(function(form) {
		form.addEventListener('submit', function(event) {
			if (!form.checkValidity()) {
				event.preventDefault();
				event.stopPropagation();
			}
			form.classList.add('was-validated');
		}, false);
	});
});

function togglePasswordVisibility(pwdId, eyeId) {
	const passwordInput = document.getElementById(pwdId);
	const eyeIcon = document.getElementById(eyeId);
	if (passwordInput.type === 'password') {
		passwordInput.type = 'text';
		eyeIcon.classList.remove('bi-eye-fill');
		eyeIcon.classList.add('bi-eye-slash-fill');
	} else {
		passwordInput.type = 'password';
		eyeIcon.classList.remove('bi-eye-slash-fill');
		eyeIcon.classList.add('bi-eye-fill');
	}
}

(function() {
	'use strict';
	let form = document.querySelector('.needs-validation');
	let passwordInput = document.getElementById('pwd');
	let confirmPasswordInput = document.getElementById('pwd2');

	function validatePasswords() {
		if (passwordInput.value !== confirmPasswordInput.value) {
			confirmPasswordInput.setCustomValidity('Las contraseñas no coinciden');
		} else {
			confirmPasswordInput.setCustomValidity('');
		}
	}

	passwordInput.addEventListener('input', validatePasswords);
	confirmPasswordInput.addEventListener('input', validatePasswords);

	form.addEventListener('submit', function(event) {
		if (form.checkValidity() === false) {
			event.preventDefault();
			event.stopPropagation();
		}
		form.classList.add('was-validated');
	}, false);
})();