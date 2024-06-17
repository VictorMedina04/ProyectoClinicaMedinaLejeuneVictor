document.addEventListener('DOMContentLoaded', function() {
	const deleteButtons = document.querySelectorAll('.delete-button');
	const deleteModal = document.getElementById('delete-modal');
	const confirmDeleteBtn = deleteModal.querySelector('.confirm-delete');

	deleteButtons.forEach(button => {
		button.addEventListener('click', function() {
			const doctorId = this.getAttribute('data-doctor-id');
			const deleteUrl = `/admin/borrarDoctor/${doctorId}`;
			confirmDeleteBtn.setAttribute('href', deleteUrl);
		});
	});
});