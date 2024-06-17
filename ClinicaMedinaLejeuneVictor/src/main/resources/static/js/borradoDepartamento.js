document.addEventListener('DOMContentLoaded', function() {
	const deleteButtons = document.querySelectorAll('.delete-button');
	const deleteModal = document.getElementById('delete-modal');
	const confirmDeleteBtn = deleteModal.querySelector('.confirm-delete');

	deleteButtons.forEach(button => {
		button.addEventListener('click', function() {
			const departamentoId = this.getAttribute('data-depart-id');
			const deleteUrl = `/admin/borrarDepartamento/${departamentoId}`;
			confirmDeleteBtn.setAttribute('href', deleteUrl);
		});
	});
});