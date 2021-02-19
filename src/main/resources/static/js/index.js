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

// $.get("/user/info", function(data) {
//   $("#username").html(data.username);
//   $("#user-logo").attr("src", data.avatarUrl);
// });

const chooseCategory = () => {
  console.log(this);
  $.get(`/expense/Rozrywka`, function(data) {
    console.log(data);
    $("#preview").html(data);
  });
}

