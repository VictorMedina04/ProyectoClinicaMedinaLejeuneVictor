document.addEventListener('DOMContentLoaded', function() {
	const deleteButtons = document.querySelectorAll('.delete-button');
	const deleteModal = document.getElementById('delete-modal');
	const confirmDeleteBtn = document.querySelector('.confirm-delete');
	let deleteUrl = '';

	deleteButtons.forEach(button => {
		button.addEventListener('click', function() {
			const idDoctor = button.getAttribute('data-id-doctor');
			const idCliente = button.getAttribute('data-id-cliente');
			const fechaInicio = button.getAttribute('data-fecha-inicio');
			const fechaInicio1 = fechaInicio.replace(' ', 'T');
			deleteUrl = `/admin/borrarCita/${idDoctor}/${idCliente}/${fechaInicio1}`;
			confirmDeleteBtn.setAttribute('href', deleteUrl);
			deleteModal.show();
		});
	});


});