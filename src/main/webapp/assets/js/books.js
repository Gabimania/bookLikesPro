// Función para mostrar el modal


function showEditForm(idBook) {

    const modalContainer = document.getElementById('modalContainer' + idBook);
    modalContainer.classList.add('active'); // Agrega la clase 'active' para mostrar el modal
}

// Función para ocultar el modal
function hideEditForm(idBook) {
    const modalContainer = document.getElementById('modalContainer' + idBook);
    modalContainer.classList.remove('active'); // Remueve la clase 'active' para ocultar el modal
}


function deleteBook(idBook) {
    let baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikesPro_war_exploded/deleteBook?idBook=" + idBook;

    fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'text',
        },

    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("bookInfoDiv").innerHTML = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}




function manageLikes(idBook) {

    let baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikesPro_war_exploded/likes?idBook=" + idBook;



    fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'text/plain', // Ajuste menor del tipo de contenido
        },
    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("likesManager" + idBook).innerHTML = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
