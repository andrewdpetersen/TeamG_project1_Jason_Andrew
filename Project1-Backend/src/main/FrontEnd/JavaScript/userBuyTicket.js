
    const buyTicketsButton = document.getElementById("BuyTickets");
    const numberOfTickets = document.getElementById("numberOfTickets");
    console.log("DEBUG GET FORM BY ID");
    buyTicketsButton.onclick = async (event) => {
        event.preventDefault();
        let TicketNumber = {
            "number":numberOfTickets
        };
        console.log("TICKET NUMBER FOUND");
        let response = await fetch("http://localhost:8080/Project1-Backend/tickets", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(TicketNumber)
        });
        console.dir(response.json);
        console.log("FETCH FUNCTION CALLED");

        //let json = response.json();
        document.write("Success");


    };


    // form.addEventListener("submit",function(event){
    //     event.preventDefault();
    //     const { numberOfTickets } = event.target.elements;
    //     SubmitForm(numberOfTickets);
    //     console.log(numberOfTickets);
    // });

