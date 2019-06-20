$(document).ready(function () {

    $("#tagstudent").autocomplete({
        source: function (request, response) {
            $.ajax({
// basePath is used for defining contecxt-path of the url.
                url: "/autocompletestudent",
                dataType: "json",

                /*
                A Success function to be called if the request succeeds.The function gets
                passed two arguments-
                The data returned from the server, a string describing the status:
                */
                success: function (data) {
                    console.log(data);
                    items = data;
                    response(items);
                },
//if the request fails,A error function to be called.
                error: function (data, type) {
                    console.log(type);
                }
            });
        }
    });

    $("#tagstaff").autocomplete({
        source: function (request, response) {
            $.ajax({
// basePath is used for defining contecxt-path of the url.
                url: "/autocompletestaff",
                dataType: "json",

                /*
                A Success function to be called if the request succeeds.The function gets
                passed two arguments-
                The data returned from the server, a string describing the status:
                */
                success: function (data) {
                    console.log(data);
                    items = data;
                    response(items);
                },
//if the request fails,A error function to be called.
                error: function (data, type) {
                    console.log(type);
                }
            });
        }
    });

    $("#tagfaculty").autocomplete({
        source: function (request, response) {
            $.ajax({
// basePath is used for defining contecxt-path of the url.
                url: "/autocompletefaculty",
                dataType: "json",

                /*
                A Success function to be called if the request succeeds.The function gets
                passed two arguments-
                The data returned from the server, a string describing the status:
                */
                success: function (data) {
                    console.log(data);
                    items = data;
                    response(items);
                },
//if the request fails,A error function to be called.
                error: function (data, type) {
                    console.log(type);
                }
            });
        }
    });

    $("#votingbutton").click(function () {
        alert("Thank you for voting");
        $("#votingform").submit();
    })





});