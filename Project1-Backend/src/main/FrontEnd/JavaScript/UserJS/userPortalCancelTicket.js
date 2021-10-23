const form = document.getElementById("user_cancel_tickets");
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    const ucts = form.querySelector("#user_cancel_ticket_id");
    SubmitForm();
});

async function SubmitForm() {
    let object = {//creates an object in JSON format
        "userCancelTickeID": ucts.value,//assigning the value to send to servlet via fetch.
    }

    let response = await fetch("http://localhost:8080/Project1-Backend/tickets", {
        method: "POST",
        headers: {"Content-Type": "application/json",
        "Servlet-action" : "UserCancelTicket"
        },
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
        body: JSON.stringify(object)//makes the json into a string to send
    });
}

// TODO: add response logic if necessary - "Tickets canceled, money refunded, have a nice day.... Somewhere else."
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here