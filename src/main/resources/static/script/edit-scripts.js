function submitSaveForm(event) {
    event.preventDefault();
let form = document.getElementById("note-form");
form.submit();
}

function init() {
    document.getElementById("edit-btn").addEventListener('click', submitSaveForm, false);
}

document.addEventListener("DOMContentLoaded", init);