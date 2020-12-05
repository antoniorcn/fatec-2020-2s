const express = require('express');
const path = require('path');
const mysql = require('mysql');
const { allowedNodeEnvironmentFlags } = require('process');

const app = express();

const conn = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '123456',
    database: 'jogosdb'
});

conn.connect((err) => {
    if (err) throw err;
    console.log("Conectado no banco de dados");
});

const publicDir = path.join(__dirname, '/public');
console.log('Diretorio Public: ', publicDir);

app.use(express.static(publicDir));
app.set('view engine', 'hbs');

app.get('/jogo', (request, response) => {
    response.render('jogo', {});
});

app.get('/jogo-adicionar', (request, response) => {
    // const obj = {
    //     nome: request.query.nome,
    //     genero: request.query.genero,
    //     preco: request.query.preco
    // };
    // conn.query("INSERT INTO jogos SET ?", obj)
    conn.query("INSERT INTO jogos SET ?", request.query, (err, res) => {
        if (err) throw err;
        console.log("inserido com sucesso");
    });
    response.render('jogo', {});
});

app.listen(80, () => {
    console.log("Servidor iniciado http://localhost:80");
});