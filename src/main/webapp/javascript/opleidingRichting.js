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
        tr+='<td>' +richting.opleiding.naam+ '</td>' + '<td>' +richting.naam+ '</td>' /*+
            '<td>' +
            '<button class="terug" style="border: none" id=' + richting.id + ' type="button"' + 'onclick="alleModules(this.id)"' + ' title="More">&#10146;</button>' +
            '</td>'*/

        tr+='</tr>'

    });
    table.innerHTML+=tr;
    console.log(data)
}

async function alleModules(id){
    const api = '/RESTful_webservice_war_exploded/api/opleidingen/alle-modules/' + id;
    const response = await fetch(api)
    const data = response.json()
    console.log(data)
    /*data.forEach(module =>{
        let displayModules= `<li>${module.naam}, ${module.duur}</li>`
        document.querySelector('ul').insertAdjacentHTML('beforeend', displayModules);
    });*/
}
