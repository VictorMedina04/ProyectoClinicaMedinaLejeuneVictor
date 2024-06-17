
		        document.addEventListener('DOMContentLoaded', function () {
		            const form = document.querySelector('.needs-validation');
		            form.addEventListener('submit', function (event) {
		                if (!form.checkValidity()) {
		                    event.preventDefault();
		                    event.stopPropagation();
		                }
		                form.classList.add('was-validated');
		            }, false);
		
		            // Establecer la fecha mínima en el campo de fecha
		            const fechaInicioInput = document.getElementById('fechaInicio');
		            const today = new Date();
		            const yyyy = today.getFullYear();
		            const mm = String(today.getMonth() + 1).padStart(2, '0'); 
		            const dd = String(today.getDate()).padStart(2, '0');
		            const hh = String(today.getHours()).padStart(2, '0');
		            const min = String(today.getMinutes()).padStart(2, '0');
		
		            const fechaMinima = `${yyyy}-${mm}-${dd}T${hh}:${min}`;
		            fechaInicioInput.setAttribute('min', fechaMinima);
		
		            // Limitar las horas y minutos permitidos
		            fechaInicioInput.addEventListener('input', function () {
		                const dateValue = new Date(fechaInicioInput.value);
		                const hours = dateValue.getHours();
		                const minutes = dateValue.getMinutes();
		
		                if (![ 18, 19, 20, 21].includes(hours) || minutes !== 0) {
		                    fechaInicioInput.setCustomValidity('La hora debe ser entre 18:00 y 21:00 con minutos en 00.');
		                } else {
		                    fechaInicioInput.setCustomValidity('');
		                }
		            });
		
		            // Mostrar mensaje de error personalizado
		            fechaInicioInput.addEventListener('invalid', function () {
		                if (fechaInicioInput.validity.customError) {
		                    fechaInicioInput.nextElementSibling.textContent = fechaInicioInput.validationMessage;
		                }
		            });
		
		            // Eliminar el mensaje de error cuando sea válido
		            fechaInicioInput.addEventListener('input', function () {
		                if (fechaInicioInput.validity.valid) {
		                    fechaInicioInput.nextElementSibling.textContent = '';
		                }
		            });
		        });