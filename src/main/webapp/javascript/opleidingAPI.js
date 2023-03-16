alleOpleidingen()

async function alleOpleidingen(){
    const response = await fetch('/RESTful_webservice_war_exploded/api/opleidingen/alle-opleidingen');
    /*document.getElementById('opleiding');*/
  /*  console.log(response);*/

    const data = await response.json();


    /*data.forEach(opleiding =>{
        let displayOpl = `<li>${opleiding.naam}</li>`
        document.querySelector('ul').insertAdjacentHTML('beforeend', displayOpl);
    });
*/
    var table = document.getElementById("oplVulling");
    table.innerHTML="";
    var tr="";
    data.forEach(opleiding=>{
        tr+='<tr>'
        tr+='<td>' +opleiding.naam+ '</td>'
        tr+='</tr>'

    });
    table.innerHTML+=tr;

    console.log(data);
}





