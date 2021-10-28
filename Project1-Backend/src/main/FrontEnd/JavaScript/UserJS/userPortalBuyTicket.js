var dbg = true;
if(dbg){console.log("DEBUG- ScriptReached");}
let userportalbuyticketsform = document.getElementById("user_purchase_tickets");//T
userportalbuyticketsform.addEventListener("submit",function(event) {
    event.preventDefault();//prevents the default "submit" event
    if(dbg){console.log("DEBUG- EventListener Added");}
    SubmitUPBTForm();
    userportalbuyticketsform.reset();
});

async function SubmitUPBTForm() {
    const nots = userportalbuyticketsform.querySelector("#numberOfTickets");
    const ufid = userportalbuyticketsform.querySelector("#userFlightID");
    const queryString = window.location.search;
    const user_ID = new URLSearchParams(queryString).get("userID");
    console.log(user_ID);
    let object = {//creates an object in JSON format
        "numberOfTickets": nots.value,//key is the variable we are assigning the value to
        "userFlightID": ufid.value,//the value comes from form input
    }
    //local "http://localhost:8080/Project1-Backend/tickets"
    //remote "http://teamgairportkiosk-env.eba-ymppfvdg.us-east-2.elasticbeanstalk.com/tickets"
    let response = await fetch("http://localhost:8080/Project1-Backend/tickets", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Servlet-action": "UserPurchaseTickets",
            "user_id":user_ID
        },
        //one to add an object, one to update, one to delete, one to get one object, one to get a list
        body: JSON.stringify(object)//makes the json into a string to send
    });

    return await response.text().then(function(){
        console.log(response.status)
        if(response.status==200) {
            alert("Ticket successfully purchased! Please go to the counter to get your confirmation number.");
        }else{
            alert("The flight you selected has already departed");
        }
    });
}