const form = document.getElementById("user_checkin");
form.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    const ctid = form.querySelector("#checkin_ticket_id");
    SubmitForm();
});

async function SubmitForm() {
    let object = {//creates an object in JSON format
        "checkinTicketID": ctid.value,//key is the variable we are assigning the value to

    }
    let response = await fetch("http://localhost:8080/Project1-Backend/tickets", {
        method: "POST",
        headers: {"Content-Type": "application/json",
        "Servlet-action": "UserCheckin"
        },
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
        body: JSON.stringify(object)//makes the json into a string to send
    });
}

// TODO: add response logic if necessary - return CHECKED IN for Flight bbbbxxxxx
//The only times we need a response: user-Flights, admin-Manifest, admin-Flights

//let json = response.json();
//And the response logic goes here


