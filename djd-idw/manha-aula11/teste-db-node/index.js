const path = require('path');
const express = require('express');
const mysql = require('mysql');

const app = express();

const conn = mysql.createConnection({
    host: '127.0.0.1',
    user: 'root',
    password: '123456',
    database: 'jogosdb'
});

conn.connect((err) => {
    if (err) { 
        console.log('Erro ao acessar o banco de dados: ', err.sqlMessage);
        throw err;
    } else { 
        console.log('Conectado no banco de dados');
    }
});

const staticDirectory = path.join(__dirname, './public');
app.use(express.static(staticDirectory));
app.set('view engine', 'hbs');

app.get('/jogo', (request, response) => { 
    response.render('jogo', {});
});

app.get('/jogo/inserir', (request, response) => { 
    console.log("Titulo: ", request.query.titulo);
    conn.query("INSERT INTO jogos SET ?", request.query, (err, res) => { 
        if (err) { 
            console.log("Erro ao inserir: ", err.sqlMessage);
        } else { 
            console.log("Inserido com sucesso: ", res);
        }
    })
    response.render('jogo', {});
});

app.listen(80, ()=>{
    console.log("Servidor iniciado: http://localhost:80");
});