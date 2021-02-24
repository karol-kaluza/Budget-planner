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
      <td><button type="button" class="delete-expense btn btn-outline-danger btn-sm" onclick="deleteExpense(${object.uuid})">Delete</button></td>
    </tr>`).appendTo("#category-table");
    }
  });
}


//Handle expenses edit
const toggleExpenseTools = () => {
  document.querySelectorAll(".delete-expense").forEach(item => item.classList.toggle("d-none"));
};

toggleExpenseTools();

const deleteExpense = (id) => {
  $.ajax({
    url: `/expense/${id}`,
    type: 'DELETE',
    success: function(result) {
      location.reload();
    }
  })
};

//Handle incomes edit
const toggleIncomeTools = () => {
  document.querySelectorAll(".delete-income").forEach(item => item.classList.toggle("d-none"));
};

toggleIncomeTools();

const deleteIncome = (id) => {
  $.ajax({
    url: `/income/${id}`,
    type: 'DELETE',
    success: function(result) {
      location.reload();
    }
  })
};

//Handle time filtering
const yearInput = document.getElementById("year");
const monthInput = document.getElementById("month");

const selectInput = function() {
  let value = this.value;
  if(value != "All") {
    if(isNaN(value)) {
      var months = ["january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"];
      value = months.indexOf(value) + 1;
      window.location.href = `${window.location.href}/${value}`;
    } else {
      window.location.href = `${window.location.origin}/main/${value}`;
    }
  } else {
    window.location.href = `${window.location.origin}/main`;
  }
}

monthInput.addEventListener('input', selectInput);
yearInput.addEventListener('input', selectInput);
  

if(yearInput.value == "All") {
  monthInput.disabled = true;
};
