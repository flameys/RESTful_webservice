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
            '<td>'+student.studentDetail.geboorteDatum+'</td>' +  '<td>'+student.studentDetail.adress+ '</td>' + '<td>'+student.studentDetail.telefoon_nummer+'</td>' +
            /*'<td>'+' <a class="terug" style="text-decoration: none; " href="../html/editStudent.html" title="Edit">&#10140;</a>'+'</td>'
      */      '<td id="edit">' +
            '<button class="terug" style="border: none" id=' + student.id + ' type="button" ' + 'onclick="getStudentInfo(this.id)"' + ' title="Edit">&#10140;</button>' +
            '</td>'
        tr+='</tr>'

    })
    table.innerHTML+=tr;

    console.log(data)
}


async function getStudentInfo(id){

        // window.location.href = "../html/editStudent.html";
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

insertStudent1()
async function insertStudent1(){
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
/*
        formEl.forEach(input => {
            input.value = '';
        });*/
    })
}
/*
insertStudent2()
async function insertStudent2(){
    const form = document.getElementById('insertStudent');
    const voornaam = form.elements['voornaam'].value
    const achternaam = form.elements['achternaam'].value
    const studentID = form.elements['studentID'].value
    const adres = form.elements['studentDetail.adress'].value
    const geboorte = form.elements['studentDetail.geboorteDatum'].value
    const tel = form.elements['studentDetail.telefoon_nummer'].value
    const regDate = form.elements['studentDetail.enrolledDate'].value

    const data = {voornaam, achternaam, studentID, adres, geboorte, tel, regDate}

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
    /!*
            formEl.forEach(input => {
                input.value = '';
            });*!/

}*/

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
