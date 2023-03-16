alleRichtingenVanOpleiding()

async function alleRichtingenVanOpleiding(){
    const response = await fetch('/RESTful_webservice_war_exploded/api/opleidingen/alle-richtingen');
    console.log(response);


    const data = await response.json();

    var table = document.getElementById("tabelRichting");
    table.innerHTML="";
    var tr="";
    data.forEach(richting=>{
        tr+='<tr>'
        tr+='<td>' +richting.opleiding.naam+ '</td>' + '<td>' +richting.naam+ '</td>'
        tr+='</tr>'

    });
    table.innerHTML+=tr;
    console.log(data)
}
