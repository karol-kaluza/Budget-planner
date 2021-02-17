$.get("/user/info", function(data) {
  $("#username").html(data.username);
  $("#user-logo").attr("src", data.avatarUrl);
});

$("#expense-form").submit(function(event) {
    event.prevent
})
