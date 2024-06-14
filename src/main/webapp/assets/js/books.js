function manageLikes(idBook) {
    let baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikesPro_war/favorBook?idBook=" + idBook;

    fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'text',
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