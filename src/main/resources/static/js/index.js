$.get("/user/info", function(data) {
  $("#username").html(data.username);
  $("#user-logo").attr("src", data.avatarUrl);
});
