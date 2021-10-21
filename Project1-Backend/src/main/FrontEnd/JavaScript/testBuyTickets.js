const form = document.getElementById("userPurchaseTickets");
form.addEventListener("submit",function(event) {
    event.preventDefault();
    const {numberOfTickets} = event.target.elements;//object deconstruction using the event, form
    SubmitForm(numberOfTickets);
    console.log(numberOfTickets);
});

async function SubmitForm(){
    let ticketCount = {
        "number":numberOfTickets.value
    }
    let response = await fetch("http://localhost:8080/Project1-Backend/tickets", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(ticketCount)
    });
    console.dir(response.json);
    console.log("FETCH FUNCTION CALLED");

    //let json = response.json();
    document.write(`Success! You purchased ${numberOfTickets.value} tickets.`);
}