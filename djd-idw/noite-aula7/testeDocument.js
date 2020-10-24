
window.onload = (ev) => { 
    console.log("Window Onload");
    let p1 = document.getElementById("p1");
    console.log("Paragrafo P1 Capturado Depos da função window.onload: ", p1);
}

document.onreadystatechange = (ev) => { 
    console.log("Document OnReadyStateChange");
    console.log(ev);
}

console.log("Teste do objeto Document");
let p1 = document.getElementById("p1");
console.log("Paragrafo P1 Capturado Antes: ", p1);