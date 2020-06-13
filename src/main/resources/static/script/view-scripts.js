
function deleteBtnClickHandler(event) {
    event.preventDefault();
    if (confirm('Are you sure want to delete?')){
        let form = document.querySelector("form");
        form.action="/delete";
        form.submit();
    }
}

function init() {
    document.getElementById("delete-btn").addEventListener('click', deleteBtnClickHandler, false);
}

document.addEventListener("DOMContentLoaded", init);

