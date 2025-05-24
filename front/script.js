const API_URL = "http://localhost:8080/times";

async function readTimes(){
    let timesArea = document.querySelector(".listatimes");
    timesArea.innerHTML = "";

    let response = await fetch(API_URL);
    let json = await response.json();

    if(json.length > 0){

        for(let i in json){
            let timeHTML = `<div>${json[i].nome}</div>`
            timesArea.innerHTML += timeHTML; 
               }
    } else {
        
        timesArea.innerHTML = "Nenhum time para exibir";
        
    }

}

readTimes();