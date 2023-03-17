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
        tr+='<td>' +richting.opleiding.naam+ '</td>' + '<td>' +richting.naam+ '</td>' +
            '<td>' +
            '<button class="terug" style="border: none" id=' + richting.id + ' type="button"' + ' title="More">&#10146;</button>' +
            '</td>'

        tr+='</tr>'

    });
    table.innerHTML+=tr;
    console.log(data)
}
