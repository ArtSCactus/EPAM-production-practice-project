
function deleteBtnClickHandler(event) {
    event.preventDefault();
    let message = document.getElementById("confirm-delete-message").textContent;
    if (confirm(message)){
        let form = document.querySelector("form");
        form.action="/delete";
        form.submit();
    }
}

function init() {
    document.getElementById("delete-btn").addEventListener('click', deleteBtnClickHandler, false);
}

document.addEventListener("DOMContentLoaded", init);

