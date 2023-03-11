/*
alleStudenten()

async function alleStudenten(){
    const response = await fetch('/api/students/alle-studenten');
    console.log(response);


    const data = await response.json();
    /!*data.forEach(country=>{
        /!*const countryList = `<li>${country.name.official}, ${country.capital}</li>`;*!/

        //receive an unordered list in bullet points
        //document.querySelector('ul').insertAdjacentHTML('beforeend', countryList);

        //receive a numbered ordered list
        document.querySelector('ol').insertAdjacentHTML('beforeend', countryList);
    });*!/
    //document.querySelector('p').textContent = data;
    console.log(data)

}
*/

alleOpleidingen()

async function alleOpleidingen(){
    const response = await fetch('/RESTful_webservice_war_exploded/api/opleidingen/alle-opleidingen');
    document.getElementById('opleiding');
  /*  console.log(response);*/

    const data = await response.json();


    /*data.forEach(opleiding =>{
        let displayOpl = `<li>${opleiding.naam}</li>`
        document.querySelector('ul').insertAdjacentHTML('beforeend', displayOpl);
    });
*/
    var table = document.getElementById("vulling");
    table.innerHTML="";
    var tr="";
    data.forEach(opl=>{
        tr+='<tr>';
        tr+='<td>'+opl.naam+'</td>'
        tr+='</tr>'

    })
    table.innerHTML+=tr;

    console.log(data);
}

async function alleRichtingenVanOpleiding(){
    const response = await fetch('/RESTful_webservice_war_exploded/api/opleidingen/alle-richtingen');
    const data = await response.json();
    console.log(data);
}



