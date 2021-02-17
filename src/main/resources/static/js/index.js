

const toggleModalVisibility = (modal, visibility) => {
  if (!visibility) {
    modal.classList.remove("d-none");
  } else {
    modal.classList.add("d-none")
  }
  visibility = !visibility;
};

//Add expense form
const expenseForm = document.querySelector('#expense-form');
const addExpenseBtn = document.querySelector('#add-expense');

let expenseFormVisible = false;

expenseForm.classList.add("d-none");
addExpenseBtn.addEventListener("click", toggleModalVisibility(expenseForm, expenseFormVisible));


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

//Add income form
const incomeForm = document.querySelector('#income-form');
const addIncomeBtn = document.querySelector('#add-income');

let incomeFormVisible = false;

incomeForm.classList.add("d-none");
addIncomeBtn.addEventListener("click", toggleModalVisibility(incomeForm, incomeFormVisible));

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

// $.get("/user/info", function(data) {
//   $("#username").html(data.username);
//   $("#user-logo").attr("src", data.avatarUrl);
// });

