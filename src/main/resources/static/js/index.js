const expenseForm = document.querySelector('#expense-form');
const incomeForm = document.querySelector('#income-form');


//Add expense form
const addExpenseBtn = document.querySelector('#add-expense');
let expenseFormVisible = false;

addExpenseBtn.addEventListener("click", () => {
  if (!expenseFormVisible) {
    expenseForm.classList.remove("d-none");
  } else {
    expenseForm.classList.add("d-none")
  }
  expenseFormVisible = !expenseFormVisible;
});


$("#expense-form").submit(function(event) {
  event.preventDefault();

  var $form = $(this),
    name = $form.find( "input[name='name']" ).val(),
    category = $form.find( "input[name='categoryName']" ).val(),
    value = $form.find( "input[name='value']" ).val(),
    date = $form.find( "input[name='date']" ).val();

  var posting = $.post( "/expense", {
  name: name,
  categoryName: category,
  value: value,
  date, date });

  posting.done(function() {
  location.reload();
  });
});

// //Add income form
const addIncomeBtn = document.querySelector('#add-income');
let incomeFormVisible = false;

addIncomeBtn.addEventListener("click", () => {
  if (!incomeFormVisible) {
    incomeForm.classList.remove("d-none");
  } else {
    incomeForm.classList.add("d-none")
  }
  incomeFormVisible = !incomeFormVisible;
});

$("#income-form").submit(function(event) {
  event.preventDefault();

  var $form = $(this),
    name = $form.find( "input[name='name']" ).val(),
    value = $form.find( "input[name='value']" ).val(),
    date = $form.find( "input[name='date']" ).val();

  var posting = $.post( "/income", {
  name: name,
  value: value,
  date, date });

  posting.done(function() {
  location.reload();
  });
});


//Category selection
const selectCategory = (categoryName) => {
  document.querySelector("#all-expenses").classList.toggle("d-none");
  document.querySelector("#selected-expenses").classList.toggle("d-none");

  $.get(`/expense/${categoryName}`, function(data) {
    $("#category-table").html("");
    $("#category-name").html(categoryName);
    for (const object of data) {
      $(`<tr>
      <td>${object.name}</td>
      <td>${object.value}</td>
      <td>${object.date}</td>
    </tr>`).appendTo("#category-table");
    }
  });
}

const currancyInput = document.getElementById("currency");

const selectCurrencyInput = function() {
  let value = this.value;
  if(value != "EUR") {
    window.location.href = `${window.location.origin}/main/${value}`;
  } else {
    window.location.href = `${window.location.origin}/main`;
  }
}
