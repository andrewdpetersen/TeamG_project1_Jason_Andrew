const form = document.getElementById("userPurchaseTickets");
form.addEventListener("submit",function(event) {
    event.preventDefault();
    const numberOfTickets = form.querySelector("#numberOfTickets");
    const flightID = form.querySelector("#flightID");
    SubmitForm(numberOfTickets);
    console.log(numberOfTickets);
});

async function SubmitForm(){
    let ticketCount = {
        "number":numberOfTickets.value,
        "flight":flightID.value
    }
    let response = await fetch("http://localhost:8080/Project1-Backend/tickets", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(ticketCount)
    });
    console.dir(response.json);
    console.log("FETCH FUNCTION CALLED");

    //let json = response.json();
    document.write(`Success! You purchased ${numberOfTickets.value} tickets on flight #: ${flightID.value}`);
}