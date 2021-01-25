const modal = document.querySelector('form');
const addExpenseBtn = document.querySelector('#add-expense');

let isvisible = false;
modal.classList.add("d-none");

const toggleModalVisibility = () => {
  if (!isvisible) {
    modal.classList.remove("d-none");
  } else {
    modal.classList.add("d-none")
  }
  isvisible = !isvisible;
}


addExpenseBtn.addEventListener("click", toggleModalVisibility);
