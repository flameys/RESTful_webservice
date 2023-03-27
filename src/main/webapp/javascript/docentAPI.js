alleDocenten()

async function alleDocenten(){
    const response = await fetch('/RESTful_webservice_war_exploded/api/docenten/alle-docenten');
    //console.log(response);


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
        tr+='<td>' +
            '<button id=' + docent.id + ' type="button" ' + 'onclick="deleteDocent(this.id)"' + ' >Delete</button>' +
            '</td>' +
            '<td>'+docent.voornaam+'</td>' + '<td>'+docent.naam+'</td>' + '<td>'+docent.datumIndienst+'</td>' + '<td>'+docent.categorie+'</td>' /*+

                '<td>' +
            '<button class="terug" style="border: none" id=' + docent.id + ' type="button" ' + 'onclick="getOnderdelen(this.id)"' + ' title="Edit">&#10140;</button>' +
                    '</td>'*/
        tr+='</tr>'

    })
    table.innerHTML+=tr;

    console.log(data)

}

async function getOnderdelen(id){

    // window.location.href = "../html/editDocent.html";
    const api = '/RESTful_webservice_war_exploded/api/docenten/docent-onderdelen/' + id;
    const response = await fetch(api);
    //console.log(response);


    const data = await response.json();
    console.log(data)

    const result = JSON.stringify(data);
    console.log(result)

    // document.querySelector('ul').innerHTML = result;
    /*for (let i = 0; i < result; i++) {
        document.querySelector('ul').innerHTML = ;
    }*/
    /*data.forEach(onderdeel =>{
        let displayOnderdelen= `<li>${onderdeel.naam}</li>`
        document.querySelector('ul').insertAdjacentHTML('beforeend', displayOnderdelen);
    });*/

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
            .then(response => {
                if (!response.ok){
                    console.log('Problem')
                    return;
                }
                // response.json;
                alleDocenten();
            })
            .then(data => console.log('yaay!'))
    })

}

async function deleteDocent(id){

    const options = {
        method: "DELETE"
    };

    fetch('/RESTful_webservice_war_exploded/api/docenten/delete-docent/'+ id, options)
        .then(response =>{
            if (!response.ok){
                console.log('Problem')
                return;
            }
            // response.json;
            alleDocenten();
        })
        .then(data => console.log('Succes!!'))

}