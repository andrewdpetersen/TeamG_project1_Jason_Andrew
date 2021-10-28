let userportalcancelform = document.getElementById("user_cancel_tickets");
userportalcancelform.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    SubmitUPCTForm();
    userportalcancelform.reset();
});

async function SubmitUPCTForm() {
    const ucts = userportalcancelform.querySelector("#user_cancel_ticket_id");
    const queryString = window.location.search;
    const user_ID = new URLSearchParams(queryString).get("userID");
    let object = {//creates an object in JSON format
        "userCancelTickeID": ucts.value,//assigning the value to send to servlet via fetch.
        "userID":user_ID
    }
    //local "http://localhost:8080/Project1-Backend/tickets"
    //remote "http://teamgairportkiosk-env.eba-ymppfvdg.us-east-2.elasticbeanstalk.com/tickets"
    let response = await fetch("http://localhost:8080/Project1-Backend/tickets", {
        method: "POST",
        headers: {"Content-Type": "application/json",
        "Servlet-action" : "UserCancelTicket"
        },
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
        body: JSON.stringify(object)//makes the json into a string to send
    });

    return await response.text().then(function(){
        console.log(response.status)
        if(response.status==200){
            alert(`Ticket cancelled. Thank you for using AirPortal.`);
        }else if(response.status==400){
            alert("The flight you selected has already departed");
        }else{
            alert("That ticket does not belong to you, please try again.");
        }
    });
}