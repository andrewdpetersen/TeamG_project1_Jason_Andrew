let userportalcheckinform = document.getElementById("user_checkin");
userportalcheckinform.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitUPCIForm();
    userportalcheckinform.reset();
});

async function SubmitUPCIForm() {
    const ctid = userportalcheckinform.querySelector("#checkin_ticket_id");
    let object = {//creates an object in JSON format
        "checkinTicketID": ctid.value,//key is the variable we are assigning the value to

    }
    //local "http://localhost:8080/Project1-Backend/tickets"
    let response = await fetch("http://teamgairportkiosk-env.eba-ymppfvdg.us-east-2.elasticbeanstalk.com/tickets", {
        method: "POST",
        headers: {"Content-Type": "application/json",
        "Servlet-action": "UserCheckin"
        },
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
        body: JSON.stringify(object)//makes the json into a string to send
    });

    return response.text().then(function(){
        alert(`Ticket checked in! Please proceed to gate G to board your flight.`)
    })
}


