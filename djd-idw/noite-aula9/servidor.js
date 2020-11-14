const express = require('express');

const app = express();

app.use(express.static('./public'));

function contato(request, response) { 
    response.send('<h1>Contato</h1>');
}

function credito(request, response) { 
    response.send('<h1>Credito</h1>');
}

function servidorIniciado() { 
    console.log("Servidor iniciado");
}

app.get("/contato", contato);

app.get("/credito", credito);


app.listen(80, servidorIniciado);