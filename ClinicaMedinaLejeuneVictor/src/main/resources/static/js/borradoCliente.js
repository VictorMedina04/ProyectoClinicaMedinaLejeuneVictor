document.addEventListener('DOMContentLoaded', function() {
	const deleteButtons = document.querySelectorAll('.delete-button');
	const deleteModal = document.getElementById('delete-modal');
	const confirmDeleteBtn = deleteModal.querySelector('.confirm-delete');

	deleteButtons.forEach(button => {
		button.addEventListener('click', function() {
			const clientId = this.getAttribute('data-client-id');
			const deleteUrl = `/admin/borrarCliente/${clientId}`;
			confirmDeleteBtn.setAttribute('href', deleteUrl);
		});
	});
});