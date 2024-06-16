			document.addEventListener('DOMContentLoaded', function () {
					const deleteButtons = document.querySelectorAll('.delete-button');
					const deleteModal = document.getElementById('delete-modal');
					const confirmDeleteBtn = deleteModal.querySelector('.confirm-delete');
		
					deleteButtons.forEach(button => {
						button.addEventListener('click', function () {
							const seguroId = this.getAttribute('data-seguro-id');
							const deleteUrl = `/admin/borrarSeguro/${seguroId}`;
							confirmDeleteBtn.setAttribute('href', deleteUrl);
						});
					});
				});