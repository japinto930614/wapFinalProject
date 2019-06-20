$(document).ready(function () {

//Delete AJAX

    $(".delete").click(function () {
        var id = +this.id;
        $.ajax({
            url: "/student",
            type: "get",
            data: {
                studentId: id,
                command: "DELETE"
            },
            success: function (data) {
                alert(data); // alerts the response from jsp
                location.reload();
            }
        });
    });

    //Update AJAX

    $(".update").click(function () {
        var id = +this.id;
        var inputObject = "input#"+id+".password";
        var newPassword = $(inputObject).val();
        $.ajax({
            url: "/student",
            type: "get",
            data: {
                id: id,
                password : newPassword,
                command: "UPDATE"
            },
            success: function (data) {
                 alert(data); // alerts the response from jsp
                location.reload();
            }
        });
    });

    //Add AJAX

    // $(".insert").click(function () {
    //     var newUsername = $(".username").val();
    //     var newPassword = $("#new.password").val();
    //     $.ajax({
    //         url: "/student",
    //         type: "get",
    //         data: {
    //             username: newUsername,
    //             password : newPassword,
    //             type: "Student",
    //             command: "ADD"
    //         },
    //         success: function (data) {
    //             // alert(data); // alerts the response from jsp
    //             location.reload();
    //         }
    //     });
    // });

    //Another way to do add student ajax

    $(".insert").click(function () {
        var newUsername = $(".username").val();
        var newPassword = $("#new.password").val();
        $.get("/student",{username : newUsername, password: newPassword, type: "Student", command : "ADD"})
            .done(success).fail(failed);
    });
    function success(){
        location.reload();
    }
    function failed() {
        alert("failed");
    }



});
