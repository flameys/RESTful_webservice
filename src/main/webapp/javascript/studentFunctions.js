alleStudenten()

async function alleStudenten(){
    const response = await fetch('/api/students/alle-studenten');
    console.log(response);


    const data = await response.json();
    /*data.forEach(country=>{
        /!*const countryList = `<li>${country.name.official}, ${country.capital}</li>`;*!/

        //receive an unordered list in bullet points
        //document.querySelector('ul').insertAdjacentHTML('beforeend', countryList);

        //receive a numbered ordered list
        document.querySelector('ol').insertAdjacentHTML('beforeend', countryList);
    });*/
    //document.querySelector('p').textContent = data;
    console.log(data)

}


/*
function alleStudenten(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let studentenList = JSON.parse(this.responseText);
            console.log(studentenList);


    };

    xhttp.open("GET", "/api/studenten/actieve-diensten", true);
    xhttp.send();
}*/
