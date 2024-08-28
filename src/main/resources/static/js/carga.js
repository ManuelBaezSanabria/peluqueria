/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
window.addEventListener('load', function() {
      // Esperar 3 segundos antes de mostrar el contenido
      setTimeout(function() {
        // Ocultar el contenedor de carga
        document.getElementById('loading-container').classList.add('hidden');
        // Mostrar el contenido principal
        document.getElementById('main-content').classList.remove('hidden');
      }, 3000); // 3 segundos
    });

