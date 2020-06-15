function deleteBtnClickHandler(event) {
    event.preventDefault();
    let noItemsSelectedMessage = document.getElementById("no-items-selected-message").textContent;
    let confirmDeleteMessagePartOne = document.getElementById("list-confirm-delete-message-part-one").textContent;
    let confirmDeleteMessagePartTwo = document.getElementById("list-confirm-delete-message-part-two").textContent;
    let checkboxes = document.getElementsByClassName("delete-mark");
    let amountToDelete = 0;
    for (let index = 0; index < checkboxes.length; index++) {
        if (checkboxes[index].checked) {
            amountToDelete++;
        }
    }
    if (amountToDelete === 0) {
        alert(noItemsSelectedMessage);
    } else {
        if (confirm(confirmDeleteMessagePartOne + amountToDelete +" " + confirmDeleteMessagePartTwo)) {
            let form = document.querySelector("form");
            form.action = "/delete-multiple";
            form.submit();
        }
    }
}

function init() {
    document.getElementById("delete-btn").addEventListener('click', deleteBtnClickHandler, false);
}

document.addEventListener("DOMContentLoaded", init);
