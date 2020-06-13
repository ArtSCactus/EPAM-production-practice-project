
function deleteBtnClickHandler(event) {
    event.preventDefault();
    let amountOfDeletingItems = document.getElementsByName("delete-mark");
    if (confirm('Are you sure want to delete? '+amountOfDeletingItems + ' item will be deleted.')){
        let form = document.querySelector("form");
        form.action="/delete-multiple";
        form.submit();
    }
}

function init() {
    document.getElementById("delete-btn").addEventListener('click', deleteBtnClickHandler, false);
}

document.addEventListener("DOMContentLoaded", init);
