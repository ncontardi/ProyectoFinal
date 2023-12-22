document.addEventListener("DOMContentLoaded", function () {
    document.getElementById('carrito-label').addEventListener('click', function () {
        const menuNavbar = document.querySelector('.navbar');
        menuNavbar.classList.toggle('show');
    });

    const btnsAgregarCarrito = document.querySelectorAll('.coffee button');
    const cuentaCarrito = document.getElementById('cuenta-carrito');
    const carritoLista = document.getElementById('listaCarrito');
    const totalCarrito = document.getElementById('total');

    let contadorCarrito = 0;

    function agregarAlCarrito(producto) {
        contadorCarrito++;
        cuentaCarrito.textContent = contadorCarrito;
    
        const itemExistente = Array.from(carritoLista.children).find(item => {
            const nombreEnCarrito = item.querySelector('span:first-child').textContent;
            return nombreEnCarrito === producto.nombre;
        });
    
        if (itemExistente) {
            const cantidadSpan = itemExistente.querySelector('span:last-child');
    
            if (cantidadSpan) {
                const cantidadActual = parseInt(cantidadSpan.textContent.split(': ')[1]);
                cantidadSpan.textContent = `Cantidad: ${cantidadActual + 1}`;
            } else {
                // Agregar el manejo para el caso donde cantidadSpan es null
                const nuevoItemCarrito = document.createElement('li');
                nuevoItemCarrito.innerHTML = `
                    <span>${producto.nombre}</span>
                    <span>${producto.precio}</span>
                    <span>Cantidad: 1</span>
                    <button class="eliminar-item btn-eliminar">Eliminar</button>
                `;
                carritoLista.appendChild(nuevoItemCarrito);
            }
        } else {
            // En este caso, el producto no existe en el carrito, así que lo agregamos como nuevo
            const nuevoItemCarrito = document.createElement('li');
            nuevoItemCarrito.innerHTML = `
                <span>${producto.nombre}</span>
                <span>${producto.precio}</span>
                <span>Cantidad: 1</span>
                <button class="eliminar-item btn-eliminar">Eliminar</button>
            `;
            carritoLista.appendChild(nuevoItemCarrito);
        }
    
        // Actualizar total del carrito
        actualizarTotalCarrito();
    }

    // Manejador de eventos para eliminar un elemento del carrito
    carritoLista.addEventListener('click', function (event) {
        if (event.target.classList.contains('eliminar-item')) {
            const item = event.target.parentElement;
            const nombreEnCarrito = item.querySelector('span:first-child').textContent;

            // Restar 1 al contador del carrito
            contadorCarrito--;

            // Actualizar la cuenta en la interfaz
            cuentaCarrito.textContent = contadorCarrito;

            // Eliminar el elemento del carrito
            item.remove();

            // Actualizar total del carrito
            actualizarTotalCarrito();
        }
    });

    function actualizarTotalCarrito() {
        let total = 0;

        Array.from(carritoLista.children).forEach(item => {
            const precioTexto = item.querySelector('span:nth-child(2)').textContent;
            const precio = parseInt(precioTexto.substring(1)); // Elimina el signo "$" y convierte a entero
            const cantidadTexto = item.querySelector('span:nth-child(3)').textContent;
            const cantidad = parseInt(cantidadTexto.split(': ')[1]);
            total += precio * cantidad;
        });

        // Actualizar el elemento en el HTML
        totalCarrito.textContent = total.toFixed(2); // Mostrar el total con dos decimales
    }

    btnsAgregarCarrito.forEach((btn, index) => {
        const productos = [
            { nombre: 'Cafe Latte', precio: '$480' },
            { nombre: 'Cafe Cortado', precio: '$470' },
            { nombre: 'Capuchino', precio: '$460' }
        ];

        btn.addEventListener('click', () => {
            agregarAlCarrito(productos[index]);
            const menuNavbar = document.querySelector('.navbar');
            menuNavbar.classList.add('show');
        });
    });
});
