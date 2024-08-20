document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.getElementById('searchInput');
    const books = document.querySelectorAll('.card-body');


    searchInput.addEventListener('input', function() {
        const searchTerm = searchInput.value.trim().toLowerCase();


        books.forEach(book => {
            const title = book.querySelector('.card-title').innerText.toLowerCase();
            const author = book.querySelector('.card-author').innerText.toLowerCase();


            if (title.includes(searchTerm) || author.includes(searchTerm)){
                book.style.display = 'block';
            } else {
                book.style.display = 'none';
            }
        });
    });
});
