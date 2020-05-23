/* // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
$(document).on("click", "#somebutton", function() {
    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
    $.get("someservlet", function(responseJson) {
        // Locate HTML DOM element with ID "someselect".
        var $select = $("#someselect");
        // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
        $select.find("option").remove();
        // Iterate over the JSON object.
        $.each(responseJson, function(key, value) {
            // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
            $("<option>").val(key).text(value).appendTo($select);
        });
    });
});*/