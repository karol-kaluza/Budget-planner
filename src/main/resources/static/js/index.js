$.get("/user/info", function(data) {
  $("#username").html(data.username);
  $("#user-logo").attr("src", data.avatarUrl);
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
