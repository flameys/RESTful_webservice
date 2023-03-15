alleStudenten()

async function alleStudenten(){
    const response = await fetch('/RESTful_webservice_war_exploded/api/studenten/alle-studenten');
    console.log(response);

    const data = await response.json();
    /*data.forEach(student =>{
        let displayStud= `<li>${student.voornaam}, ${student.achternaam}</li>`
        document.querySelector('ul').insertAdjacentHTML('beforeend', displayStud);
    });*/

    var table = document.getElementById("stuVulling");
    table.innerHTML="";
    var tr="";
    data.forEach(student=>{
        tr+='<tr>';
        tr+='<td>'+ student.voornaam +'</td>' + '<td>'+student.achternaam+'</td>' + '<td>'+student.studentID +'</td>' +
            '<td>'+student.studentDetail.geboorteDatum+'</td>' +  '<td>'+student.studentDetail.adress+'</td>' + '<td>'+student.studentDetail.telefoon_nummer+'</td>' +
            '<td>'+' <a class="terug" style="text-decoration: none; " href="../html/editStudent.html" title="Edit">&#10140;</a>'+'</td>'
        tr+='</tr>'

    })
    table.innerHTML+=tr;

    console.log(data)
}

insertStudent()
async function insertStudent(){
    const formEl = document.getElementById('insertStudent');
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
        fetch('/RESTful_webservice_war_exploded/api/studenten/insert-student', options)
            .then(response => response.json())
            .then(data => console.log(data))
    })
}
