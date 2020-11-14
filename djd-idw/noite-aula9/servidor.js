const express = require('express');

const app = express();

app.set('view engine', 'hbs');

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

app.get("/teste", (request, response) => { 
    console.log("Nome:", request.query.nome);
    console.log("Telefone:", request.query.telefone);
    response.render('teste', {
        nome: request.query.nome, 
        telefone: request.query.telefone
    });
})


app.listen(80, servidorIniciado);