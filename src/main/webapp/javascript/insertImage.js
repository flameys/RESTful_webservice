insertImageDans().catch(error =>{
    console.log('error error error')
    console.error(error)
});

async function insertImageDans(){
    const response = await fetch('../../../pictures/joged.jpg');
    const blob = await response.blob();
    document.getElementById('dansfoto').src = URL.createObjectURL(blob);
}

insertImageTaal().catch(error =>{
    console.log('error error error')
    console.error(error)
});

async function insertImageTaal(){
    const response = await fetch('../../../pictures/381px-Mss_jav_28_f013v.png');
    const blob = await response.blob();
    document.getElementById('taalfoto').src = URL.createObjectURL(blob);
}

insertImageGamelan().catch(error =>{
    console.log('error error error')
    console.error(error)
})

async function insertImageGamelan(){
    const response = await fetch('../../../pictures/Traditional_indonesian_instruments02.jpg');
    const blob = await response.blob();
    document.getElementById('gamelanfoto').src = URL.createObjectURL(blob);
}

insertImageLogo().catch(error =>{
    console.log('error error error')
    console.error(error)
})

async function insertImageLogo(){
    const response = await fetch('../../pics/kratonJogja.png');
    const blob = await response.blob();
    document.getElementById('logofoto').src = URL.createObjectURL(blob);
}

insertImageLogIn().catch(error =>{
    console.log('error error error')
    console.error(error)
})

async function insertImageLogIn(){
    const response = await fetch('../../../pictures/gunungan.png');
    const blob = await response.blob();
    document.getElementById('loginfoto').src = URL.createObjectURL(blob);
}

