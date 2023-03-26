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
        tr+='<td>' +
            '<button id=' + student.id + ' type="button" ' + 'onclick="deleteStudent(this.id)"' + ' >Delete</button>' +
            '</td>' +
            '<td>'+  student.voornaam +'</td>' + '<td>'+student.achternaam+'</td>' + '<td>'+student.studentID +'</td>' +
            '<td>'+student.studentDetail.geboorteDatum+'</td>' +  '<td>'+student.studentDetail.adress+ '<button id=' + student.id + ' type="button" ' + 'onclick="editAdres(this.id)"' + ' >Edit</button>' + '</td>'
            + '<td>'+student.studentDetail.telefoon_nummer+ '<button id=' + student.id + ' type="button" ' + 'onclick="editTel(this.id)"' + ' >Edit</button>' +'</td>'

            /*'<td>'+' <a class="terug" style="text-decoration: none; " href="../html/editStudent.html" title="Edit">&#10140;</a>'+'</td>'
           '<td id="edit">' +
            '<button class="terug" style="border: none" id=' + student.id + ' type="button" ' + 'onclick="getStudentInfo(this.id)"' + ' title="Edit">&#10140;</button>' +
            '</td>'*/
        tr+='</tr>'

    })
    table.innerHTML+=tr;

    console.log(data)
}


async function getStudentInfo(id){

        window.location.href = "../html/editStudent.html";
        const api = '/RESTful_webservice_war_exploded/api/studenten/getStudent/' + id;
        const response = await fetch(api);
        //console.log(response);


        const data = await response.json();
        data.forEach(student =>{
            let displayStudentInfo= `<li>${student.voornaam}</li>` + `<li>${student.achternaam}</li>`
            document.querySelector('ul').insertAdjacentHTML('beforeend', displayStudentInfo);
        });
        console.log(data)

}

insertStudent2()
async function insertStudent2(){
    const form = document.getElementById('insertStudent');



    form.addEventListener('submit', function (e){
        e.preventDefault();

        const voornaam = document.getElementById('voornaam').value
        const achternaam = document.getElementById('achternaam').value
        const studentID = document.getElementById('studentID').value
        const adres = document.getElementById('adres').value
        const geboorte = document.getElementById('geboortedatum').value
        const tel = document.getElementById('telno').value
        const regDate = document.getElementById('datum').value

        const data = {
            'voornaam': voornaam,
            'achternaam': achternaam,
            'studentID': studentID,
            'studentDetail': {'adress': adres,
                'geboorteDatum': geboorte,
                'telefoon_nummer': tel,
                'enrolledDate': regDate
            }
        }

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
        /*
                formEl.forEach(input => {
                    input.value = '';
                });*/
    })
}

async function deleteStudent(id){

        const options = {
            method: "DELETE"
        };

        fetch('/RESTful_webservice_war_exploded/api/studenten/delete-student/'+ id, options)
            .then(response =>{
                if (!response.ok){
                    console.log('Problem')
                    return;
                }
                response.json;
                })
            .then(data => console.log('Succes!!'))

}

async function editAdres(id){
    // const form = document.getElementById('insertStudent');
    const editAdres = document.getElementById('adres')

    const data = {
        'studentDetail': {'adress': editAdres}
    };

    const options = {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    };

    fetch('/RESTful_webservice_war_exploded/api/studenten/update-student/'+ id, options)
        .then(response =>{
            if (!response.ok){
                console.log('Problem')
                return;
            }
            response.json;
        })
        .then(data => console.log('Succes!!'))

}

async function editTel(id){
    // const form = document.getElementById('insertStudent');
    const editTel = document.getElementById('telno')

    const data = {
        'studentDetail': {'telefoon_nummer': editTel}
    };

    const options = {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    };

    fetch('/RESTful_webservice_war_exploded/api/studenten/update-student/'+ id, options)
        .then(response =>{
            if (!response.ok){
                console.log('Problem')
                return;
            }
            response.json;
        })
        .then(data => console.log('Succes!!'))

}
