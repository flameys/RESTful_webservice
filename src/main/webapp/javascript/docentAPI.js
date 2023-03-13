alleDocenten()

async function alleDocenten(){
    const response = await fetch('/RESTful_webservice_war_exploded/api/docenten/alle-docenten');
    console.log(response);


    const data = await response.json();
    /*data.forEach(docent =>{
        let displayDoc= `<li>${docent.voornaam}, ${docent.naam}</li>`
        document.querySelector('ul').insertAdjacentHTML('beforeend', displayDoc);
    });*/

    var table = document.getElementById("docVulling");
    table.innerHTML="";
    var tr="";
    data.forEach(docent=>{
        tr+='<tr>';
        tr+=/*'<td>'+docent.voornaam+'</td>' + '<td>'+docent.naam+'</td>' + '<td>'+docent.datumIndienst+'</td>' + '<td>'+docent.categorie+'</td>'*/
            `<td>${docent.voornaam}</td>` + `<td>${docent.naam}</td>` + `<td>${docent.datumIndienst}</td>` + `<td>${docent.categorie}</td>`
        tr+='</tr>'

    })
    table.innerHTML+=tr;

    console.log(data)

}

insertDocent()
async function insertDocent(){
    const formEl = document.querySelector('form');
    formEl.addEventListener('submit', function (e){
        e.preventDefault();

        const formData = new FormData(formEl)
        const data = Object.fromEntries(formData)

        const options = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        };
        fetch('/RESTful_webservice_war_exploded/api/docenten/insert-docent', options)
            .then(response => response.json())
            .then(data => console.log(data))
    })

}